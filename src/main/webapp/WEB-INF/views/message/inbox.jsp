<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
            <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row m-t-md">
                        <div class="col-md-12">
                            <div class="row mailbox-header">
                                <div class="col-md-2">
<%--                                     <a href="/message/send?mfrom=<sec:authentication property="principal.username"/>" class="btn btn-success btn-block">Compose</a> --%>
                                    <a href="/message/send"  class="btn btn-success btn-block">Compose</a>
                                </div>
                                <div class="col-md-6">
                                    <h2>메 일 함</h2>
                                </div>
                                <div class="col-md-4">
                                    <form action="inbox" method="GET"  id="search">
                                        <div class="input-group">
                                            <input type="text"  name="keyword" class="form-control input-search"  placeholder="Search..."  id = "search">
                                            <span class="input-group-btn">
                                                <button class="btn btn-success" type="button"><i class="fa fa-search"></i></button>
                                            </span>
                                        </div><!-- Input Group -->
                                    </form>
                               </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <ul class="list-unstyled mailbox-nav">
                                <li class="active"><a href="inbox.html"><i class="fa fa-inbox"></i>메일함 <span class="badge badge-success pull-right">4</span></a></li>
<!--                                 <li><a href="#"><i class="fa fa-sign-out"></i>Sent</a></li> -->

                            </ul>
                        </div>
                        <div class="col-md-10">
                            <div class="mailbox-content">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th colspan="1" class="hidden-xs">
                                            <span><input type="checkbox" class="check-mail-all"></span>
                                        </th>
                                        <th class="text-right" colspan="5">
                                            <span class="text-muted m-r-sm">Showing 20 of 346 </span>
                                            <a class="btn btn-default m-r-sm" data-toggle="tooltip" data-placement="top" title="Refresh" id="refresh"><i class="fa fa-refresh"></i></a>
                                            
                                            <div class="btn-group m-r-sm mail-hidden-options">
                                                <a class="btn btn-default" data-toggle="tooltip" data-placement="top" title="Delete" id ="delete"><i class="fa fa-trash"></i></a>
                                            </div>
                                            <div class="btn-group m-r-sm mail" id = "fa-pendil">
                                                <a class="btn btn-default" data-toggle="tooltip" data-placement="top" title="Send Message" >
                                                <i class="fa fa-pencil"></i>
                                                </a>
                                            </div>
                                            
                                            <div class="btn-group">
                                                <div class="btn btn-default"  id = "left"><i class="fa fa-angle-left"></i></div>
                                                <div class="btn btn-default"  id = "right"><i class="fa fa-angle-right"></i></div>
                                            </div>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody id="pagelist">
                                <c:forEach var="list" items="${list}" >
                                					<tr class=" ${list.checked == 0 ? 'unread' : 'read' }"  id = "trcheck">
                                						 <td class="hidden-xs"  id = "tdcheck"><span><input type="checkbox" class="checkbox-mail"></span></td>
                                						 <td id = "listmno">${list.mno}</td>
																						 <td class="hidden-xs">${list.mfrom}</td>
																						 <td>${list.mtitle}</td>
																						 <td></td>
																						 <td>${list.regdate}</td>
																					</tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            </div>
                        </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
   

     <%@include file="footer.jsp"%>
     
        <!-- Javascripts -->
 <script>
$(document).ready(function (){
	
	$("#messageActive").attr("class","active");
	
	var page = 0;
	
	$("#left").on("click", function(event){
// 		event.preventDefault();
			console.log(event);
				page--;
				if(page < 0){
					page = 0;
					console.log("page 값 : " + page);
					return;
				}
				console.log("page 값 : " + page);
// 				var num = page ;
				ajaxPage();
	});
	
	$("#right").on("click", function(event){
// 		event.preventDefault();
		console.log(event);
		page++;
		if(page>=${total}){
				page=${total}-1;
				console.log("page 값 : " + page);
				return;
		}
		console.log("page 값 : " + page);
// 		var num = page;
		ajaxPage();
	});

	
	$("#refresh").on('click', function(e){
		console.log(e);
		ajaxPage();
});
	
	$("#fa-pendil").on("click", function(event){
			console.log(event);
// 			$("<form action='send'><input type='hidden' name='mfrom' value='"+mno+"'></form>").appendTo("body").submit();
			$("<form action='send'><input type='hidden' name='mfrom' value='admin'></form>").appendTo("body").submit();
				// 임시로 value 값을 지정해놨다 나중에 로그인 처리되면은 value 안에 로그인된 아이디를 넣어줘야한다. 
	});
	
	
			function ajaxPage(){
				console.log("ajax 들어옴........")
				$.ajax({
					type : "get",
					url : "/message/paging",
					data :  {"page" : page},
					dataType : "json",
					success : function(result){
						var page = "";
						console.log(result);
						console.log(result[0].mno);
						for(var i = 0; i < result.length; i++){
							page += '<tr id="please" class='+ (result[i].checked == 0 ? 'unread' : 'read') +'>'
									 + '<td class="hidden-xs" id = "tdcheck"><span><input type="checkbox" class="checkbox-mail"></span></td>'
									 + '<td>'+ result[i].mno +'</td>'
									 + '<td class="hidden-xs">' + result[i].mfrom+ '</td>' 
									 + '<td>' + result[i].mtitle + '</td>'
									 + '<td></td>'
									 + '<td>'+result[i].regdate+'</td>'
									 +'</tr>';					 
						}
						console.log("success");
						$("#pagelist").html(page);
					}
				});
				console.log($(".check-mail-all"));	
				if($(".check-mail-all")[0].checked==true){
					$(".check-mail-all")[0].checked=false;
					$(".check-mail-all")[0].parentNode.className = "";
				}			
				
				
			}
//			$("tbody > tr").on("click" , function(event){
//			console.log("childeren.inndrText : " + event.currentTarget.children[1].innerText);
//			console.log("innerText : " +event.currentTarget.innerText);
//			var mno = event.currentTarget.children[1].innerText;
//			$("<form action='view'><input type='hidden' name='mno' value='"+mno+"'></form>").appendTo("body").submit();
//		});
	
// checkbox 체크 되어있는것들을 받아 둔다음에 쓰레기 버튼을 누르면 trash 페이지로 뿌려져야 한다. or 아니면 바로 지워버린다.  
	
	
	
	
	$("#delete").on('click', function(e){
    	console.log(e);
    	console.log($(".mailbox-content table tr td span input"));
//     	console.log($(".mailbox-content table tr"));
    	console.log($(".checker"));
    	var arr = new Array();
    	// 길이 - 1  시작은 1 부터 
    	for(var i = 0 ; i < $(".mailbox-content table tr").length - 1;  i++){
    		if($(".mailbox-content table tr td span input")[i].checked == true){
    				console.log('true');
//    				console.log($(".mailbox-content table tr")[i+1].childNodes[3].innerText);	// mno  값 가져오기 
    				arr.push($(".mailbox-content table tr")[i+1].childNodes[3].innerText);
    		}
    	}
    	console.log(arr);
		$("<form action='delete' method='post'><input type='hidden' name='mno' value=" +arr+ "></form>").appendTo("body").submit();
    });



//    $('.checkbox-mail').on('click', function(e){
// 		   	var bool = $(e.currentTarget.attributes[0]).context.value;
// 		   	var arr = [];
// 		   	console.log(e);
// 		   	console.log(e.currentTarget);
// 		    	console.log(bool);
// 		    	   	if(bool == "checked"){
		    	   		
// 		//    		arr.push($('.mailbox-content table tr td')[1].innerText);
// 		//     	   		console.log($('.mailbox-content table tr td')[1].innerText);
// 		    	   		console.log($('.mailbox-content table tr td'));
// 		   		console.log("true");
// 		   	}	
// 		   	else{
// 		   		console.log(arr.indexOf(bool));
// 		   	}
		//    	console.log(arr);
		//    	console.log($(e.currentTarget.attributes[0]).context.value);
		//    	console.log(bool.is("checked"));
		//    	console.log(($(e.currentTarget.attributes[0]).context.value).is("checked"));
//    });
	
	$(".input-group-btn").on('click', function(e){
		console.log(e);
		console.log($('#search').val());
		$("#search").submit();
	});
	
	
	 "${urlname}" == "/admin" ? $("#devicemanagement").show() : $("#devicemanagement").hide();
	
	 console.log("inbox urlname : ${urlname}");
	 
});

</script>
<script src="../assets/js/pages/inbox.js"></script>

