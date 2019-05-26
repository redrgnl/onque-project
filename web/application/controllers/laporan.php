<?php

class laporan extends CI_Controller {
    public function __construct()
    {
		parent::__construct();
        $this->load->model('m_login');
        $this->load->model('m_laporan');
	}
    
	function index()
	{
        //view manajemen pasien
        if($this->session->userdata('status') != "login"){
            redirect(base_url("admin"));
        }
        else if($this->session->userdata('status') == "login"){
            $permission = $this->session->userdata('permission');
            foreach ($permission as $perm){
                $mission = $perm->status;
            }
            $data = [   
                'permission' => $mission,
                'breadcrumb' => "Laporan Riwayat Antrian",
                'content' => 'admin/content/man_laporan'
                ];
            $this->load->view("admin/index", $data);
        }
	}
    
    function fetch()
     {
      $output = '';
      $query = '';
      $this->load->model('m_laporan');
      if($this->input->post('query'))
      {
       $query = $this->input->post('query');
      }
      $data = $this->m_laporan->fetch_data($query);
      $output .= '
      <div class="table-responsive">
         <table class="table table-bordered">
          <tr>
           <th>No. Urut</th>
           <th>Index</th>
           <th>Nama</th>
           <th>Alamat</th>
           <th>Tanggal Antri</th>
           <th>Poli</th>
           <th>Status</th>
          </tr>
      ';
      if($data->num_rows() > 0)
      {
       foreach($data->result() as $row)
       {
        $output .= '
          <tr>
           <td>'.$row->nomor_urut.'</td>
           <td>'.$row->pas_index.'</td>
           <td>'.$row->pas_nama.'</td>
           <td>'.$row->pas_alamat.'</td>
           <td>'.$row->tanggal_antrian.'</td>
           <td>'.$row->poli.'</td>
           <td>'.$row->status.'</td>
          </tr>
        ';
       }
      }
      else
      {
       $output .= '<tr>
           <td colspan="7">No Data Found</td>
          </tr>';
      }
      $output .= '</table>';
      echo $output;
     }
}