<?php
class mapp_daftar extends CI_Model{
    
    public function __construct(){
        parent::__construct();
    }
    
    function nomor_antrian()
    {
      date_default_timezone_set('Asia/Jakarta');
      $today = date("Y-m-d");
      $this->db->select("MAX(nomor_urut)+1 AS no");
      $this->db->from("antrian");
      $this->db->where("tanggal_antrian='$today'");
      $query = $this->db->get();

      return $query->row()->no;
    }
}
?>