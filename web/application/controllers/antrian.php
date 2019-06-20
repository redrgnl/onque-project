<?php

class antrian extends CI_Controller {
    public function __construct()
    {
        parent::__construct();
        $this->load->model('m_login');
        $this->load->model('m_antrian');
        $this->load->model('m_pasien');
    }
    
    function index()
    {
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            //menampilkan status user
            $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
            
            //antrian nomer terakhir
            $result = $this->m_antrian->antrian_trakhir();
            foreach($result as $lastdata){
                $dataterakhir = $lastdata->nomor_urut;
            }
            
            //foreach nomor dan id antrian sekarang 
            $sekarang = $this->m_antrian->antrian_sekarang();
            foreach($sekarang as $antrian){
                $idantri = $antrian->id_antrian;
                $nomorantri = $antrian->nomor_urut;
                $poliantri = $antrian->nama_poli;
            }
            
            //kondisi jika tidak ada antrian
            if(empty($idantri)){
                $idantri = "kosong";
                $nomorantri = "Antrian Tuntas";
                $poliantri = "Tidak Ada Antrian Pasien";
                $dataterakhir = "Belum ada Antrian";
            } 
            
            //daftar antrian pada hari ini
            $daftar = $this->m_antrian->tampil();
            
            $data = [
                'id' => $idantri,
                'nomor' => $nomorantri,
                'poli' => $poliantri,
                'last_data' => $dataterakhir,
                'daftar_antrian' => $daftar,
                'permission' => $mission,
                'breadcrumb' => "Tambah Antrian Baru",
                'content' => 'admin/content/man_antrian'
                ];
            $this->load->view("admin/index", $data);
        }
    }

    function form_antrian()
    {
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            //menampilkan status user
            $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
            //daftar pasien terdaftar
            $pasien = $this->m_pasien->getAll();
            //auto number antrian
            $query = $this->m_antrian->autonumber();
            $data = [
                'auto' => $query,
                'pasien' => $pasien,
                'permission' => $mission,
                'breadcrumb' => "Tambah Antrian Baru",
                'content' => 'admin/content/form_antrian'
                ];

        $this->load->view("admin/index", $data);
        }
    }

    function antrianpasien()
    {
        $post = $this->input->post();
        $index = $post["pasIndex"];
        
        //check antrian telah mendaftar atau belum
        $check = $this->m_antrian->checkantrian($index);
        
        //jika check tidak ada antrian sama
        if(empty($check)){
            //tambah antrian
            $this->m_antrian->tambahantrian();
            if($this->session->userdata('status') != "login"){
                redirect(base_url("admin"));
            }
            else if($this->session->userdata('status') == "login"){
                redirect(base_url("antrian"));
            }   
        } else {
            redirect(base_url("antrian/form_antrian"));
        }
    }

    function next($id)
    {
        //melanjutkan ke nomor selanjutnya
        $this->m_antrian->next($id);
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            redirect(base_url("antrian"));
        }
    }
    
    function skip($id)
    {
        //skip ke nomer selanjutnya 
        $this->m_antrian->skip($id);
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            redirect(base_url("antrian"));
        }
    }
    
    function update($id)
    {
        //update data antrian
        $this->m_antrian->update($id);
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            redirect(base_url("antrian"));
        }
    }

}

?>