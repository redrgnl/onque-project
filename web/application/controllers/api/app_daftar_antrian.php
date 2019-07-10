<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_daftar_antrian extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->model('mapp_daftar');
        $this->load->model('m_antrian');
    }

    //api antrian terakhir
    function index_get()
    {
        $nomor = $this->mapp_daftar->nomor_antrian();
        if(empty($nomor)) { $nomor = "1";};
        $antrian['nomor'] = $nomor;
        
        $data['result'][0] = $antrian;
        echo json_encode($data);
    }
    
    function index_post()
    {
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
        $post = $this->input->post();
        $nomor = $post["session_nomor"];
        $index = $post["session_index"];
        $tanggal = $today;
        $poli = $post["session_poli"];
        $status = "antri";
        
        $check = $this->m_antrian->checkantrian($index);
        if(empty($check)){
            $result = $this->db->query("INSERT INTO antrian (id_antrian,nomor_urut,pas_indextanggal_antrian,nama_poli,status) VALUES (DEFAULT,'$nomor','$index','$tanggal','$poli','$status')");
            //success
            $data['success'] = "1";
            echo json_encode($data);
        } else {
            //failed
            $data['success'] = "0";
            echo json_encode($data);
        }
    }    
}
?>
