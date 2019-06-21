<div class="row">
  <div class="col-md-3 col-sm-6 mb-3">
    <div class="card text-white o-hidden h-100 bg-warning">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-user"></i>
        </div>
        <div class="mr-5">Laporan Bulanan</div>
      </div> 
      <a class="card-footer text-white clearfix small z-1" href="<?php echo base_url('laporan/laporan_bulanan')?>">
        <span class="float-left">Selengkapnya</span>
        <span class="float-right">
          <i class="fas fa-angle-right"></i>
        </span>
      </a>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-md-4 mb-3">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Pilih Tanggal" aria-label="Search" aria-describedby="basic-addon2" data-provide="datepicker" data-date-format="yyyy-mm-dd" id="srcdaily" name="srcdaily" readonly>
      <div class="input-group-addon">
        <span class="glyphicon glyphicon-th"></span>
	  </div>
      <div class="input-group-append">
        <button class="btn btn-primary" type="button" id="btn-search" name="btn-search">
          <i class="fas fa-search"></i>
        </button>
      </div>
    </div>
  </div>
  <div class="col-md-2">
    <div class="card text-white" style="background-color: green">
      <div class="card-alert">
        <span class="mr-1"> Laporan Per Tanggal</span>
      </div> 
    </div>
  </div>
</div>
<div class="row">
  <div class="col-xl-12 col-sm-12">
    <ol class="breadcrumb">
      <li class="breadcrumb-item active" style="color: black">Daftar Riwayat Antrian Puskesmas Sumbersari Hari Ini</li>
    </ol>
  </div>
</div>
<div class="row">
  <div class="col-xl-12 col-sm-12 mb-3">
    <div class="card mb-3">
      <div class="card-header bg-danger" style="color: white">
        <i class="fas fa-table"></i>
          Riwayat Antrian Pasien Terbaru
      </div>
      <div id="result"></div>
    </div>
  </div>
</div>