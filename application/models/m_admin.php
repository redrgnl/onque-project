<?php

class m_admin extends CI_Model {
    private $_table = "admin";
    
    public $id_admin;
    public $nama;
    public $username;
    public $password;
    public $status;
    
    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }
    public function update()
    {
        $post = $this->input->post();
        $this->id_admin = $post["editadminid"];
        $this->nama = $post["editadminnama"];
        $this->username = $post["editadminusername"];
        $this->password = $post["editadminpassword"];
        $this->status = $post["editadminstatus"];   
        $this->db->update($this->_table, $this, array('id_admin' => $post['editadminid']));
    }
    
    public function save()
    {
        $post = $this->input->post();
        $nama = $post["adminnama"];
        $username = $post["adminusername"];
        $password = $post["adminpassword"];
        $result = $this->db->query("INSERT INTO admin (id_admin, nama, username, password, status) VALUES (DEFAULT, '$nama', '$username', '$password', 'admin')");
    }
    
    public function daftar_admin()
    {
        $result = $this->db->query("SELECT * FROM admin WHERE status='admin'");
        return $result->result();
    }
    
    public function check_super($username)
    {
        $checks = $this->db->query("SELECT status FROM admin WHERE username='$username'");
        return $checks->result();
    }
    
    public function edit_admin($where,$table)
    {
        return $this->db->get_where($table,$where);
    }
    
    public function delete($id)
    {
        return $this->db->delete($this->_table, array("id_admin" => $id));
    }
}