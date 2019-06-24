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
        
        //check status admin aktif atau non-aktif
        $checkstatus = $this->m_admin->check_status($username)->num_rows();
        
        //jika status aktif
        if($checkstatus > 0){
            //check status user admin
			$checks = $this->m_admin->check_super($username);
        	$where = array(
            	'username' => $username,
            	'password' => $password
        	);
            //check post username password
        	$check = $this->m_login->check_login("admin",$where)->num_rows();
        	if($check > 0){
				$data_session = array(
                	'permission' => $checks,
					'username' => $username,
					'status' => "login"
					);
 
				$this->session->set_userdata($data_session);
				redirect(base_url("antrian"));
 
			} else {
				redirect(base_url("admin"));
			} 
		} else {
			redirect(base_url("admin"));
		}
    }
    //logout
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
            //menampilkan status user
            $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
			$data = [
                'permission' => $mission,
                'breadcrumb' => "Dashboard Antrian",
                'content' => 'admin/content/man_antrian'
                ];
            $this->load->view("admin/index", $data);
		} 
    }
    
    //manajemen admin
    function manajemenadmin()
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
            //menampilkan data admin terdaftar
            $result = $this->m_admin->daftar_admin();
            $data = [   
                'permission' => $mission,
                'data_admin' => $this->m_admin->getAll(),
                'breadcrumb' => "Manajemen Admin",
                'content' => 'admin/content/man_admin',
                'admin' => $result
            ];
            $this->load->view("admin/index", $data);
        }   
    }
    
    //halaman tambah admin
    function formadmin()
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
                'breadcrumb' => "Tambah Admin",
                'content' => 'admin/content/form_admin'
            ];
            $this->load->view("admin/index", $data);
        }
    }
    
    //function tambah admin to database
    function tambah_admin()
    {
        //save admin baru
        $modeladmin = $this->m_admin;
        $modeladmin->save();
        
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            redirect(base_url("admin/manajemenadmin"));
        }
    }
    
    //form edit admin
    function formeditadmin($id)
    {
        if($this->session->userdata('status') != "login"){
			redirect(base_url("admin"));
		}
        else if($this->session->userdata('status') == "login"){
            $where = array('id_admin' => $id);
            //menampilkan status user
            $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
			$data = [   
                'permission' => $mission,
                'admin' => $this->m_admin->edit_admin($where,'admin')->result(),
                'breadcrumb' => "Manajemen Admin",
                'content' => 'admin/content/form_edit_admin'
                ];
            $this->load->view("admin/index", $data);
		}
    }
    
    //form edit admin
    function updateadmin()
    {
        //save data admin yang sudah di edit
        $modeladmin = $this->m_admin;
        $modeladmin->update();
        
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            redirect(base_url("admin/manajemenadmin"));
        }
    }
}