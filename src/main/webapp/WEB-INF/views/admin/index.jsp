<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
            <div class="page-inner">
                <div class="page-title">
                    <h3>Dashboard</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li class="active">Dashboard</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
               
                    <div class="row">
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p class="counter">${adCount}</p>
                                        <span class="info-box-title">광고를 맡긴 숫자.</span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-users"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                    <p><span class="counter">${logCount }  </span>명</p>
                                        <span class="info-box-title">목표 : 10000</span>
<!--                                         <span class="info-box-title">광고를 본 닝겐 수 / 10000</span> -->
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-eye"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: ${logCount/100}%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p><span class="counter">${Adviewership} </span>%</p>
                                        <span class="info-box-title">전일 대비 광고 시청률</span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-basket"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: ${Adviewership}%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                       <p><span class="counter">${msgCount} </span>%</p>
                                        <span class="info-box-title">전달 대비 쪽지 비율</span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-envelope"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:${msgCount}%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <div class="panel panel-white">
                                <div class="row">
                                    <div class="col-sm-9">
                                        <div class="visitors-chart">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">기간 별 본 닝겐 수</h4>
                                            </div>
                                            <div class="panel-body">
                                                <div id="flotchart1"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="stats-info">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">어디서 많이 봤니</h4>
                                            </div>
                                            <div class="panel-body">
                                                <ul class="list-unstyled">

																																<c:forEach items="${devList}" var = "devlist"  begin="0"  end="8">
																																			<li>
																																					${devlist.state}	- ${devlist.city}
																																					<div class="pull-right">${devlist.logPercent}%</div>
																																			</li>
																																</c:forEach>
	                                                
<!--                                                     <li>강 남 구<div class="text-success pull-right">32%<i class="fa fa-level-up"></i></div></li> -->

                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-8 col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">기기 관리</h4>
                                    <div class="panel-control">
                                        <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="Reload" class="panel-reload"><i class="icon-reload"></i></a>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="weather-widget">
                                        <div class="row">
                        <div class="panel panel-white">
                                            <div class="panel-body">
                                                <div class="timeline-item-header">
                                                    <p>기기 관리 <span>전국의 기기관리 현황</span></p>
                                                    <small>6 hours ago</small>
                                                </div>
                                                <div class="timeline-item-post">
                                                    <div id="map-canvas" style="height: 200px; width: 100%;"></div>
                                                </div>
                                            </div>
                                        </div>
                                        
                    
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">메 일</h4>
                                    <div class="panel-control">
                                        <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="Reload" class="panel-reload"><i class="icon-reload"></i></a>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="inbox-widget slimscroll">
                                    
                                    		<c:forEach items="${msgList}"  var="msglist">
                                    					<div class="inbox-item">
                                                <p class="inbox-item-author">${msglist.mfrom}</p>
                                                <p class="inbox-item-text">${msglist.mtitle}</p>
                                                 <p class="inbox-item-date"><fmt:formatDate value="${msglist.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></p>
                                            </div>
                                    		</c:forEach>
                                    		

                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- Main Wrapper -->
    </body>
		<%@include file="footer.jsp"%>
		
        <script  src="/assets/js/pages/dashboard.js"></script>
        <script src="/assets/js/pages/profile.js"></script>
    
    <script>
    $("#mainActive").attr("class","active");	
    var map;
		

    function initMap() {
		map = new google.maps.Map(document.getElementById('map-canvas'), {
			center : {
				lat : 37.494505,
				lng : 127.028022
			},
			zoom : 8
		});
		
		<c:forEach items="${deviceList}" var="device">
		
		lat = ${device.lat};
		lng = ${device.lng};

		$.ajax({
			url : "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&language=ko&key=AIzaSyDho-ovmiGXI8BKnzuQyzqJ_bAxWP4qkhM",
			type:"GET",
			success:function(data){
//					console.log(data);
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
		
		$(document).ready(function(){
	 
     $("body").attr("class","page-header-fixed page-sidebar-fixed");
     $("main").attr("class","page-content content-wrap full-height");
	});	
		
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzjeZ1lORVesmjaaFu0EbYeTw84t1_nek&callback=initMap"  async defer></script>
</html>