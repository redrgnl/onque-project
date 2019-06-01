<?php

class m_antrian extends CI_Model {
	
	public function __contruct(){ 
    	parent::__contruct();
    }

    public function antrian_trakhir(){
        $today = date("Y-m-d");
   	    $Antrian = $this->db->query("SELECT * FROM antrian WHERE tanggal_antrian='$today' ORDER BY nomor_urut DESC LIMIT 1 ")->result();
   	    return $Antrian;
    }

    public function antrian_sekarang()
    {
        $today = date("Y-m-d");
        $sekarang = $this->db->query("SELECT * FROM antrian WHERE status='antri' AND tanggal_antrian='$today' ORDER BY status ASC LIMIT 1")->result();
        return $sekarang;
    }
    
    function tampil()
    {
        $today = date("Y-m-d");
        return $result = $this->db->query("SELECT * FROM antrian WHERE tanggal_antrian='$today'")->result();
    }
    
    public function checkantrian($id){
        $today = date("Y-m-d");
        return $result = $this->db->query("SELECT * FROM antrian WHERE tanggal_antrian='$today' AND pas_index='$id'")->result();
    }
    
    public function tambahantrian()
    {
      $today = date("Y-m-d");
      $post = $this->input->post();
      $idantri = $post["idAntrian"];
      $nomor = $post["nomorUrut"];
      $index = $post["pasIndex"];
      $nama = $post["pasNama"];
      $alamat = $post["pasAlamat"];
      $tanggal = $today;
      $poli = $post["poliTujuan"];
      $status = "antri";
      $result = $this->db->query("INSERT INTO antrian (id_antrian,nomor_urut,pas_index,pas_nama,pas_alamat,tanggal_antrian,nama_poli,status) VALUES (DEFAULT,'$nomor','$index','$nama','$alamat','$tanggal','$poli','$status')");
    }   

    function autonumber()
    {
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