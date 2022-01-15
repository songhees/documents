<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title></title>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<c:set var="menu" value="직원"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">직원 상세정보</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<colgroup>
					<col width="15%"/>
					<col width="35%"/>
					<col width="15%"/>
					<col width="35%"/>
				</colgroup>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>${employee.id }</td>
						<th>이름</th>
						<td>${employee.firstName } ${employee.lastName }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${employee.phoneNumber }</td>
						<th>이메일</th>
						<td>${employee.email }</td>
					</tr>
					<tr>
						<th>입사일</th>
						<td><fmt:formatDate value="${employee.hireDate }" pattern="yyyy년 M월 d일"/></td>
						<th>직종 아이디</th>
						<td>${employee.jobId } (${employee.jobTitle })</td>
					</tr>
					<tr>
						<th>급여</th>
						<td><fmt:formatNumber value="${employee.salary }" pattern="##,###"/> 달러</td>
						<th>커미션</th>
						<td>${employee.commissionPct }</td>
					</tr>
					<tr>
						<th>담당 관리자</th>
						<td>${employee.managerName } (${employee.managerId })</td>
						<th>소속부서명</th>
						<td>${employee.departmentName } (${employee.departmentId })</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col text-end">
			<a href="list.do" class="btn btn-primary">목록</a>
		</div>
	</div>
</div>
</body>
</html>