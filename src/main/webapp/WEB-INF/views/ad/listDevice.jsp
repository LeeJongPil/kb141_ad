<%@include file="header.jsp"%>
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

.dno{
margin-top: -15px;
}

.infoH2{
font-weight: 500;

}

.infoHr{
width : 300px;
border: 1px solid black;
margin-top: 10px;
}
</style>
<div class="page-inner full-height">
	<div id="map-canvas"></div>

	</body>

	<%@include file="footer.jsp"%>
	<script>
		var map;
		var lat;
		var lng;
		
		
		function initMap() {
			map = new google.maps.Map(document.getElementById('map-canvas'), {
				center : {
					lat : 37.494505,
					lng : 127.028022
				},
				zoom : 8
			});

			<c:forEach items="${device}" var="device">
			
			var marker${device.dno} = new google.maps.Marker({
				position : {
					lat : ${device.lat},
					lng : ${device.lng}
				},
				map : map,
				title : '${device.dno}' 
			});
			
			openInfo(marker${device.dno});
			

			
// 			var contentString = '<div><a href="'dno+'">'+markerName.title+'</a></div>';
			
			
			
			
			</c:forEach>

		}
		
		var prev_infowindow =false;
		
		function openInfo(markerName) {
			var dno = markerName.title;
			
			markerName.addListener('click', function() {
				var str = "<div class='dno'><h2 class='infoH2'>No. "+dno+"</h2><hr class='infoHr'></div>";

			
				$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&language=ko&key=AIzaSyDho-ovmiGXI8BKnzuQyzqJ_bAxWP4qkhM", function (data) {
					var lotNumAddress = "<p>"+data.results[0].formatted_address+"</p>";
					var rodeNameAddress = "<p>"+data.results[1].formatted_address+"</p>";
					console.log(lotNumAddress);
					console.log(rodeNameAddress);
					$('.dno').append(lotNumAddress);
					$('.dno').append(rodeNameAddress);
					
				});
				
				
				
				   if( prev_infowindow ) {
			           prev_infowindow.close();
			        }

				$.getJSON("../ad/adFromDevice/"+dno, function(data) {
					if(data.length==0){
						str += "현재 광고가 없습니다.";
					}
					$(data).each( function() {
						str += "<div><a href='"+this.adno+"'>"+this.ad_title+"</a></div>";
					});

					var infowindow = new google.maps.InfoWindow({
						content : str
					});	
					
					prev_infowindow = infowindow;
					infowindow.open(map, markerName);
				});
				
				
				
			});

		}

		function makeMarker(name, markerLat, markerLng, markerTitle) {
			var name = new google.maps.Marker({
				position : {
					lat : markerLat,
					lng : markerLng
				},
				map : map,
				title : markerTitle,
			});
		}
 
		$(document).ready(function() {
			$("body").attr("class", "page-header-fixed page-sidebar-fixed");
			// 			$("main").attr("class", "page-content content-wrap full-height");
		});
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCgODk3nW5Qg39325e8Tp1KAcoUCG5coaA&callback=initMap">
		
	</script>
	</html>