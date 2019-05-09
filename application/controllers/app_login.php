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
    //Tambah Pasien
    function index_post() {
        $username = $this->input->post('username');
        $password = $this->input->post('password');
        $result = $this->mapp_login->login_api($username, $password);
        
        if (empty($result)) 
        {    
            $data['login'] = "Not Found";
            $data['message'] = "Failed";
            echo json_encode($data);
        }
        else
        {
            $data['login'] = $result;
            $data['message'] = "Success";
            echo json_encode($data);
        }

        //$username = $this->input->post('username');
        //$password = $this->input->post('password');


        //$data = $this->mapp_login->login_api($username, $password);

        // $result = array();
        // $result['login'] = array();
        
        // if ( mysqli_num_rows($response) === 1 ) {
            
        //     $row = mysqli_fetch_assoc($response);

        //     if ( $password == $data['pas_nik'] ) {
                
        //         $index['pas_nama'] = $data['pas_nama'];
        //         $index['pas_index'] = $data['pas_index'];

        //         array_push($result['login'], $index);

        //         $result['success'] = "1";
        //         $result['message'] = "success";
        //         echo json_encode($result);

        //         mysqli_close($conn);

        //     } else {

        //         $result['success'] = "0";
        //         $result['message'] = "error";
        //         echo json_encode($result);

        //         mysqli_close($conn);

        //     }

        //}
    }
}
?>
