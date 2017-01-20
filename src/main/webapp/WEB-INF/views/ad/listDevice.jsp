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
</style>
<div class="page-inner full-height">
	<div id="map-canvas"></div>

	</body>

	<%@include file="footer.jsp"%>
	<script>
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
			var marker${device.dno} = new google.maps.Marker({
				position : {
					lat : ${device.lat},
					lng : ${device.lng}
				},
				map : map,
				title : '${device.dno}'
			});
			openInfo(marker${device.dno});
			
			</c:forEach>
			
			
			
// 			openInfo(marker);

// 			openInfo(marker2);

		}

		function openInfo(markerName) {
			console.log(markerName.title);
			var contentString = '<div><a href="'+markerName.title+'">'+markerName.title+'</a></div>';
			var infowindow = new google.maps.InfoWindow({
				content : contentString
			});
			markerName.addListener('click', function() {
				infowindow.open(map, markerName);
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