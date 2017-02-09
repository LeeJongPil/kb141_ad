<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style type="text/css">
main {
	height: 100%;
}

#map-canvas {
	height: 100%;
}

.infoDIV {
	margin-top: 5px;
}

.infoH2 {
	font-weight: 500;
	display: inline;
}

.infoHr {
	width: 350px;
	border: 1px solid black;
	margin-top: 10px;
	margin-bottom: 10px;
}

.adList a{
color:#4E5E6A;
}

.infoDIV .fa{
font-size:16px;
/* padding-left: 8px; */
}


.infoDIV button{
 background-color: rgba( 255, 255, 255, 0 );
 border: none;
}



</style>
<form role='form' method='post'><input type='hidden' class='inputDno' name='dno'></button>
<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token }" /></form>
<div class="page-inner full-height">
<div class="address" title="test" data-ad=""></div>
	<div id="map-canvas"></div>

	</body>

	<%@include file="../footer.jsp"%>
	<script>
	
	var formObj = $("form[role='form']");
	console.log(formObj);
	var inputObj = $(".inputDno")
	
	$(document).on("click","#delBtn",function(event) {
		var dno = event.target.parentElement.parentElement.dataset.dno;
		var check = confirm("정말로 삭제하시겠습니까?");
		
		inputObj.attr("value",dno);
		formObj.attr("action","/admin/device/remove");
		
		if(check)
			formObj.submit();
		else alert("취소되었습니다.");
	});
	
	
	
	var result = '${msg}';
	if(result=="success"){
		alert("처리가 완료되었습니다.");
	}
	
		var map;
		
		function initMap() {
			map = new google.maps.Map(document.getElementById('map-canvas'), {
				center : {
					lat : 37.494505,
					lng : 127.028022
				},
				zoom : 8
			});
			
			<c:forEach items="${device}" var="device">
			
			lat = ${device.lat};
			lng = ${device.lng};

			$.ajax({
				url : "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&language=ko&key=AIzaSyDho-ovmiGXI8BKnzuQyzqJ_bAxWP4qkhM",
				type:"GET",
				success:function(data){
// 					console.log(data);
					var lotNumAddress = data.results[0].formatted_address;
					var rodeNameAddress = data.results[1].formatted_address;
					
					var marker${device.dno} = new google.maps.Marker({
						position : {
							lat : ${device.lat},
							lng : ${device.lng}
						},
						map : map,
						title : '${device.dno}',
						lotAd : lotNumAddress,
						rodeAd : rodeNameAddress
					});
					openInfo(marker${device.dno});
				}
			});
			</c:forEach>

		}
		
		var prev_infowindow =false;
		
		function openInfo(markerName) {
			var dno = markerName.title;
			var lat = this.lat;
			var lng = this.lng;
			var lotAd = markerName.lotAd;
			var rodeAd = markerName.rodeAd;
// 			console.log(lat);
// 			console.log(lng);
// 			console.log(lotAd);
// 			console.log(rodeAd);
			
// 			console.log(lotNumAddress);
// 			console.log(rodeNameAddress);
			markerName.addListener('click', function() {
				
				var str = "<div class='infoDIV' data-dno='"+dno+"'><h2 class='infoH2'>No. "+dno+"</h2><button type='submit'><i class='fa fa-trash' id='delBtn'></i></button><hr class='infoHr'></div>"
				+"<div><p>"+rodeAd +"<br/>"+lotAd +"</p></div>";
				
				   if( prev_infowindow ) {
			           prev_infowindow.close();
			        }

				$.getJSON("../device/adFromDevice/"+dno, function(data) {
					//data가 없으면
					if(data.length==0){
						str += "현재 광고가 없습니다.";
					}
					//있으면
					$(data).each( function() {
						str += 	"<div class='adList'><a href='../profile2?adno="+this.adno+"'>"+this.ad_title+"</a></div>";
					});

					var infowindow = new google.maps.InfoWindow({
						content : str
					});	
					
					prev_infowindow = infowindow;
					infowindow.open(map, markerName);
				});
			});

		}

// 		function makeMarker(name, markerLat, markerLng, markerTitle) {
// 			var name = new google.maps.Marker({
// 				position : {
// 					lat : markerLat,
// 					lng : markerLng
// 				},
// 				map : map,
// 				title : markerTitle,
// 			});
// 		}
 
		$(document).ready(function() {
			$("body").attr("class", "page-header-fixed page-sidebar-fixed");
			// 			$("main").attr("class", "page-content content-wrap full-height");
		});
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCgODk3nW5Qg39325e8Tp1KAcoUCG5coaA&callback=initMap">
		
	</script>
	</html>