<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
    
            <div class="page-inner" >
                <div class="page-title">
                    <h3>Dashboard</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="client/index.html">Home</a></li>
                            <li class="active">Dashboard</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
                    <div class="row">
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white" style="height: 145px;">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <h1><p><span class="counter">${adCount.size()}</span> 개</p></h1>
                                        <span class="info-box-title">전체  광고 .</span>
                                    </div>
                        	            <div class="info-box-icon">
                                  		      <small><i class="icon-info"></i></small>
                                	    </div> 
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white" style="height: 145px;">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                    <h1><p><span class="counter">${logCount } </span> 명</p></h1>
                                        <span class="info-box-title">광고를 본 숫자</span>
<!--                                         <span class="info-box-title">광고를 본 닝겐 수 / 10000</span> -->
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-eye"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white" style="height: 145px;">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <h1><p><span class="counter">${Adviewership} </span> %</p></h1>
                                        <span class="info-box-title">전일 대비 광고 시청률</span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-basket"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel info-box panel-white" style="height: 145px;">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                       <h1><p> ${emotion.target_emotions }</p></h1>
                                        <span class="info-box-title">대표적으로 원하는 감정 </span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-star"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
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
	             						<div class="panel panel-white">
			                                <div class="panel-heading">
			                                    <h3 class="panel-title"> 연령별 / 성별  / 시청시간</h3>
			                                </div>
			                                <div class="panel-body">
			                                    <div>
			                                        <canvas id="chartAgeGenderWatchtime" style="height: 100px; width: 100%;"></canvas>
			                                    </div>
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
                        </div><!-- Row -->
						<div class="row">
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
                
		<%@include file="footer.jsp"%>
		<script src="/assets/plugins/chartsjs/Chart.min.js" ></script>
        <script src="/assets/js/pages/dashboard.js"></script>
        <script src="/assets/js/pages/profile.js"></script>
   		<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzjeZ1lORVesmjaaFu0EbYeTw84t1_nek&callback=initMap"  async defer></script>
    
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
		<c:forEach items="${deviceList}" var="device">
		var marker${device.state} = new google.maps.Marker({
			position : {
				lat : ${device.lat},
				lng : ${device.lng}
			},
			map : map,
			title : '${device.state}'
		});
		openInfo(marker${device.state});

		</c:forEach>
		};
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
		$("#tabIndex").attr("class","active");
		
		// Age, Gender / Watch Time
	 	
	 	var data7_labels = new Array();
	 	for(var i = 0 ; i < 20 ; i ++) {
	 		data7_labels.push(i + 1);
	 	}
	 	
	 	var data7_male = [<c:forEach items="${data.view_watchtime_male}" var="i">${i},</c:forEach>];
	 	var data7_female = [<c:forEach items="${data.view_watchtime_female}" var="i">${i},</c:forEach>];
	 	
	     var data7 = {
	             labels:data7_labels,
	             datasets: [
	                 {
	                     label: "My First dataset",
	                     fillColor: "rgba(220,220,220,0.2)",
	                     strokeColor: "rgba(220,220,220,1)",
	                     pointColor: "rgba(220,220,220,1)",
	                     pointStrokeColor: "#fff",
	                     pointHighlightFill: "#fff",
	                     pointHighlightStroke: "rgba(220,220,220,1)",
	                     data: data7_male
	                 },
	                 {
	                     label: "My Second dataset",
	                     fillColor: "rgba(34,186,160,0.2)",
	                     strokeColor: "rgba(34,186,160,1)",
	                     pointColor: "rgba(34,186,160,1)",
	                     pointStrokeColor: "#fff",
	                     pointHighlightFill: "#fff",
	                     pointHighlightStroke: "rgba(18,175,203,1)",
	                     data: data7_female
	                 }
	             ]
	         };
	     
	     
	  // CHART 생성
	 	var doughnutAttribute = {
	 	        segmentShowStroke : true,
	 	        segmentStrokeColor : "#fff",
	 	        segmentStrokeWidth : 2,
	 	        animationSteps : 100,
	 	        animationEasing : "easeOutBounce",
	 	        animateRotate : true,
	 	        animateScale : false,
	 	        responsive: true
	 	    };
	 	
	 	var barAttribute = {
	 			scaleBeginAtZero : true,
	 			scaleShowGridLines : true,
	 			scaleGridLineColor : "rgba(0,0,0,.05)",
	 			scaleGridLineWidth : 1,
	 			scaleShowHorizontalLines: true,
	 			scaleShowVerticalLines: true,
	 			scaleYaxesStacked : true,
	 			barShowStroke : true,
	 			barStrokeWidth : 1,
	 			barDatasetSpacing : 1,
	 			responsive: true
	 		};
	 	
	 	var lineAttribute = {
	 	        scaleShowGridLines : true,
	 	        scaleGridLineColor : "rgba(0,0,0,.05)",
	 	        scaleGridLineWidth : 1,
	 	        scaleShowHorizontalLines: true,
	 	        scaleShowVerticalLines: true,
	 	        bezierCurve : true,
	 	        bezierCurveTension : 0.4,
	 	        pointDot : true,
	 	        pointDotRadius : 4,
	 	        pointDotStrokeWidth : 1,
	 	        pointHitDetectionRadius : 20,
	 	        datasetStroke : true,
	 	        datasetStrokeWidth : 2,
	 	        datasetFill : true,
	 	        responsive: true
	 	    }

	 	
	 	var radarAttribute = {
	 			scaleShowLine : true,
	 			angleShowLineOut : true,
	 			scaleShowLabels : false,
	 			scaleBeginAtZero : true,
	 			angleLineColor : "rgba(0,0,0,.1)",
	 			angleLineWidth : 1,
	 			pointLabelFontFamily : "'Arial'",
	 			pointLabelFontStyle : "normal",
	 			pointLabelFontSize : 10,
	 			pointLabelFontColor : "#666",
	 			pointDot : true,
	 			pointDotRadius : 3,
	 			pointDotStrokeWidth : 1,
	 			pointHitDetectionRadius : 20,
	 			datasetStroke : true,
	 			datasetStrokeWidth : 2,
	 			datasetFill : true,
	 			responsive: true
	 		}  
	     
	     
	     
	     
	     var ctx7 = document.getElementById("chartAgeGenderWatchtime").getContext("2d");
	     var chart7 = new Chart(ctx7).Line(data7, lineAttribute);
	     
	     
		
		
		$(document).ready(function(){
		
		     $("body").attr("class","page-header-fixed page-sidebar-fixed");
		     $("main").attr("class","page-content content-wrap full-height");
		     
		     
		     
	});
// 		     console.log($(".user-name")[0].innerText);
		
		
		
		
		
		
    </script>
    
    
     </body>
</html>