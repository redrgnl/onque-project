<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_antrian_anda extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->model('mapp_antrian');
    }

    //api antrian terakhir
    function index_post(){
        $post_index = $this->input->post('session_index');
        
        $running = $this->mapp_antrian->antrian_sekarang();
        $lastdata = $this->mapp_antrian->antrian_terakhir();
        $antrian_anda = $this->mapp_antrian->antrian_anda($post_index);
            
        foreach($running as $run){
            $runnomor_urut = $run->nomor_urut;
        }
        foreach($lastdata as $last){
            $lastnomor_urut = $last->nomor_urut;
        }
        foreach($antrian_anda as $anda){
            $andanomor_urut = $anda->nomor_urut;
            $andanama_poli = $anda->nama_poli;
            $andastatus = $anda->status;
        }
        
        if (empty($runnomor_urut)){
            $antrian['running_nomor'] = "Antrian Tuntas";
            $antrian['last_nomor'] = "Belum Ada Antrian";
            if (empty($andanomor_urut)){
                $antrian['anda_nomor'] = "NA";
                $antrian['anda_poli'] = "NA";
                $antrian['anda_status'] = "NA";
            }
            else {
                $antrian['anda_nomor'] = $andanomor_urut;
                $antrian['anda_poli'] = $andanama_poli;
                $antrian['anda_status'] = $andastatus;
            }
                
            $this->response($antrian, 200);
//            echo json_encode($antrian);
        }
        else {
            $antrian['running_nomor'] = $runnomor_urut;
            $antrian['last_nomor'] = $lastnomor_urut;
            $antrian['anda_nomor'] = $andanomor_urut;
            $antrian['anda_poli'] = $andanama_poli;
            if (empty($andanomor_urut)){
                $antrian['anda_nomor'] = "NA";
                $antrian['anda_poli'] = "NA";
                $antrian['anda_status'] = "NA";
            }
            else {
                $antrian['anda_nomor'] = $andanomor_urut;
                $antrian['anda_poli'] = $andanama_poli;
                $antrian['anda_status'] = $andastatus;
            }
            
            $this->response($antrian, 200);
//            echo json_encode($antrian);
        }
    }
}
?>
