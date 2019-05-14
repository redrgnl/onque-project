<div class="row">
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-danger o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-user"></i>
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
</div>



<h1><?php echo $permission?></h1>
<?php $status = $this->session->userdata('status')?>
<h1><?php echo $status?></h1>
