<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="page-inner">
	<style>
tbody tr:nth-child(odd) {
	background-color: #f9f9f9;
}

a {
	color: #4E5E6A;
}

#bno {
	text-decoration: none;
	border-bottom: none;
}

.check {
	width: 30px
}

.deleteBtn{
align: right;
}
</style>
	
	<form role="form" method="post">
		<input type="text" name='bnoChecks' id='bnos'>
		<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token }" id="CSRFtoken" />
	</form>
	<div class="page-title">
		<h3>Datatables</h3>
		<div class="page-breadcrumb">
			<ol class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="#">Tables</a></li>
				<li class="active">Base Rule</li>
			</ol>
		</div>
	</div>
	<div id="main-wrapper">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-white">
					<div class="panel-body">
						<button type="button" class="btn btn-success m-b-sm"
							data-toggle="modal" data-target="#myModal">Add New Row</button>
						<button type="button" class="btn btn-success m-b-sm deleteBtn pull-right"
							>Delete</button>
						<!-- Modal -->
						<form id="add-row-form" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token }" />
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Modal title</h4>
										</div>
										<div class="modal-body">
											<div class="form-group">
												<input type="text" id="age-input" name='age'
													class="form-control" placeholder="Age" required>
											</div>
											<div class="form-group">
												<input type="text" id="gender-input" name='gender'
													class="form-control" placeholder="Gender" required>
											</div>
											<div class="form-group">
												<input type="text" id="emotion-input" name='emotion'
													class="form-control" placeholder="Emotion" required>
											</div>
											<div class="form-group">
												<input type="text" id="area-input" name='area'
													class="form-control " placeholder="Area" required>
											</div>
											<div class="form-group">
												<input type="text" id="ad-input" name='ad'
													class="form-control" placeholder="Ad" required>
											</div>
											<div class="form-group">
												<input type="hidden" id="bdate-input"
													class="form-control" name='bdate'
													placeholder="Date" required>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Cancel</button>
											<button type=button id="add-row" class="btn btn-success addBtn">Add</button>
										</div>
									</div>
								</div>
							</div>
						</form>
						<div class="table-responsive">
							<table id="example-editable" class="display table"
								style="width: 100%; cellspacing: 0;">
								<thead>
									<tr>
										<th class='check'></th>
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
										<tr>
											<td><input type="checkbox" id="bno" class="check-bno"
												value='${list.bno}'></td>
											<td><a href="#" class='bno' onclick="return false;">${list.bno}</a></td>

											<td><a href="#" class='age' data-pk='${list.bno}'
												data-gender='${list.gender}' data-emotion='${list.emotion}'
												data-area='${list.area}' data-ad='${list.ad }'>${list.age}</a></td>

											<td><a href="#" class='gender' data-pk='${list.bno}'
												data-age='${list.age}' data-emotion='${list.emotion}'
												data-area='${list.area}' data-ad='${list.ad}'>${list.gender}</a></td>

											<td><a href="#" class='emotion' data-pk='${list.bno}'
												data-age='${list.age}' data-gender='${list.gender}'
												data-area='${list.area}' data-ad='${list.ad}'>${list.emotion }</a></td>

											<td><a href="#" class='area' data-pk='${list.bno}'
												data-age='${list.age}' data-gender='${list.gender}'
												data-emotion='${list.emotion}' data-ad='${list.ad}'>${list.area }</a></td>

											<td><a href="#" class='ad' data-pk='${list.bno}'
												data-age='${list.age}' data-gender='${list.gender}'
												data-emotion='${list.emotion}' data-area='${list.area}'>${list.ad }</a></td>


											<td><a href="#" class='bdate' onclick="return false;">${list.bdate }</a></td>
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
	<%@include file="../footer.jsp"%>
	<script>
		var NT_date = new Date();
		var nt_year = NT_date.getYear() + 1900;
		var nt_month = NT_date.getMonth() + 1;
		var nt_day = NT_date.getDate();
		var nt_hour = NT_date.getHours();
		var nt_min = NT_date.getMinutes();
		var nt_date = nt_year + "-" + nt_month + "-" + nt_day + " " + nt_hour
				+ ":" + nt_min;

		var date = new Date(nt_date);

		
		
		
		
		
		console.log($('#CSRFtoken').val());
		$.fn.editable.defaults.mode = 'inline';

		$('#bno').editable({
			url : '/modifyBase',
			name : 'bno',
			disabled : true
		});

		$('.age').editable(
				{
					type : 'text',
					url : '/modifyBase',
					name : 'age',
					params : function(params) {
						var p = $(this);
						var data = {};
						data['bno'] = params.pk;
						data[params.name] = params.value;
						data['gender'] = p.context.dataset.gender;
						data['emotion'] = p.context.dataset.emotion;
						data['area'] = p.context.dataset.area;
						data['ad'] = p.context.dataset.ad;
						data['bdate'] = date;
						data['${_csrf.parameterName}'] = $(
								'[name="${_csrf.parameterName}"]').val();
						console.log(data);
						return data;
					},
					success : function(response, newValue) {
					}

				});

		$('.gender').editable(
				{
					type : 'text',
					url : '/modifyBase',
					name : 'gender',
					params : function(params) {
						var p = $(this);
						var data = {};
						data['bno'] = params.pk;
						data['age'] = p.context.dataset.age;
						data[params.name] = params.value;
						data['emotion'] = p.context.dataset.emotion;
						data['area'] = p.context.dataset.area;
						data['ad'] = p.context.dataset.ad;
						data['bdate'] = date;
						data['${_csrf.parameterName}'] = $(
								'[name="${_csrf.parameterName}"]').val();
						console.log(data);
						return data;
					},
					success : function(response, newValue) {
					}

				});

		$('.emotion').editable(
				{
					type : 'text',
					url : '/modifyBase',
					name : 'emotion',
					params : function(params) {
						var p = $(this);
						var data = {};
						data['bno'] = params.pk;
						data['age'] = p.context.dataset.age;
						data['gender'] = p.context.dataset.gender;
						data[params.name] = params.value;
						data['area'] = p.context.dataset.area;
						data['ad'] = p.context.dataset.ad;
						data['bdate'] = date;
						data['${_csrf.parameterName}'] = $(
								'[name="${_csrf.parameterName}"]').val();
						console.log(data);
						return data;
					},
					success : function(response, newValue) {
					}

				});

		$('.area').editable(
				{
					type : 'text',
					url : '/modifyBase',
					name : 'area',
					params : function(params) {
						var p = $(this);
						var data = {};
						data['bno'] = params.pk;
						data['age'] = p.context.dataset.age;
						data['gender'] = p.context.dataset.gender;
						data['emotion'] = p.context.dataset.emotion;
						data[params.name] = params.value;
						data['ad'] = p.context.dataset.ad;
						data['bdate'] = date;
						data['${_csrf.parameterName}'] = $(
								'[name="${_csrf.parameterName}"]').val();
						console.log(data);
						return data;
					},
					success : function(response, newValue) {
						// 						alert("수정되었습니다.");
					}

				});

		$('.ad').editable(
				{
					type : 'text',
					url : '/modifyBase',
					name : 'ad',
					params : function(params) {
						var p = $(this);
						var data = {};
						data['bno'] = params.pk;
						data['age'] = p.context.dataset.age;
						data['gender'] = p.context.dataset.gender;
						data['emotion'] = p.context.dataset.emotion;
						data['area'] = p.context.dataset.area;
						data[params.name] = params.value;
						data['bdate'] = date;
						data['${_csrf.parameterName}'] = $(
								'[name="${_csrf.parameterName}"]').val();
						console.log(data);
						return data;
					},
					success : function(response, newValue) {
					}
				});
		
// 		$('.date-picker').datepicker({
// 			orientation : "top auto",
// 			autoclose : true
// 		});
		
		
		//삭제 기능
		var removeForm = $("form[role='form']");
		var bnos = $("#bnos");
		
		$('.deleteBtn').click(function(event) {
			var param = "";
			
			$("tbody :checked").each(function () {
// 				console.log($(this).parent().parent().parent().parent().children("#bno").context.value);
				if(param==""){
					param = $(this).parent().parent().parent().parent().children("#bno").context.value;}
				else{
					param = param + ","+$(this).parent().parent().parent().parent().children("#bno").context.value;
				}
			});
			bnos.attr("value",param);
			removeForm.attr("action","/removeBase");
			removeForm.submit();
		});
		
		var addForm = $("form[id='add-row-form']");
		var bdateInput = $('#bdate-input');
		
		$('.addBtn').click(function (event) {
			console.log(event);
			bdateInput.attr("value",date);
			addForm.attr("action","/registerBase");
			addForm.submit();
		});
		
		var result = '${msg}';
		if(result=="success"){
			alert("처리가 완료되었습니다.");
		}
		
	</script>