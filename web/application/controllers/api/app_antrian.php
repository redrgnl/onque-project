<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class app_antrian extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->model('mapp_antrian');
    }

    //api antrian terakhir
    function index_get(){
        $running = $this->mapp_antrian->antrian_sekarang();
        $lastdata = $this->mapp_antrian->antrian_terakhir();
        
        foreach($running as $run){
            $runnomor_urut = $run->nomor_urut;
            $runnama_poli = $run->nama_poli;
        }
        foreach($lastdata as $last){
            $lastnomor_urut = $last->nomor_urut;
        }
        
        if (empty($runnomor_urut)){
            $antrian['running_nomor'] = "-";
            $antrian['running_poli'] = "-";
            $antrian['last_nomor'] = "-";
            
//            $this->response($antrian, 200);
            $data['result'][0] = $antrian;
            echo json_encode($data);
        }
        else {
            $antrian['running_nomor'] = $runnomor_urut;
            $antrian['running_poli'] = $runnama_poli;
            $antrian['last_nomor'] = $lastnomor_urut;
            
//            $this->response($antrian, 200);
            $data['result'][0] = $antrian;
            echo json_encode($data);
        }
    }
}
?>
