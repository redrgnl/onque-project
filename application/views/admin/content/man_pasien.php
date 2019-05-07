<div class="row">
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-primary o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-user"></i>
        </div>
        <div class="mr-5">Pasien</div>
      </div> 
      <a class="card-footer text-white clearfix small z-1" href="<?php echo base_url('pasien/form_tambah')?>">
        <span class="float-left">Tambah Pasien Baru</span>
        <span class="float-right">
          <i class="fas fa-angle-right"></i>
        </span>
      </a>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-xl-12 col-sm-12 mb-12">
    <div class="card mb-3">
          <div class="card-header bg-info" style="color: white">
            <i class="fas fa-table"></i>
              Tabel Pasien Terdaftar
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>No. Index</th>
                    <th>NIK</th>
                    <th>Nama</th>
                    <th>Alamat</th>
                    <th>Tgl Lahir</th>
                    <th>Jenis Kelamin</th>
                    <th style="width: 70px">Update</th>
                  </tr>
                </thead>
                <tfoot>
                  <tr>
                    <th>No. Index</th>
                    <th>NIK</th>
                    <th>Nama</th>
                    <th>Alamat</th>
                    <th>Tgl Lahir</th>
                    <th>Jenis Kelamin</th>
                    <th style="width: 70px">Update</th>
                  </tr>
                </tfoot>
                <tbody>
                  <?php foreach($pasien as $data):?>
                    <tr>
                      <td><?php echo $data->pas_index?></td>
                      <td><?php echo $data->pas_nik?></td>
                      <td><?php echo $data->pas_nama?></td>
                      <td><?php echo $data->pas_alamat?></td>
                      <td><?php echo $data->pas_lahir?></td>
                      <td><?php echo $data->pas_kelamin?></td>
                      <td style="width: 70px">
                          <a class="btn btn-info" href="<?php echo base_url('pasien/edit_pasien/'.$data->pas_index) ?>"><i class="fa fa-gear"></i></a>  
                          <button class="btn btn-danger" onclick="deletepasien('<?php echo base_url('pasien/hapus_pasien/'.$data->pas_index) ?>')"><i class="fa fa-trash"></i></button>  
                      </td>
                    </tr>
                  <?php endforeach; ?>
                </tbody>
              </table>
            </div>
          </div>
          <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
  </div>
</div>