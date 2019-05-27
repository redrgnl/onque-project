<script type="text/javascript">
function deletepasien(url){
	$('#btn-delete-pasien').attr('href', url);
	$('#deletePasien').modal();
}
function deleteadmin(url){
	$('#btn-delete-admin').attr('href', url);
	$('#deleteAdmin').modal();
}
function optionpasien($pasienindex,$pasiennama,$pasienalamat){
    $('#pasIndex').val($pasienindex);
    $('#pasNama').val($pasiennama);
    $('#pasAlamat').val($pasienalamat);
}
</script>