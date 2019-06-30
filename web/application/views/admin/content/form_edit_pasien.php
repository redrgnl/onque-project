<?php $this->load->view('admin/_partial/header')?>
<div class="form-row">
<div class="card-body">
<?php foreach($pasien as $data){ ?>
<form method="post" action="<?php echo base_url('pasien/update_pasien');?>">
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasienindex" name="edpasienindex" class="form-control" readonly placeholder="No. Index" required="required" value="<?php echo $data->pas_index?>" maxlength="20">
          <label for="edpasienindex">No. Index</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasienagama" name="edpasienagama" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Agama --</option>
            <?php
            $agama = $data->pas_agama;
            if ($agama == "Islam") echo "<option value='Islam' selected>Islam</option>";
            else echo "<option value='Islam'>Islam</option>";
            if ($agama == "Kristen") echo "<option value='Kristen' selected>Kristen</option>";
            else echo "<option value='Kristen'>Kristen</option>";
            if ($agama == "Katolik") echo "<option value='Katolik' selected>Katolik</option>";
            else echo "<option value='Katolik'>Katolik</option>";
            if ($agama == "Hindu") echo "<option value='Hindu' selected>Hindu</option>";
            else echo "<option value='Hindu'>Hindu</option>";
            if ($agama == "Budha") echo "<option value='Budha' selected>Budha</option>";
            else echo "<option value='Budha'>Budha</option>";
            if ($agama == "Konghucu") echo "<option value='Konghucu' selected>Konghucu</option>";
            else echo "<option value='Konghucu'>Konghucu</option>";                      
            ?>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="number" id="edpasiennik" name="edpasiennik" autocomplete="off" class="form-control" placeholder="Nomor Induk Kependudukan" required="required" value="<?php echo $data->pas_nik?>" maxlength="17">
          <label for="edpasiennik">Nomor Induk Kependudukan</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasienpendidikan" name="edpasienpendidikan" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Pendidikan --</option>
            <?php
            $pendidikan = $data->pas_pendidikan;
            if ($pendidikan == "Sarjana") echo "<option value='Sarjana' selected>Sarjana</option>";
            else echo "<option value='Sarjana'>Sarjana</option>";
            if ($pendidikan == "SMA / SMK / MAN") echo "<option value='SMA / SMK / MAN' selected>SMA / SMK / MAN</option>";
            else echo "<option value='SMA / SMK / MAN'>SMA / SMK / MAN</option>";
            if ($pendidikan == "SD / MI") echo "<option value='SD / MI' selected>SD / MI</option>";
            else echo "<option value='SD / MI'>SD / MI</option>";
            if ($pendidikan == " - ") echo "<option value=' - ' selected> - </option>";
            else echo "<option value=' - '> - </option>";
            ?>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasiennama" name="edpasiennama" autocomplete="off" class="form-control" placeholder="Nama" required="required" value="<?php echo $data->pas_nama?>" maxlength="30">
          <label for="edpasiennama">Nama</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasienkelamin" name="edpasienkelamin" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Jenis Kelamin --</option>
            <?php
            $kelamin = $data->pas_kelamin;
            if ($kelamin == "Laki - Laki") echo "<option value='Laki - Laki' selected>Laki - Laki</option>";
            else echo "<option value='Laki - Laki'>Laki - Laki</option>";
            if ($kelamin == "Perempuan") echo "<option value='Perempuan' selected>Perempuan</option>";
            else echo "<option value='Perempuan'>Perempuan</option>";  
            ?>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="text" id="edpasiennamakk" name="edpasiennamakk" autocomplete="off" class="form-control" placeholder="Nama KK / Penanggung Jawab" required="required" value="<?php echo $data->pas_kk?>" maxlength="30">
          <label for="edpasiennamakk">Nama KK / Penanggung Jawab</label>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-label-group">
          <select type="text" id="edpasiendarah" name="edpasiendarah" class="form-control" required="required" value="" style="height: 50px;">
            <option value="">-- Golongan Darah --</option>
            <?php
            $darah = $data->pas_darah;
            if ($darah == "O+") echo "<option value='O+' selected>O+</option>";
            else echo "<option value='O+'>O+</option>";
            if ($darah == "O-") echo "<option value='O-' selected>O-</option>";
            else echo "<option value='O-'>O-</option>";
            if ($darah == "A+") echo "<option value='A+' selected>A+</option>";
            else echo "<option value='A+'>A+</option>";
            if ($darah == "A-") echo "<option value='A-' selected>A-</option>";
            else echo "<option value='A-'>A-</option>";
            if ($darah == "AB+") echo "<option value='AB+' selected>AB+</option>";
            else echo "<option value='AB+'>AB+</option>";
            if ($darah == "AB-") echo "<option value='AB-' selected>AB-</option>";
            else echo "<option value='AB-'>AB-</option>";
            if ($darah == "B+") echo "<option value='B+' selected>B+</option>";
            else echo "<option value='B+'>B+</option>";
            if ($darah == "B-") echo "<option value='B-' selected>B-</option>";
            else echo "<option value='B-'>B-</option>";
            if ($darah == " - ") echo "<option value=' - ' selected> - </option>";
            else echo "<option value=' - '> - </option>";
            ?>
          </select>
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
            <?php
            $pekerjaan = $data->pas_pekerjaan;
            if ($pekerjaan == "ASN") echo "<option value='ASN' selected>ASN</option>";
            else echo "<option value='ASN'>ASN</option>";
            if ($pekerjaan == "TNI") echo "<option value='TNI' selected>TNI</option>";
            else echo "<option value='TNI'>TNI</option>";
            if ($pekerjaan == "Polri") echo "<option value='Polri' selected>Polri</option>";
            else echo "<option value='Polri'>Polri</option>";
            if ($pekerjaan == "Swasta") echo "<option value='Swasta' selected>Swasta</option>";
            else echo "<option value='Swasta'>Swasta</option>";
            if ($pekerjaan == "Tani") echo "<option value='Tani' selected>Tani</option>";
            else echo "<option value='Tani'>Tani</option>";
            if ($pekerjaan == "Buruh") echo "<option value='Buruh' selected>Buruh</option>";
            else echo "<option value='Buruh'>Buruh</option>";
            if ($pekerjaan == "Wiraswasta") echo "<option value='Wiraswasta' selected>Wiraswasta</option>";
            else echo "<option value='Wiraswasta'>Wiraswasta</option>";
            if ($pekerjaan == "Wiraswasta") echo "<option value='Wiraswasta' selected>Wiraswasta</option>";
            else echo "<option value='Wiraswasta'>Wiraswasta</option>";
            if ($pekerjaan == " - ") echo "<option value=' - ' selected> - </option>";
            else echo "<option value=' - '> - </option>";  
            ?>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-6">
        <div class="form-label-group">
          <input type="number" id="edpasientelepon" name="edpasientelepon" autocomplete="off" class="form-control" placeholder="Telepon / HP" required="required" value="<?php echo $data->pas_telepon?>" maxlength="15">
          <label for="edpasientelepon">Telepon / HP</label>
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
          <input type="text" class="form-control" id="edpasienlahir" name="edpasienlahir" required style="height: 50px;" placeholder="Tanggal Lahir" value="<?php echo $data->pas_lahir?>" maxlength="10">
          <div class="input-group-addon">
            <span class="glyphicon glyphicon-th"></span>
		  </div>
          <label for="edpasienlahir">Tanggal Lahir</label>
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
</form>
<?php } ?>
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" style="color: black">- Data yang dimasukkan benar adanya sesuai dengan data diri sebenar-benarnya</li>
  </ol>
</div>
</div>