<?php

class m_admin extends CI_Model {
    private $_table = "admin";
    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }
    public function getById($id)
    {
        return $this->db->get_where($this->_table, ["product_id" => $id])->row();
    }
    public function update()
    {
        $post = $this->input->post();
        $this->id_admin = $post["idadmin"];
        $this->username = $post["adminusername"];
        $this->password = $post["adminpassword"];
        $this->db->update($this->_table, $this, array('id_admin' => $post['idadmin']));
    }
}