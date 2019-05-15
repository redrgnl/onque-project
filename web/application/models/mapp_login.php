<?php
class mapp_login extends CI_Model{
    
    public function __construct(){
        parent::__construct();
    }

    function login_api($username, $password)
    {
        $result = $this->db->query("SELECT * FROM pasien WHERE pas_index = '$username' AND pas_nik = '$password'");
        return $result->result();
    }
}
?>