<?php

class m_laporan extends CI_Model {

    function fetch_data($query)
     {
      $this->db->select("*");
      $this->db->from("antrian");
      if($query != '')
      {
       $this->db->like('tanggal_antrian', $query);
      }
      $this->db->order_by('nomor_urut', 'ASC');
      return $this->db->get();
     }
}