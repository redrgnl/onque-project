<?php

class m_pasien extends CI_Model {
    private $_table = "pasien";
    
    public $pas_index;
    public $pas_nik;
    public $pas_nama;
    public $pas_kk;
    public $pas_alamat;
    public $pas_telepon;
    public $pas_lahir;
    public $pas_agama;
    public $pas_pendidikan;
    public $pas_kelamin;
    public $pas_darah;
    public $pas_pekerjaan;
        
    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }
    public function save()
    {
        $post = $this->input->post();
        $this->pas_index = $post["pasienindex"];
        $this->pas_nik = $post["pasiennik"];
        $this->pas_nama = $post["pasiennama"];
        $this->pas_kk = $post["pasiennamakk"];
        $this->pas_alamat = $post["pasienalamat"];
        $this->pas_telepon = $post["pasientelepon"];
        $this->pas_lahir = $post["pasienlahir"];
        $this->pas_agama = $post["pasienagama"];
        $this->pas_pendidikan = $post["pasienpendidikan"];
        $this->pas_kelamin = $post["pasienkelamin"];
        $this->pas_darah = $post["pasiendarah"];
        $this->pas_pekerjaan = $post["pasienpekerjaan"];
        $this->db->insert($this->_table, $this);
    }
    public function edit_data($where,$table)
    {
        return $this->db->get_where($table,$where);
    }
    public function update()
    {
        $post = $this->input->post();
        $this->pas_index = $post["edpasienindex"];
        $this->pas_nik = $post["edpasiennik"];
        $this->pas_nama = $post["edpasiennama"];
        $this->pas_kk = $post["edpasiennamakk"];
        $this->pas_alamat = $post["edpasienalamat"];
        $this->pas_telepon = $post["edpasientelepon"];
        $this->pas_lahir = $post["edpasienlahir"];
        $this->pas_agama = $post["edpasienagama"];
        $this->pas_pendidikan = $post["edpasienpendidikan"];
        $this->pas_kelamin = $post["edpasienkelamin"];
        $this->pas_darah = $post["edpasiendarah"];
        $this->pas_pekerjaan = $post["edpasienpekerjaan"];
        $this->db->update($this->_table, $this, array('pas_index' => $post['edpasienindex']));
    }
}