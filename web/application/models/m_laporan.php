<?php

class m_laporan extends CI_Model {

    function fetch_data($query)
     {
      $this->db->select(
                        "antrian.nomor_urut, antrian.pas_index, pasien.pas_nama, pasien.pas_alamat, antrian.tanggal_antrian, antrian.nama_poli, antrian.status"
                       );
      $this->db->from("antrian, pasien");
      if($query != '')
      {
       $this->db->like('tanggal_antrian', $query);
      }
      $this->db->where('pasien.pas_index = antrian.pas_index');
      $this->db->order_by('tanggal_antrian', 'ASC');
      return $this->db->get();
     }
    
}