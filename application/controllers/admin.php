<?php

class admin extends CI_Controller {
    public function __construct()
    {
		parent::__construct();
        $this->load->model('m_login');
        $this->load->model('m_admin');
	}
    
	function index()
	{
        //view login
        $this->load->view("admin/login-form");
	}
    
    //login
    function login()
    {
        $username = $this->input->post('username');
        $password = $this->input->post('password');
        $where = array(
            'username' => $username,
            'password' => $password
        );
        
        $check = $this->m_login->check_login("admin",$where)->num_rows();
        if($check > 0){
 
			$data_session = array(
				'username' => $username,
				'status' => "login"
				);
 
			$this->session->set_userdata($data_session);
			redirect(base_url("admin/dashboard"));
 
		} else {
			redirect(base_url("admin"));
		}
    }
    function logout()
    {
        $this->session->sess_destroy();
		redirect(base_url('admin'));
    }
    
    
    //function admin
    function dashboard()
    {
        if($this->session->userdata('status') != "login"){
			redirect(base_url("admin"));
		}
        else if($this->session->userdata('status') == "login"){
			$data = [   
                'breadcrumb' => "Dashboard Antrian",
                'content' => 'admin/content/home'
                ];
            $this->load->view("admin/index", $data);
		} 
    }
    
    function manajemenadmin()
    {
        if($this->session->userdata('status') != "login"){
			redirect(base_url("admin"));
		}
        else if($this->session->userdata('status') == "login"){
			$data = [   
                'data_admin' => $this->m_admin->getAll(),
                'breadcrumb' => "Manajemen Admin",
                'content' => 'admin/content/man_admin'
                ];
            $this->load->view("admin/index", $data);
		}
    }
    
    function editadmin($id = null)
    {
        if (!isset($id)) redirect('admin/manajemenadmin');
        $modeladmin = $this->m_admin;
        $modeladmin->update();
        redirect(base_url("admin/manajemenadmin"));
        
    }
}