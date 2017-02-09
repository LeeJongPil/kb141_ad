<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Modern | Login - Sign in</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta charset="UTF-8">
<meta name="description" content="Admin Dashboard Template" />
<meta name="keywords" content="admin,dashboard" />
<meta name="author" content="Steelcoders" />

<!-- Styles -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600'
	rel='stylesheet' type='text/css'>
<link
	href="../assets/plugins/pace-master/themes/blue/pace-theme-flash.css"
	rel="stylesheet" />
<link href="../assets/plugins/uniform/css/uniform.default.min.css"
	rel="stylesheet" />
<link href="../assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="../assets/plugins/fontawesome/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link href="../assets/plugins/line-icons/simple-line-icons.css"
	rel="stylesheet" type="text/css" />
<link
	href="../assets/plugins/offcanvasmenueffects/css/menu_cornerbox.css"
	rel="stylesheet" type="text/css" />
<link href="../assets/plugins/waves/waves.min.css" rel="stylesheet"
	type="text/css" />
<link href="../assets/plugins/switchery/switchery.min.css"
	rel="stylesheet" type="text/css" />
<link href="../assets/plugins/3d-bold-navigation/css/style.css"
	rel="stylesheet" type="text/css" />

<!-- Theme Styles -->
<link href="../assets/css/modern.min.css" rel="stylesheet"
	type="text/css" />
<link href="../assets/css/themes/white.css" class="theme-color"
	rel="stylesheet" type="text/css" />
<link href="../assets/css/custom.css" rel="stylesheet" type="text/css" />

<script src="../assets/plugins/3d-bold-navigation/js/modernizr.js"></script>
<script src="../assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body class="page-login">
	<style>
.checkLogin {
	color: red;
	font-size: 13px;
}

.cw {
	margin-top: 15px;
}

.remember {
	margin-bottom: 20px;
}
</style>
	<main class="page-content">
	<div class="page-inner">
		<div id="main-wrapper">
			<div class="row">
				<div class="col-md-3 center">
					<div class="login-box">
						<a href="#" class="logo-name text-lg text-center">Modern</a>
						<p class="text-center m-t-md">Please login into your account.</p>
						<c:url value="/login" var="loginUrl" />
						
						<form action="${loginUrl}" method="post" class="m-t-md">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Id"
									id="username" name="username" required>
							</div>
							<div class="form-group">
								<input type="password" class="form-control"
									placeholder="Password" id="password" name="password" required>
							</div>

							<button type="submit" class="btn btn-success btn-block">Login</button>
							<p class="display-block text-center m-t-md text-sm remember">
								<input type="checkbox" name="_spring_security_remember_me"
									value="true" />Remember Me
							</p>
							<sec:csrfInput />
							<c:if test="${param.error != null}">
								<p class="display-block text-center m-t-md text-sm checkLogin">아이디나 비밀번호를 확인해주세요.</p>
							</c:if>
							<c:if test="${param.logout != null}">
								<p class="display-block text-center m-t-md text-sm">로그아웃
									되었습니다.</p>
							</c:if>
							<p class="text-center m-t-xs text-sm">Do not have an account?</p>
							<a href="register" class="btn btn-default btn-block">Create
								an account</a>
						</form>


						<p class="cw text-center m-t-xs text-sm">2015 &copy; Modern by
							Steelcoders.</p>
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
	<script src="../assets/plugins/jquery/jquery-2.1.3.min.js"></script>
	<script src="../assets/plugins/jquery-ui/jquery-ui.min.js"></script>
	<script src="../assets/plugins/pace-master/pace.min.js"></script>
	<script src="../assets/plugins/jquery-blockui/jquery.blockui.js"></script>
	<script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="../assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/plugins/switchery/switchery.min.js"></script>
	<script src="../assets/plugins/uniform/jquery.uniform.min.js"></script>
	<script src="../assets/plugins/offcanvasmenueffects/js/classie.js"></script>
	<script src="../assets/plugins/offcanvasmenueffects/js/main.js"></script>
	<script src="../assets/plugins/waves/waves.min.js"></script>
	<script src="../assets/plugins/3d-bold-navigation/js/main.js"></script>
	<script src="../assets/js/modern.min.js"></script>
	<script>
		var result = '${msg}';
		if (result == "success") {
			alert("회원가입이 완료되었습니다.");
		}
	</script>
</body>
</html>