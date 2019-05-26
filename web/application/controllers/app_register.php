<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_register extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->database();
    }

    //Tambah Pasien
    function index_post() {
        $values = array(
                    'pas_index' => $this->post('pas_index'),
                    'pas_nik' => $this->post('pas_nik'),
                    'pas_nama' => $this->post('pas_nama'),
                    'pas_kk' => $this->post('pas_kk'),
                    'pas_alamat' => $this->post('pas_alamat'),
                    'pas_telepon' => $this->post('pas_telepon'),
                    'pas_lahir' => $this->post('pas_lahir'),
                    'pas_agama' => $this->post('pas_agama'),
                    'pas_pendidikan' => $this->post('pas_pendidikan'),
                    'pas_kelamin' => $this->post('pas_kelamin'),
                    'pas_darah' => $this->post('pas_darah'),
                    'pas_pekerjaan' => $this->post('pas_pekerjaan'));
        $insert = $this->db->insert('pasien', $values);
        
        if ($insert) {
            $data['success'] = "1";
            $data['message'] = "success";
            echo json_encode($data);
        } else {
            $data['success'] = "0";
            $data['message'] = "error";
            echo json_encode($data);
        }
    }
}
?>