<?php
class mapp_login extends CI_Model{
    
    public function __construct(){
        parent::__construct();
    }

    public function login_api($username,$password){
        $query = $this->db->query("SELECT * FROM pasien WHERE pas_index = '$username' AND pas_nik = '$password'");
        return $query->result_array();
    }
}
?>