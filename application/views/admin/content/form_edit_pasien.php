<?php $this->load->view('admin/_partial/header')?>
<div class="form-row">
<div class="card-body">
<?php foreach($pasien as $data){ ?>
<form method="post" action="<?php echo base_url('pasien/update_pasien');?>">
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasienindex" name="edpasienindex" class="form-control" readonly placeholder="No. Index" required="required" value="<?php echo $data->pas_index?>">
          <label for="edpasienindex">No. Index</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasienagama" name="edpasienagama" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Agama --</option>
            <option>Islam</option>
			<option>Kristen</option>
			<option>Katolik</option>
			<option>Hindu</option>
			<option>Budha</option>
			<option>Konghucu</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasiennik" name="edpasiennik" autocomplete="off" class="form-control" placeholder="Nomor Induk Kependudukan" required="required" value="<?php echo $data->pas_nik?>">
          <label for="edpasiennik">Nomor Induk Kependudukan</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasienpendidikan" name="edpasienpendidikan" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Pendidikan --</option>
            <option>Sarjana</option>
			<option>SMA / SMK / MAN</option>
			<option>SD / MI</option>
			<option> - </option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasiennama" name="edpasiennama" autocomplete="off" class="form-control" placeholder="Nama" required="required" value="<?php echo $data->pas_nama?>">
          <label for="edpasiennama">Nama</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasienkelamin" name="edpasienkelamin" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Jenis Kelamin --</option>
            <option>Laki - Laki</option>
			<option>Perempuan</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasiennamakk" name="edpasiennamakk" autocomplete="off" class="form-control" placeholder="Nama KK / Penanggung Jawab" required="required" value="<?php echo $data->pas_kk?>">
          <label for="edpasiennamakk">Nama KK / Penanggung Jawab</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasiendarah" name="edpasiendarah" autocomplete="off" class="form-control" placeholder="Golongan Darah" required="required" value="<?php echo $data->pas_darah?>">
          <label for="edpasiendarah">Golongan Darah</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasienalamat" name="edpasienalamat" autocomplete="off" class="form-control" placeholder="Alamat" required="required" value="<?php echo $data->pas_alamat?>">
          <label for="edpasienalamat">Alamat</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasienpekerjaan" name="edpasienpekerjaan" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Pekerjaan --</option>
            <option>ASN</option>
			<option>TNI</option>
			<option>Polri</option>
			<option>Swasta</option>
			<option>Tani</option>
			<option>Buruh</option>
			<option>Wiraswasta</option>
			<option>Pelajar</option>
			<option> - </option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasientelepon" name="edpasientelepon" autocomplete="off" class="form-control" placeholder="Telepon / HP" required="required" value="<?php echo $data->pas_telepon?>">
          <label for="edpasientelepon">Telepon / HP</label>
        </div>
      </div>
      <div class="col-md-2 d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-0 my-2 my-md-0">
        <div class="form-label-group">
          <button class="btn btn-primary btn-block" href="" type="submit">Simpan</button>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group input-group date" data-provide="datepicker">
          <input type="text" class="form-control" id="edpasienlahir" name="edpasienlahir" required style="height: 50px;" placeholder="Tanggal Lahir" value="<?php echo $data->pas_lahir?>">
          <div class="input-group-addon">
            <span class="glyphicon glyphicon-th"></span>
		  </div>
          <label for="edpasienlahir">Tanggal Lahir</label>
        </div>
      </div>
    </div>
  </div>
</form>
<?php } ?>
</div>
</div>