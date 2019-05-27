<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_login extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->model('mapp_login');
    }

    //Load API Data Pasien
    function index_get() {
        $pas_index = $this->get('pas_index');
        if ($pas_index == '') {
            $app_api = $this->db->get('pasien')->result();
        } else {
            $this->db->where('pas_index', $pas_index);
            $app_api = $this->db->get('pasien')->result();
        }
        $this->response($app_api, 200);
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
