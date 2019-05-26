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
<script>
$(document).ready(function(){
 var curday = function(sp){
 today = new Date();
 var dd = today.getDate();
 var mm = today.getMonth()+1; //As January is 0.
 var yyyy = today.getFullYear();

 if(dd<10) dd='0'+dd;
 if(mm<10) mm='0'+mm;
 return (yyyy+sp+mm+sp+dd);
 };
    
 load_data(curday('-'));

 function load_data(query)
 {
  $.ajax({
   url:"<?php echo base_url(); ?>laporan/fetch",
   method:"POST",
   data:{query:query},
   success:function(data){
    $('#result').html(data);
   }
  })
 }

 $('#btn-search').on('click',function(){
  var search = $('#srcharian').val();
  if(search != '')
  {
   load_data(search);
  }
  else
  {
   load_data();
  }
 });
});
</script>