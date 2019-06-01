<?php 
  if($nomor == "Antrian Tuntas"){ 
        $antri = "#";
        $text = "Tuntas";
        $skip = "#";
    }
  else if($nomor != "Antrian Tuntas"){ 
        $antri = base_url('antrian/next/').$id; 
        $text = "Next";
        $skip = base_url('antrian/skip/').$id;
    }
?>

<div class="row">
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-danger o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-chart-area"></i>
        </div>
        <div class="mr-5">Antrian</div>
      </div> 
      <a class="card-footer text-white clearfix small z-1" href="<?php echo base_url("antrian/form_antrian")?>">
        <span class="float-left">Tambah Antrian Baru</span>
        <span class="float-right">
          <i class="fas fa-angle-right"></i>
        </span>
      </a>
    </div>
  </div>
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-primary o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-user"></i>
        </div>
        <div class="mr-5">Pasien</div>
      </div> 
      <a class="card-footer text-white clearfix small z-1" href="<?php echo base_url("pasien")?>">
        <span class="float-left">Manajemen Pasien</span>
        <span class="float-right">
          <i class="fas fa-angle-right"></i>
        </span>
      </a>
    </div>
  </div>
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-warning o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-file-text"></i>
        </div>
        <div class="mr-5">Laporan</div>
      </div> 
      <a class="card-footer text-white clearfix small z-1" href="<?php echo base_url("laporan")?>">
        <span class="float-left">Manajemen Laporan</span>
        <span class="float-right">
          <i class="fas fa-angle-right"></i>
        </span>
      </a>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-xl-9 col-sm-5 mb-3">
    <div class="card text-black o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-chart-area"></i>
        </div>
          <div class="mr-5"><h4>Antrian Pasien</h4></div>
          <br>
          <div class="mr-5">Panggilan Antrian / Antrian Terakhir</div>
          <div class="mr-5"><h2><strong><?php echo $nomor?> / <?php echo $last_data?></strong></h2></div>
          <br>
          <div class="mr-5">Poli Tujuan - <strong><?php echo $poli?></strong></div>
      </div> 
      <div class="card-footer text-white clearfix small z-1">
        <div class="float-right">
          <a class="btn btn-success" style="width: 150px" href="<?php echo $antri?>"><?php echo $text?></a>
          <a class="btn btn-danger" style="width: 150px" href="<?php echo $skip?>">Tunda</a>
        </div>
      </div>
    </div>
  </div>
  <div>
    <time datetime="<?php echo date("Y-m-d")?>" class="date-as-calendar position-em size2x">
      <span class="weekday"><?php echo date("l")?></span>
      <span class="day"><?php echo date("d")?></span>
      <span class="month"><?php echo date("F")?></span>
      <span class="year"><?php echo date("Y")?></span>
    </time>
  </div>
</div>
<div class="row">
  <div class="col-xl-12 col-sm-12">
    <ol class="breadcrumb">
      <li class="breadcrumb-item active" style="color: black">Daftar Antrian Pasien Terbaru Puskesmas Sumbersari</li>
    </ol>
  </div>
</div>
<div class="row">
  <div class="col-xl-12 col-sm-5 mb-3">
    <div class="card mb-3">
      <div class="card-header bg-success" style="color: white">
        <i class="fas fa-table"></i>
          Riwayat Antrian Pasien Terbaru
      </div>
      <div class="card-body">
        <div class="table-responsive">
          <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <thead>
              <tr>
                <th style="width: 50px">No. Antrian</th>
                <th>Index</th>
                <th>Nama</th>
                <th>Alamat</th>
                <th>Tanggal Antri</th>
                <th>Poli</th>
                <th>Status</th>
                <th style="width: 50px">Update</th>
              </tr>
            </thead>
            <tbody>
            <?php foreach($daftar_antrian as $antrian){ ?>
              <?php 
                if($antrian->status == "tunda"){ $update = base_url('antrian/update/').$antrian->id_antrian; $class = "btn btn-warning"; }
                else if($antrian->status == "antri"){ $update = "#"; $class = "btn btn-info"; }
                else if($antrian->status == "selesai"){ $update = "#"; $class = "btn btn-success"; }
              ?>
              <tr>
                <td><?php echo $antrian->nomor_urut?></td>
                <td><?php echo $antrian->pas_index?></td>
                <td><?php echo $antrian->pas_nama?></td>
                <td><?php echo $antrian->pas_alamat?></td>
                <td><?php echo $antrian->tanggal_antrian?></td>
                <td><?php echo $antrian->nama_poli?></td>
                <td>
                    <label class="<?php echo $class?>">
                        <?php echo $antrian->status?>
                    </label>
                </td>
                <td>
                    <a class="btn btn-primary" href="<?php echo $update?>"><i class="fa fa-sync"></i></a>
                </td>
              </tr>
            <?php }; ?>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>