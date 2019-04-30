<!DOCTYPE html>
<html lang="en">
<head>
    <?php $this->load->view('admin/_partial/_login/login_head');?>
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
		
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="<?php echo base_url('assets/login/images/logo.png')?>" alt="IMG">
				</div>

				<form class="login100-form validate-form" action = "<?php echo base_url('admin/login'); ?>" method = "post">
					
					<span class="login100-form-title">
						PUSKESMAS SUMBERSARI
					</span>
					
					<span class="login100-form-co-title">
						Admin Login
					</span>

					<div class="wrap-input100">
						<input class="input100" type="text" name="username" required placeholder="Username" autocomplete="off">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="password" name="password" required placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit" value="Login">
							Login
						</button>
					</div>					
				</form>
			</div>
		</div>
	</div>
    <?php $this->load->view('admin/_partial/_login/login_script');?>
</body>
</html>