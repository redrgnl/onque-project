<?php

class m_backup extends CI_Model {
    
    public function __contruct(){ 
    	parent::__contruct();
    }
    
    public function olddata($id)
    {
        return $data = $this->db->query("SELECT * FROM pasien WHERE pas_index = '$id'")->result();
    }
    
    public function backup($index,$nik,$nama,$kk,$alamat,$telepon,$lahir,$agama,$pend,$kelamin,$darah,$pekerjaan,$username)
    {
        date_default_timezone_set('Asia/Jakarta');
        $today = date("Y-m-d");
        return $query = $this->db->query("INSERT INTO backup(back_index, back_nik, back_nama, back_kk, back_alamat, back_telepon, back_lahir, back_agama, back_pendidikan, back_kelamin, back_darah, back_pekerjaan, back_username, back_delete) VALUES ('$index', '$nik', '$nama', '$kk', '$alamat', '$telepon', '$lahir', '$agama', '$pend', '$kelamin', '$darah', '$pekerjaan', '$username', '$today')");
    }
}