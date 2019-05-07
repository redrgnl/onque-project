<!DOCTYPE html>
<html lang="en">

  <head>
    <?php $this->load->view('admin/_partial/head');?>
  </head>

  <body id="page-top">
    <?php $this->load->view('admin/_partial/nav_top')?>
    <div id="wrapper">
      <?php $this->load->view('admin/_partial/nav_side')?>
      <div id="content-wrapper">
        <div class="container-fluid">
          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item active"><?php echo $breadcrumb?></li>
          </ol>
          <!-- Icon Cards-->
            <?php $this->load->view($content)?>
          <!-- DataTables Example -->
        </div>
        <?php $this->load->view('admin/_partial/footer');?>
      </div>
      <!-- /.content-wrapper -->
    </div>
    <?php $this->load->view('admin/_partial/script');?>
    <?php $this->load->view('admin/_partial/javascript')?>

  </body>

</html>