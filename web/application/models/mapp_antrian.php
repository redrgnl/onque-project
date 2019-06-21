<?php
class mapp_antrian extends CI_Model{
    
    public function __construct(){
        parent::__construct();
    }

    public function antrian_terakhir(){
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
   	    $Antrian = $this->db->query("SELECT nomor_urut,nama_poli FROM antrian WHERE tanggal_antrian='$today' ORDER BY nomor_urut DESC LIMIT 1 ")->result();
   	    return $Antrian;
    }

    public function antrian_sekarang()
    {
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
        $sekarang = $this->db->query("SELECT nomor_urut,nama_poli FROM antrian WHERE status='antri' AND tanggal_antrian='$today' ORDER BY status ASC LIMIT 1")->result();
        return $sekarang;
    }
    public function antrian_anda($id)
    {
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
        $anda = $this->db->query("SELECT nomor_urut,tanggal_antrian,nama_poli,status FROM antrian WHERE tanggal_antrian='$today' AND pas_index='$id'")->result();
        return $anda;
    }
}
?>