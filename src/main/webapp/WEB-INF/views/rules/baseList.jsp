<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="page-inner">
	<div class="page-title">
		<h3>Datatables</h3>
		<div class="page-breadcrumb">
			<ol class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="#">Tables</a></li>
				<li class="active">Datatables</li>
			</ol>
		</div>
	</div>
	<div id="main-wrapper">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-white">
					<div class="panel-heading clearfix">
						<h4 class="panel-title">Basic example</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="example" class="display table"
								style="width: 100%; cellspacing: 0;">
								<thead>
									<tr>
										<th>Name</th>
										<th>Position</th>
										<th>Office</th>
										<th>Age</th>
										<th>Start date</th>
										<th>Salary</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Tiger Nixon</td>
										<td>System Architect</td>
										<td>Edinburgh</td>
										<td>61</td>
										<td>2011/04/25</td>
										<td>$320,800</td>
									</tr>

									<tr>
										<td>Brenden Wagner</td>
										<td>Software Engineer</td>
										<td>San Francisco</td>
										<td>28</td>
										<td>2011/06/07</td>
										<td>$206,850</td>
									</tr>
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
	<%@include file="../footer.jsp"%>