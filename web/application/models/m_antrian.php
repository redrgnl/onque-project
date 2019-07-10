<?php

class m_antrian extends CI_Model {
	
	public function __contruct(){ 
    	parent::__contruct();
    }

    public function antrian_trakhir(){
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
   	    $Antrian = $this->db->query("SELECT * FROM antrian WHERE tanggal_antrian='$today' ORDER BY nomor_urut DESC LIMIT 1 ")->result();
   	    return $Antrian;
    }

    public function antrian_sekarang()
    {
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
        $sekarang = $this->db->query("SELECT * FROM antrian WHERE status='antri' AND tanggal_antrian='$today' ORDER BY status ASC LIMIT 1")->result();
        return $sekarang;
    }
    
    function tampil()
    {
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
        return $result = $this->db->query("SELECT antrian.id_antrian, antrian.nomor_urut, antrian.pas_index, pasien.pas_nama, pasien.pas_alamat, antrian.tanggal_antrian, antrian.nama_poli, antrian.status FROM antrian, pasien WHERE antrian.pas_index = pasien.pas_index AND tanggal_antrian='$today'")->result();
    }
    
    public function checkantrian($id){
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
        return $result = $this->db->query("SELECT * FROM antrian WHERE tanggal_antrian='$today' AND pas_index='$id'")->result();
    }
    
    public function tambahantrian()
    {
      date_default_timezone_set('Asia/Jakarta');
      $today = date("Y-m-d");
      $post = $this->input->post();
      $nomor = $post["nomorUrut"];
      $index = $post["pasIndex"];
      $tanggal = $today;
      $poli = $post["poliTujuan"];
      $status = "antri";
      $result = $this->db->query("INSERT INTO antrian (id_antrian,nomor_urut,pas_index,tanggal_antrian,nama_poli,status) VALUES (DEFAULT,'$nomor','$index','$tanggal','$poli','$status')");
    }   

    function autonumber()
    {
      date_default_timezone_set('Asia/Jakarta');
      $today = date("Y-m-d");
      $this->db->select("MAX(nomor_urut)+1 AS no");
      $this->db->from("antrian");
      $this->db->where("tanggal_antrian='$today'");
      $query = $this->db->get();

      return $query->row()->no;
    }
    
    public function next($id)
    {
        $result = $this->db->query("UPDATE antrian SET status='selesai' WHERE id_antrian='$id'");
    }
    public function skip($id)
    {
        $result = $this->db->query("UPDATE antrian SET status='tunda' WHERE id_antrian='$id'");
    }
    public function update($id)
    {
        $result = $this->db->query("UPDATE antrian SET status='selesai' WHERE id_antrian='$id'");
    }
}

?>