<div class="form-row">
<div class="card-pict mb-3">
  <img src="<?php echo base_url('assets/admin/img/logo.png')?>" alt="IMG">
</div>
<div class="card-body">
<?php foreach($admin as $data){?>
<form method="post" action="<?php echo base_url("admin/updateadmin")?>">
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-5">
        <div class="form-label-group">
          <input type="text" id="editadminnama" name="editadminnama" class="form-control" placeholder="Nama Admin" required="required" value="<?php echo $data->nama?>">
          <label for="editadminnama">Nama Admin</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <input type="hidden" name="editadminid" id="editadminid" value="<?php echo $data->id_admin?>">
    <input type="hidden" name="editadminstatus" id="editadminstatus" value="<?php echo $data->status?>">
    <div class="form-row">
      <div class="col-md-5">
        <div class="form-label-group">
          <input type="text" id="editadminusername" name="editadminusername" autocomplete="off" class="form-control" placeholder="Username" required="required" value="<?php echo $data->username?>">
          <label for="editadminusername">Username</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-5">
        <div class="form-label-group">
          <input type="password" id="editadminpassword" name="editadminpassword" class="form-control" placeholder="Password" required="required" value="<?php echo $data->password?>">
          <label for="editadminpassword">Password</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-5">
        <div class="form-label-group">
          <div class="checkbox">
            <label><input type="checkbox" required> Konfirmasi Perubahan</label>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-5">
        <div class="form-label-group">
          <button class="btn btn-primary btn-block" href="" type="submit">Simpan</button>
        </div>
      </div>
    </div>
  </div>
</form>
<?php } ?>
</div>
</div>