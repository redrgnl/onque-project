<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_register extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->database();
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
        $data = array(
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
        $insert = $this->db->insert('pasien', $data);
        if ($insert) {
            $this->response(array('success' => '1', 200));
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }

//    Edit Pasien
//    function index_put() {
//        $pass_index = $this->put('pass_index');
//        $data = array(
//                    'pas_index' => $this->put('pass_index'),
//                    'pas_nik' => $this->put('pass_nik'),
//                    'pas_nama' => $this->put('pass_nama'),
//                    'pas_kk' => $this->put('pass_kk'),
//                    'pas_alamat' => $this->put('pass_alamat'),
//                    'pas_telepon' => $this->put('pass_telepon'),
//                    'pas_lahir' => $this->put('pass_lahir'),
//                    'pas_agama' => $this->put('pass_agama'),
//                    'pas_pendidikan' => $this->put('pass_pendidikan'),
//                    'pas_kelamin' => $this->put('pass_kelamin'),
//                    'pas_darah' => $this->put('pass_darah'),
//                    'pas_pekerjaan' => $this->put('pass_pekerjaan'));
//        $this->db->where('pas_index', $pass_index);
//        $update = $this->db->update('pasien', $data);
//        if ($update) {
//            $this->response($data, 200);
//        } else {
//            $this->response(array('status' => 'fail', 502));
//        }
//    }
}
?>