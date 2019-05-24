<?php

class laporan extends CI_Controller {
    public function __construct()
    {
		parent::__construct();
        $this->load->model('m_login');
	}
    
	function index()
	{
        //view manajemen pasien
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
            $data = [   
                'permission' => $mission,
                'breadcrumb' => "Laporan Riwayat Antrian",
                'content' => 'admin/content/laporan'
                ];
            $this->load->view("admin/index", $data);
        }
	}    
}