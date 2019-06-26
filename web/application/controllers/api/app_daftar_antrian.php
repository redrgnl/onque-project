<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_daftar_antrian extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->model('mapp_daftar');
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
        $nama = $post["session_nama"];
        $alamat = $post["session_alamat"];
        $tanggal = $today;
        $poli = $post["session_poli"];
        $status = "antri";
        $result = $this->db->query("INSERT INTO antrian (id_antrian,nomor_urut,pas_index,pas_nama,pas_alamat,tanggal_antrian,nama_poli,status) VALUES (DEFAULT,'$nomor','$index','$nama','$alamat','$tanggal','$poli','$status')");
        
        if ($result) {
            $data['success'] = "1";
            echo json_encode($data);
        } else {
            $data['success'] = "0";
            echo json_encode($data);
        }
    }    
}
?>
