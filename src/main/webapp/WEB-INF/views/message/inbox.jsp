<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row m-t-md">
                        <div class="col-md-12">
                            <div class="row mailbox-header">
                                <div class="col-md-2">
                                    <a href="compose.html" class="btn btn-success btn-block">Compose</a>
                                </div>
                                <div class="col-md-6">
                                    <h2>메 일 함</h2>
                                </div>
                                <div class="col-md-4">
                                    <form action="#" method="GET">
                                        <div class="input-group">
                                            <input type="text" name="search" class="form-control input-search" placeholder="Search...">
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
                                <li><a href="#"><i class="fa fa-sign-out"></i>Sent</a></li>
                                <!-- <li><a href="#"><i class="fa fa-file-text-o"></i>Draft</a></li>
                                <li><a href="#"><i class="fa fa-exclamation-circle"></i>Spam</a></li> -->
                                <li><a href="#"><i class="fa fa-trash"></i>Trash</a></li>
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
                                            <a class="btn btn-default m-r-sm" data-toggle="tooltip" data-placement="top" title="Refresh"><i class="fa fa-refresh"></i></a>
                                            <div class="btn-group m-r-sm mail-hidden-options">
                                                <a class="btn btn-default" data-toggle="tooltip" data-placement="top" title="Delete"><i class="fa fa-trash"></i></a>
                                                <a class="btn btn-default" data-toggle="tooltip" data-placement="top" title="Report Spam"><i class="fa fa-exclamation-circle"></i></a>
                                                <a class="btn btn-default" data-toggle="tooltip" data-placement="top" title="Mark as Important"><i class="fa fa-star"></i></a>
                                                <a class="btn btn-default" data-toggle="tooltip" data-placement="top" title="Mark as Read"><i class="fa fa-pencil"></i></a>
                                            </div>
                                            <div class="btn-group m-r-sm mail-hidden-options">
                                                <div class="btn-group">
                                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-folder"></i> <span class="caret"></span></a>
                                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                                        <li><a href="#">Social</a></li>
                                                        <li><a href="#">Forums</a></li>
                                                        <li><a href="#">Updates</a></li>
                                                        <li class="divider"></li>
                                                        <li><a href="#">Spam</a></li>
                                                        <li><a href="#">Trash</a></li>
                                                        <li class="divider"></li>
                                                        <li><a href="#">New</a></li>
                                                    </ul>
                                                </div>
                                                <div class="btn-group">
                                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tags"></i> <span class="caret"></span></a>
                                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                                        <li><a href="#">Work</a></li>
                                                        <li><a href="#">Family</a></li>
                                                        <li><a href="#">Social</a></li>
                                                        <li class="divider"></li>
                                                        <li><a href="#">Primary</a></li>
                                                        <li><a href="#">Promotions</a></li>
                                                        <li><a href="#">Forums</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="btn-group">
                                                <a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
                                                <a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
                                            </div>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody >
                                <c:forEach var="list" items="${list}">
                                					<tr class="${list.checked == 0 ? 'unread' : 'read' }">
                                						 <td class="hidden-xs"><span><input type="checkbox" class="checkbox-mail"></span></td>
                                						 <td>${list.mno}</td>
													 <td class="hidden-xs">'${list.mfrom}'</td>
													 <td>'${list.mtitle}'</td>
													 <td></td>
													 <td>'${list.regdate}'</td>
												</tr> 	
                                </c:forEach>
                                </tbody>
                            </table>
                            </div>
                        </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
     <%@include file="../footer.jsp"%>
     
        <!-- Javascripts -->
        <script type="text/javascript">
$(document).ready(function (){
	
	$("tr").on("click" , function(event){
		console.log(event.currentTarget.children[1].innerText);
		var mno = event.currentTarget.children[1].innerText;
		$("<form action='view'><input type='hidden' name='mno' value='"+mno+"'></form>").appendTo("body").submit();
	});
});

</script>
<script src="../assets/js/pages/inbox.js"></script>

