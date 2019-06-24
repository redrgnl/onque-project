<div class="form-row">
<div class="card-body col-md-7">
  <div class="col-xl-12 col-sm-12 mb-12">
    <div class="card mb-3">
      <div class="card-header bg-primary" style="color: white">
        <i class="fas fa-user"></i>
          Pilih Pasien
      </div>
      <div class="card-body">
        <div class="table-responsive">
          <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <thead>
              <tr>
                <th>Nama</th>
                <th>Alamat</th>
                <th style="width: 50px">Pilih</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach($pasien as $pass) { ?>
              <tr>
                <td><?php echo $pass->pas_nama?></td>
                <td><?php echo $pass->pas_alamat?></td>
                <td>
                  <button class="btn btn-success" 
                    onclick="optionpasien('<?php echo $pass->pas_index?>','<?php echo $pass->pas_nama?>','<?php echo $pass->pas_alamat?>')">
                      <i class="fas fa-share"></i>
                  </button>  
                </td>
              </tr>
              <?php } ?>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="card-body col-md-4">
<form method="post" action="<?php echo base_url('antrian/antrianpasien')?>">
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-9">
        <h5>Puskesmas Sumbersari</h5>
          <span>- Form Penambahan Antrian Baru -</span> <br><br>
          <span><i class="fa fa-asterisk" style="color: red"></i> Pilih Pasien Pada Tabel</span>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-12">
        <div class="form-label-group">
          <?php if(empty($auto)) { $auto = "1";}?>
          <input type="text" id="nomorUrut" name="nomorUrut" autocomplete="off" class="form-control" placeholder="Nomor Urut" required="required" value="<?php echo $auto?>" maxlength="30" readonly>
          <label for="nomorUrut">Nomor Urut</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-12">
        <div class="form-label-group">
          <input type="text" id="pasIndex" name="pasIndex" class="form-control readonly" autocomplete="off" placeholder="Nomor Index" required="required" value="" maxlength="30" >
          <label for="pasIndex">Nomor Index</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-12">
        <div class="form-label-group">
          <input type="text" id="pasNama" name="pasNama" autocomplete="off" class="form-control readonly" placeholder="Nama" required="required" value="" maxlength="30" >
          <label for="pasNama">Nama</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-12">
        <div class="form-label-group">
          <input type="text" id="pasAlamat" name="pasAlamat" class="form-control readonly" autocomplete="off" placeholder="Alamat" required="required" value="" maxlength="30" >
          <label for="pasAlamat">Alamat</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-12">
        <div class="form-label-group">
          <select type="text" id="poliTujuan" name="poliTujuan" class="form-control readonly" required="required" value="" style="height: 50px;">
            <option value="">-- Poli Tujuan --</option>
            <option>Poli Gigi</option>
			<option>Poli Mata</option>
			<option>Poli Umum</option>
			<option>Poli Kandungan</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="form-row">
      <div class="col-md-12">
        <div class="form-label-group">
          <button class="btn btn-primary btn-block" href="" type="submit">Tambah</button>
        </div>
      </div>
    </div>
  </div>
</form>
</div>
</div>