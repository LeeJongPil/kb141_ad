<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style>
.form-horizontal {
	margin-top: 10px;
	margin-bottom: 10px;
}

.latSpan {
	color: red;
	font-size: 11px;
}

.lngSpan {
	color: red;
	font-size: 11px;
}

/* .form-group { */
/* 	margin-bottom: 25px; */
/* } */

.panel{
padding-top: 25px;
}

.panel-body{
padding-right: 25px; 
}

.control-label{
left : -5px; 
}
 
.form-group .col-sm-8{
padding-left: 0px;
padding-right: 30px;
}

.submitBtn{
margin-top: 30px; 
}



/* .logo-name{ */
/* margin-top: 30px; */
/* } */
</style>
<div class="page-inner">
	<div class="page-title">
		<h3>Form Elements</h3>
		<div class="page-breadcrumb">
			<ol class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="#">Forms</a></li>
				<li class="active">Form Elements</li>
			</ol>
		</div>
	</div>
	<div id="main-wrapper">
		<div class="row">
			<div class="col-md-3 center">
				<div class="panel panel-white">
					<p class="logo-name text-lg text-center">Register</p>
					<p class="text-center m-t-md">Create a Modern's account</p>
					<div class="panel-body">
						<form class="form-horizontal" method="post">
							<div class="form-group">
								<label for="dno" class="col-sm-4 control-label">기기 번호: </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="dno" name="dno"
										placeholder="${lastDno}" value="${lastDno}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label for="lat" class="col-sm-4 control-label">위도: </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="lat" name="lat"><span
										class="latSpan"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="lng" class="col-sm-4 control-label">경도:</label><span
									class="lngSpan"></span>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="lng" name="lng">
								</div>
							</div>
							<div class="form-group">
								<label for="state" class="col-sm-4 control-label">지역1: </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="state" name="state"
										placeholder="위도, 경도를 입력해주세요" readonly>
								</div>
							</div>
							<div class="form-group">
								<label for="city" class="col-sm-4 control-label">지역2: </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="city" name="city"
										placeholder="위도, 경도를 입력해주세요" readonly>
								</div>
							</div>
							<div class=" col-sm-5 center"> 
							<button type="submit" class="submitBtn btn btn-success btn-block m-t-xs">Submit</button>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token }" />
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Row -->
	</div>
	<!-- Main Wrapper -->
	<%@include file="../footer.jsp"%>
	<script type="text/javascript">
		
	var pLat = $('#lat')[0].value;
	var pLng = $('#lng')[0].value;
	if(pLat != "" && pLng != ""){
		$(".lngSpan").html("");
		$(".latSpan").html("");
	}
	
		var time = null;
		$("#lat").keyup(function(event) {
			$(".latSpan").html("");
			clearTimeout(time);
			var pLat = $('#lat')[0].value;
			var pLng = $('#lng')[0].value;
			if (pLat != "" && pLng != "") {
				$(".lngSpan").html("");
				time = setTimeout(getAddress(pLat, pLng), 2000);
				return [ onlyNumber(event), time ];
			} else if (pLng == "") {
				setTimeout(function() {
					$(".lngSpan").html("※경도를 입력해주세요.");
				}, 4000);
				return onlyNumber(event);
			}
		});

		//1. 숫자만 입력되야한다.
		//2. 위도, 경도가 모두 입력되어있을 경우 계산
		//3. 경도 입력 후 3초가 지나도 입력이 없을 경우, 위도를 입력해달라고 나옴
		$("#lng").keyup(function(event) {
			$(".lngSpan").html("");
			clearTimeout(time);
			var pLat = $('#lat')[0].value;
			var pLng = $('#lng')[0].value;

			if (pLat == "") {
				setTimeout(function() {
					$(".latSpan").html("※위도를 입력해주세요.");
				}, 3000);
				return onlyNumber(event);
			} else if (pLat != "" && pLng != "") {
				$(".latSpan").html("");
				time = setTimeout(getAddress(pLat, pLng), 2000);
				return [ onlyNumber(event), time ];
			} else {
				return onlyNumber(event);
			}
		});
		
		
		

		$("#lat").mouseleave(
				function(event) {
					var onlyNum = /^[+-]?\d*(\.?\d*)$/;
					clearTimeout(time);
					var pLat = $('#lat')[0].value;
					var pLng = $('#lng')[0].value;
					if (pLat != "") {
						$(".latSpan").html("");
						if (pLng == "") {
							setTimeout(function() {
								$(".lngSpan").html("※경도를 입력해주세요.");
							}, 3000);
						}
						if (!onlyNum.test(pLat)) {
							alert("숫자만 입력 가능합니다.");
							event.target.value = event.target.value.replace(
									/[^-\.0-9]/g, "");
						}
					}
					if (pLat != "" && pLng != "") {
						time = setTimeout(getAddress(pLat, pLng), 2000);
					}
				});

		$("#lng").mouseleave(
				function(event) {
					var onlyNum = /^[+-]?\d*(\.?\d*)$/;
					clearTimeout(time);
					var pLat = $('#lat')[0].value;
					var pLng = $('#lng')[0].value;
					if (pLng != "") {
						$(".lngSpan").html("");
						if(pLat==""){
							setTimeout(function() {
								$(".latSpan").html("※위도를 입력해주세요.");
							}, 3000);
						}
						if (!onlyNum.test(pLng)) {
							alert("숫자만 입력 가능합니다.");
							event.target.value = event.target.value.replace(
									/[^-\.0-9]/g, "");
						}
					}
					if (pLat != "" && pLng != "") {
						time = setTimeout(getAddress(pLat, pLng), 2000);
					}
				});

		// 		$("#lng").blur(function (event) {
		// 			$(".lngSpan").html("");
		// 			clearTimeout(time);
		// 			var pLat = $('#lat')[0].value;
		// 			var pLng = $('#lng')[0].value;

		// 			if (pLat == "") {
		// 				setTimeout(function() {
		// 					$(".latSpan").html("※위도를 입력해주세요.")
		// 				}, 3000);
		// 				return onlyNumber(event);
		// 			} else if (pLat != "" && pLng != "") {
		// 				time = setTimeout(getAddress(pLat, pLng), 2000);
		// 				return [ onlyNumber(event), time ];

		// 			} else {
		// 				return onlyNumber(event);
		// 			}
		// 		});

		// 		$("#lng").keyup(function(event) {
		// 			clearTimeout(time);
		// 			var pLat = $('#lat')[0].value;
		// 			var pLng = $('#lng')[0].value;
		// 			if (pLat != "" && pLng != "") {
		// 				time = setTimeout(getAddress(pLat, pLng), 2000);
		// 				return time;
		// 			} else
		// 				setTimeout(function() {
		// 					$(".latSpan").html("※위도를 입력해주세요.")
		// 				}, 3000);
		// 		});

		function getAddress(pLat, pLng) {
			var lat = pLat;
			var lng = pLng;
			return function geoCoding() {
				console.log(lat);
				console.log(lng);
				$.ajax({url : "https://maps.googleapis.com/maps/api/geocode/json?latlng="
									+ lat
									+ ","
									+ lng
									+ "&language=ko&key=AIzaSyDho-ovmiGXI8BKnzuQyzqJ_bAxWP4qkhM",
							type : "GET",
							success : function(data) {
								console.log(data);
								if(data.status=="OK"){
								var fullAddress = data.results[0].formatted_address;
								var AddressArray = fullAddress.split(' ');
								var state = AddressArray[1].substring(0, 2);
								var city;
								if(AddressArray[2].length==2){
									city = AddressArray[2];
								}
								else{
			
								city = AddressArray[2].substring(0,AddressArray[2].length - 1);
								}
								$("#state").attr("value", state);
								$("#city").attr("value", city);
							}else {
								var state = "위도, 경도를 확인해주세요."
								var city = "위도, 경도를 확인해주세요."
								$("#state").attr("value", state);
								$("#city").attr("value", city);
							}
							}
						});
			};
		}

		//위도 경도에 숫자만 입력되게 하는 함수
		function onlyNumber(event) {
// 			console.log(event);
			event = event || window.event;
			var keyID = (event.which) ? event.which : event.keyCode;
			if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
					|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39
					|| keyID == 40 || keyID == 189 || keyID == 190
					|| keyID == 229)
				return;
			else
				alert("숫자만 입력 가능합니다.");
			event.target.value = event.target.value.replace(/[^-\.0-9]/g, "");
		}
	</script>