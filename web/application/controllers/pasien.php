<?php

class pasien extends CI_Controller {
    public function __construct()
    {
		parent::__construct();
        $this->load->model('m_login');
        $this->load->model('m_pasien');
        $this->load->model('m_backup');
	}
    
	function index()
	{
        //view manajemen pasien
        if($this->session->userdata('status') != "login"){
			redirect(base_url("admin"));
		}
        else if($this->session->userdata('status') == "login"){
            //menampilkan status user
            $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
			$data = [   
                'permission' => $mission,
                'pasien' => $this->m_pasien->getAll(), 
                'breadcrumb' => "Daftar Pasien",
                'content' => 'admin/content/man_pasien'
                ];
            $this->load->view("admin/index", $data);
		} 
	}
    //form tambah pasien baru
    function form_tambah()
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
			$data = [   
                'permission' => $mission,
                'breadcrumb' => "Tambah Pasien Baru",
                'content' => 'admin/content/form_pasien'
                ];
            $this->load->view("admin/index", $data);
		} 
    }
    //manajemen pasien
    function tambah_pasien()
    {
        //save data baru pasien
        $modelpasien = $this->m_pasien;
        $modelpasien->save();
        
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            $this->index();
        }
    }
    //edit data pasien
    function edit_pasien($id)
    {
        if($this->session->userdata('status') != "login"){
			redirect(base_url("admin"));
		}
        else if($this->session->userdata('status') == "login"){
          $where = array('pas_index' => $id);
          //menampilkan status user
          $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
          $data = [   
                'permission' => $mission,
                'pasien' => $this->m_pasien->edit_data($where,'pasien')->result(),
                'breadcrumb' => "Edit Pasien",
                'content' => 'admin/content/form_edit_pasien'
                ];
          $this->load->view("admin/index", $data);
		}
    }
    function update_pasien()
    {
        //update data pasien berdasarkan data baru
        $modelpasien = $this->m_pasien;
        $modelpasien->update();
        
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            $this->index();
        }
    }    
}