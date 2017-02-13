<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     


<style>
.col-centered{
   float: none;
   margin: auto;
   text-align: center;
   }
.col-righted{
	float: none;
   	margin: auto;
   	text-align: right;
}   
   
</style>



            
         <div class="page-inner">

          
             <div id="main-wrapper">
	                  <div class="row">  
                    	<div class="col-sm-12 col-lg-6">
                           <div class="panel panel-white" style="height: 275px">
                                <div class="panel-heading">
                                    <div class="panel-title"><i class="fa fa-folder-open"></i> 실험중인 광고이름</div>
                                </div>
                                <div class="panel-body">
                                	
                           		<blockquote>
                           			<p>ClIENT  : ${adVO.ad_title }</p>
                           			<p>SERVICE : ${adVO.category } </p>
                           			<p>D A T E : <fmt:formatDate value="${adVO.start_duration }" pattern="yyyy-MM-dd "/> ~ <fmt:formatDate value="${adVO.end_duration }" pattern="yyyy-MM-dd "/></p>
                           			<p>CONTENT : ${adVO.ad_content }</p>
                           	
                           		</blockquote>
                                </div>
                            </div> 
                          </div>  
                            <div class="col-sm-12 col-lg-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><i class="fa fa-bookmark"></i>  사용중인 기기</h4>
                                    <div class="panel-control">
                                        <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="Reload" class="panel-reload"><i class="icon-reload"></i></a>
                                    </div>
                                </div>
                                   <div class="panel-body">
                                                <div class="timeline-item-post">
                                                    <div id="map-canvas" style="height: 200px; width: 100%;"></div>
                                                </div>
                                </div>
                            </div>
                          </div>
                        </div>
                        
                       <div class="row">
                    	<div class="col-sm-12 col-lg-6">
                    		 <div class="panel panel-white">
                                            <div class="panel-heading">
                                                <h4 class="panel-title"><span class="icon-user-following" aria-hidden="ture"></span> 오늘 광고를 본 남녀 성비</h4>
                                            </div>
                                         <div class="panel-body" style="height: 180px;">
                                        <div class="col-centered">
                                        	<span class="item">
                                        	<h1><span class="icon-symbol-male text-info m-t-xxs" aria-hidden="ture"> <b>${data.male}</b> 명</span></h1>
                                        	<h1><span class="icon-symbol-female text-danger m-t-xxs" aria-hidden="ture"> <b>${data.female }</b> 명</span></h1>
                                        	</span>
                                        </div>
                                    <div class="col-righted">
                                   
                                    <a href="charts-chartjs2.html" class="btn btn-default btn-rounded"> 더보기</a>
                                 	
                                 	</div>
                                 </div>
	                    	</div>
	                    </div>
	                    <div class="col-sm-12 col-lg-6">
                    		 <div class="panel panel-white">
	                            <div class="visitors-chart">
                                   <div class="panel-heading">
                                      <h4 class="panel-title"> <span class="icon-users" aria-hidden="ture"></span> 오늘 광고를 본 연령별</h4>
                                  </div>
                                <div class="panel-body">
                                <div class="col-centered">
	                                	<div class="col-sm-6">
	                                		<h3>10대: ${data.view_age[0] }</h4>
	                                		<h3>20대: ${data.view_age[1] }</h4>
	                                		<h3>30대: ${data.view_age[2] }</h4>
	                                		<h3>40대: ${data.view_age[3] }</h4>
	                                	</div>
                                	
	                                	<div class="col-sm-6">
	                                		<h3>50대: ${data.view_age[4] }</h4>
	                                		<h3>60대: ${data.view_age[5] }</h4>
	                                		<h3>70대: ${data.view_age[6] }</h4>
	                                		<h3></h4>
                                	
                                		</div>
                     				</div>
            
                                </div>
                            </div>
	                      </div>
	                    </div>     
                      </div> 
                      
                    
         	               <div class="row">
                        	 <div class="col-sm-12 col-lg-6">
                              <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white" style="height: 475px;">
                                        <div class="panel-heading">
                                                <h4 class="panel-title"><span class="icon-social-youtube" aria-hidden="ture"></span> 동영상</h4>
                                            </div>
                                            <div class="panel-body col-centered">
                           					   <video width="480" height="360" controls>
												  <source src="http://localhost:8081/admin/viewfile?fileName=${adVO.ad_video }" type="video/mp4">
  											   </video>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-6">
                            <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white" style="height: 475px;">
                                        <div class="panel-heading">
                                                <h4 class="panel-title"><span class="icon-picture" aria-hidden="ture"></span> 포스터</h4>
                                            </div>
                                            <div class="panel-body col-centered">
                                              <img src ="http://localhost:8081/admin/viewfile?fileName=${adVO.ad_image }" style="height: 400px ;width :400px;">
                                       		 </div>
                                       		 </div>
                                    </li>
                                </ul>
                            </div>
                            </div>
                            <br>
                            <br>
                             <div class="row col-righted">
                             	<div class="col-sm-12 col-lg-6"></div>
                             	<div class="col-sm-12 col-lg-6 ">
                             		<a href="profile2Modify.html?adno=${adVO.adno }" type="button" class="btn btn-warning btn-rounded">수정</a>
                             		<button type="button" class="btn btn-primary btn-rounded" id="btnRemove">삭제</button>
                             	</div>
                             </div>
                        </div>
                    </div>
                    <form method="post" id="inputForm">
                    	<input type="hidden" name="adno" value="${adVO.adno }">
                    	<input type="hidden" name="ad_title" value="${adVO.ad_title }">
                    	<input type="hidden" name="category" value="${adVO.category }">
                    	<input type="hidden" name="ad_start_duration" value="${adVO.start_duration}">
                    	<input type="hidden" name="ad_end_duration" value="${adVO.end_duration}">
                    	<input type="hidden" name="ad_title" value="${adVO.ad_content }">
                    	<input type="hidden" name="ad_image" value="${adVO.ad_image }">
                    	<input type="hidden" name="ad_video" value="${adVO.ad_video }">
                    	
                    </form>
    			</body>
        <!-- Javascripts -->
    	<%@include file="footer.jsp"%>
      	<script src="/assets/js/pages/profile.js"></script>
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
 		<c:forEach items="${deviceVO}" var="device">
 		var marker${device.dano} = new google.maps.Marker({
 			position : {
 				lat : ${device.lat},
 				lng : ${device.lng}
 			},
 			map : map,
 			title : '${device.dano}'
 		});
 		openInfo(marker${device.dano});

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
 		$("#profileActive").attr("class","active");
 		$("#btnRemove").on("click", function(event) {
	       	 console.log(event);
	            if (confirm("정말삭제하시겠습니까?") == true) {
	
	                $("#inputForm").attr("action", "profile2Remove").submit();
	            } else {
	                return;
	            }
        	});
		</script>
       	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCgODk3nW5Qg39325e8Tp1KAcoUCG5coaA&callback=initMap"  async defer></script>
        <script>
        
 		$(document).ready(function(){
 			 
 	         $("body").attr("class","page-header-fixed page-sidebar-fixed");
 	         $("main").attr("class","page-content content-wrap full-height");
 	            
 	            });
        </script>
</html>