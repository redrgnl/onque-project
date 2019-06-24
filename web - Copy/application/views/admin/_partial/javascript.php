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
    $(".readonly").keydown(function(e){
        e.preventDefault();
    });
</script>

<script>    
$("#srcmonthly").datepicker( {
    format: "yyyy-mm",
    viewMode: "months", 
    minViewMode: "months"
});
</script>

<!-- Search Data Antrian -->
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
    
 load_data_daily(curday('-'));
 load_data_monthly(1997+'-'+12)
 //funtion load data daily
 function load_data_daily(query)
 {
  $.ajax({
   url:"<?php echo base_url(); ?>laporan/data",
   method:"POST",
   data:{query:query},
   success:function(data){
    $('#result').html(data);
   }
  })
 }
 //function on click harian
 $('#btn-search').on('click',function(){
  var search = $('#srcdaily').val();
  if(search != '')
  {
   load_data_daily(search);
  }
  else
  {
   load_data_daily(curday('-'));
  }
 });
 
 //function load data monthly
 function load_data_monthly(query)
 {
  $.ajax({
   url:"<?php echo base_url(); ?>laporan/data",
   method:"POST",
   data:{query:query},
   success:function(data){
    $('#result-monthly').html(data);
   }
  })
 }
 //function on click bulanan       
 $('#btn-search-monthly').on('click',function(){
  var search = $('#srcmonthly').val();
  if(search != '')
  {
   load_data_monthly(search);
  }
  else
  {
   load_data_monthly(1997+'-'+12);
  }
 });
});
</script>
