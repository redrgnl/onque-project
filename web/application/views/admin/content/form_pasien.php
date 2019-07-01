<?php $this->load->view('admin/_partial/header')?>
<div class="form-row">
<div class="card-body">
<form method="post" action="<?php echo base_url('pasien/tambah_pasien')?>">
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="pasienindex" name="pasienindex" class="form-control" placeholder="No. Index" required="required" value="" maxlength="20">
          <label for="pasienindex">No. Index</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="pasienagama" name="pasienagama" class="form-control" required="required" value="" style="height: 50px;">
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
          <input type="number" id="pasiennik" name="pasiennik" autocomplete="off" class="form-control" placeholder="Nomor Induk Kependudukan" required="required" value="" maxlength="17">
          <label for="pasiennik">Nomor Induk Kependudukan</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="pasienpendidikan" name="pasienpendidikan" class="form-control" required="required" value="" style="height: 50px;">
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
          <input type="text" id="pasiennama" name="pasiennama" autocomplete="off" class="form-control" placeholder="Nama" required="required" value="" maxlength="30">
          <label for="pasiennama">Nama</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="pasienkelamin" name="pasienkelamin" class="form-control" required="required" value="" style="height: 50px;">
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
          <input type="text" id="pasiennamakk" name="pasiennamakk" autocomplete="off" class="form-control" placeholder="Nama KK / Penanggung Jawab" required="required" value="" maxlength="30">
          <label for="pasiennamakk">Nama KK / Penanggung Jawab</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="pasiendarah" name="pasiendarah" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Darah --</option>
            <option>O-</option>
            <option>O+</option>
            <option>A-</option>
            <option>A+</option>
            <option>AB-</option>
            <option>AB+</option>
            <option>B-</option>
            <option>B+</option>
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
          <input type="text" id="pasienalamat" name="pasienalamat" autocomplete="off" class="form-control" placeholder="Alamat" required="required" value="">
          <label for="pasienalamat">Alamat</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="pasienpekerjaan" name="pasienpekerjaan" class="form-control" required="required" value="" style="height: 50px;">
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
          <input type="number" id="pasientelepon" name="pasientelepon" autocomplete="off" class="form-control" placeholder="Telepon / HP" required="required" value="" maxlength="15">
          <label for="pasientelepon">Telepon / HP</label>
        </div>
      </div>
      <div class="col-md-2 d-md-inline-block form-inline ml-auto mr-0 mr-md-0 my-2 my-md-0">
        <div class="form-label-group">
          <div class="checkbox">
            <label><input type="checkbox" required> &ensp;Konfirmasi Perubahan</label>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group input-group date" data-provide="datepicker" data-date-format="yyyy-mm-dd">
          <input type="text" class="form-control" id="pasienlahir" name="pasienlahir" required style="height: 50px;" placeholder="Tanggal Lahir" maxlength="10">
          <div class="input-group-addon">
            <span class="glyphicon glyphicon-th"></span>
		  </div>
          <label for="pasienlahir">Tanggal Lahir</label>
        </div>
      </div>
      <div class="col-md-2 d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-0 my-2 my-md-0">
        <div class="form-label-group">
          <a class="btn btn-danger btn-block" href="<?php echo base_url('pasien')?>">Batal</a>
        </div>
      </div>
      <div class="col-md-2 d-none d-md-inline-block form-inline">
        <div class="form-label-group">
          <button class="btn btn-primary btn-block" href="" type="submit">Simpan</button>
        </div>
      </div>
    </div>
  </div>
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" style="color: black">- Data yang dimasukkan benar adanya sesuai dengan data diri sebenar-benarnya</li>
  </ol>
</form>
</div>
</div>