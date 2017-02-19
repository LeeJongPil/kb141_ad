<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Title -->
<title>AD4U | Login - Sign up</title>

<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta charset="UTF-8">
<meta name="description" content="Admin Dashboard Template" />
<meta name="keywords" content="admin,dashboard" />
<meta name="author" content="Steelcoders" />

<!-- Styles -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600'
	rel='stylesheet' type='text/css'>
<link href="assets/plugins/pace-master/themes/blue/pace-theme-flash.css"
	rel="stylesheet" />
<link href="assets/plugins/uniform/css/uniform.default.min.css"
	rel="stylesheet" />
<link href="assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/fontawesome/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/line-icons/simple-line-icons.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/offcanvasmenueffects/css/menu_cornerbox.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/waves/waves.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/plugins/3d-bold-navigation/css/style.css"
	rel="stylesheet" type="text/css" />

<!-- Theme Styles -->
<link href="assets/css/modern.min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/themes/white.css" class="theme-color"
	rel="stylesheet" type="text/css" />
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" />

<script src="assets/plugins/3d-bold-navigation/js/modernizr.js"></script>
<script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>
<body class="page-register">
	<style>
.check span {
	line-height: 30px;
	padding-left: 10px;
}

.login-box .col-md-11 {
	padding-right: 0px;
	padding-left: 30px;
}

.login-box .col-md-9 {
	padding-right: 0px;
	padding-left: 60px;
}

.login-box .col-md-11 {
	padding-right: 0px;
	padding-left: 30px;
}

.login-box label {
	padding-left: 60px;
}
</style>
	<main class="page-content">
	<div class="page-inner">
		<div id="main-wrapper">
			<div class="row">
				<div class="col-md-3 center">
					<div class="login-box">
						<a href="#" class="logo-name text-lg text-center">AD4U</a>
						<p class="text-center m-t-md">우리를 위한 광고 플랫폼</p>
						<!-- 						<form class="m-t-md" action="/register" method="post"> -->
						<form class="m-t-md form" method="post">
							<div class="form-group row check">
								<div class="col-md-11">
									<input type="text" class="form-control" id='id' name="cid"
										placeholder="Id" required>
								</div>
								<span id="checkIdText"></span>
							</div>
							<div class="form-group row check">
								<div class="col-md-11">
									<input type="password" class="form-control" id="password"
										name="cpw" placeholder="Password" required>
								</div>
								<span id="checkLengthText"></span>
							</div>
							<div class="form-group row check">
								<div class="col-md-11">
									<input type="password" class="form-control" id="checkPassword"
										placeholder="Check Password" required>
								</div>
								<span id="checkText"></span>
							</div>
							<div class="form-group row">
								<div class="col-md-11">
									<input type="text" class="form-control" id='company'
										name="company" placeholder="Company">
								</div>
							</div>
							<label> <input type="checkbox" required> 약관에 동의합니다.
							</label>
							<div class="col-md-5 center">
								<button type="submit" id="submitBtn"
									class="btn btn-success btn-block m-t-xs">가입하기</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token }" />
							</div>
						</form>
						<p class="text-center m-t-xs text-sm">2017 &copy; AD4U by
							KB141.</p>
					</div>
				</div>
			</div>
			<!-- Row -->
		</div>
		<!-- Main Wrapper -->
	</div>
	<!-- Page Inner --> </main>
	<!-- Page Content -->
	<!-- Javascripts -->
	<script src="assets/plugins/jquery/jquery-2.1.3.min.js"></script>
	<script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
	<script src="assets/plugins/pace-master/pace.min.js"></script>
	<script src="assets/plugins/jquery-blockui/jquery.blockui.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/switchery/switchery.min.js"></script>
	<script src="assets/plugins/uniform/jquery.uniform.min.js"></script>
	<script src="assets/plugins/offcanvasmenueffects/js/classie.js"></script>
	<script src="assets/plugins/offcanvasmenueffects/js/main.js"></script>
	<script src="assets/plugins/waves/waves.min.js"></script>
	<script src="assets/plugins/3d-bold-navigation/js/main.js"></script>
	<script src="assets/js/modern.min.js"></script>
	<script>
		// 		var password = document.getElementById("password").value;
		// 		var passwordCheck = document.getElementById("checkPassword").value;
		var re_id = /^[a-z0-9_-]{5,16}$/;
		var re_pw = /^[A-za-z0-9_-]{6,18}/g;

		var form = $('.form');
		var id = $('#id');
		var pw = $('#password');
		var pwc = $('#checkPassword');
		var comp = $('#company');

		form.submit(function() {
					if (re_id.test(id.val()) != true) {
						alert("아이디를 확인해주세요.\n아이디는 영문(소문자), 숫자, _, - 포함 가능\n5~16자 사이로 정해주세요.");
						id.focus();
						return false;
					} else if (re_pw.test(pw.val()) != true) {
						alert("비밀번호를 확인해주세요.\n비밀번호는 영문(대소문자 구분), 숫자, _, - 포함 가능\n6~18자 사이로 정해주세요.");
						pw.focus();
						return false;
					} else if (pw.val() != pwc.val()) {
						alert("비밀번호 확인을 체크해주세요.");
						pwc.focus();
						return false;
					} else if (comp.val() == "") {
						alert("회사명을 입력해주세요.");
						comp.focus();
						return false;
					} else if (check!=0) {
						alert("중복된 아이디입니다.");
						id.focus();
						return false;
					}
				});

		$("#checkPassword").keyup(function(event) {
			passwordCheck();
		});

		function passwordCheck() {

			var password = document.getElementById("password").value;
			var passwordCheck = document.getElementById("checkPassword").value;

			if (password == passwordCheck) {
				document.getElementById("checkText").style.color = "#4E5E6A";
				document.getElementById("checkText").innerHTML = "OK";

			} else if (password != passwordCheck) {
				document.getElementById("checkText").style.color = "red";
				document.getElementById("checkText").innerHTML = "X";
			} else {
				document.getElementById("checkText").innerHTML = "";
			}
		}

		
		var check;
		
		id.keyup(function() {
			var checkId = id.val();

			$.ajax({
				url : "/register/checkId/" + checkId,
				type : "GET",
				success : function(data) {
					check = data;
					
					if(check==0 && checkId.length >= 5 && checkId.length <= 16){
						document.getElementById("checkIdText").style.color = "#4E5E6A";
						document.getElementById("checkIdText").innerHTML = "OK";
// 					}else if (check==1 || checkId.length < 5 || checkId.length > 16){
					}else {
						document.getElementById("checkIdText").style.color = "red";
						document.getElementById("checkIdText").innerHTML = "X";
					}
				}
			});
		});
	</script>
</body>
</html>