<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_login extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->model('mapp_login');
    }

    //Login Pasien
    function index_post() {
        $username = $this->input->post('username');
        $password = $this->input->post('password');
        $result = $this->mapp_login->login_api($username, $password);
        
        if (empty($result)) 
        {    
            $data['login'] = [];
            $data['success'] = "0";
            $data['message'] = "error";
            echo json_encode($data);
        }
        else
        {
            $data['login'] = $result;
            $data['success'] = "1";
            $data['message'] = "success";
            echo json_encode($data);
        }
    }
}
?>
