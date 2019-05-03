<div class="form-row">
<div class="card-pict mb-3">
  <img src="<?php echo base_url('assets/admin/img/logo.png')?>" alt="IMG">
</div>
<div class="card-body">
<?php foreach ($data_admin as $admin):?>
<form method="post" action="<?php echo base_url('admin/editadmin/'.$admin->id_admin)?>">
  <div class="form-group">
    <input type="hidden" name="idadmin" id="idadmin" value="<?php echo $admin->id_admin?>">
    <div class="form-row">
      <div class="col-md-5">
        <div class="form-label-group">
          <input type="text" id="adminusername" name="adminusername" autocomplete="off" class="form-control" placeholder="Username" required="required" value="<?php echo $admin->username?>">
          <label for="adminusername">Username</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-5">
        <div class="form-label-group">
          <input type="password" id="adminpassword" name="adminpassword" class="form-control" placeholder="Password" required="required" value="<?php echo $admin->password?>">
          <label for="adminpassword">Password</label>
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
<?php endforeach; ?>
</div>
</div>