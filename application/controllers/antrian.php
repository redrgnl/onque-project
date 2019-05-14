<?php

class antrian extends CI_Controller {
    public function __construct()
    {
        parent::__construct();
        $this->load->model('m_login');
        $this->load->model('m_antrian');
    }
    
    function index()
    {
        
    }
    
    //function tambah antrian baru
    function form_antrian()
    {
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
                'breadcrumb' => "Tambah Antrian Baru",
                'content' => 'admin/content/form_antrian'
                ];
            $this->load->view("admin/index", $data);
		} 
    }
}
?>