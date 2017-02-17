<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="page-inner">
<style>
tbody tr:nth-child(odd) { background-color: #f9f9f9; }
</style>
<form>
</form>
<!-- 	<div class="page-title">
		<h3>Datatables</h3>
		<div class="page-breadcrumb">
			<ol class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="#">Tables</a></li>
				<li class="active">Kmeans-Rule</li>
			</ol>
		</div>
	</div> -->
	<div id="main-wrapper">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-white">
					<div class="panel-body">
						<div class="table-responsive">
							<table id="example" class="display table"
								style="width: 100%; cellspacing: 0;">
								<thead>
									<tr>
										<th>번호</th>
										<th>연령</th>
										<th>성별</th>
										<th>감정</th>
										<th>지역</th>
										<th>광고</th>
										<th>갱신일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="list">
										<tr data-bno='${list.kno}'>
											<td>${list.bno }</td>
											<td>${list.age }</td>
											<td>${list.gender }</td>
											<td>${list.emotion }</td>
											<td>${list.area }</td>
											<td>${list.ad }</td>
											<td>${list.kdate }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Row -->
	</div>
	<!-- Main Wrapper -->
	<%@include file="footer.jsp"%>

	<script>

	</script>