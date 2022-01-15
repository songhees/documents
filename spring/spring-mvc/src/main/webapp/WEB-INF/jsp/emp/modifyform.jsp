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
			<h1 class="fs-4">직원 정보 수정 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">수정할 직원 정보를 입력하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="modify.do?id=${employee.id }">
  				<div class="col-md-6">
    				<label class="form-label">이름</label>
    				<input type="text" class="form-control" name="firstName" value="${employee.firstName }" readonly>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">이름</label>
    				<input type="text" class="form-control" name="lastName" value="${employee.lastName }" readonly>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">직종</label>
    				<select class="form-select" name="jobId">
    					<!-- 
    						jobs 테이블의 모든 직종정보를 조회해서 <option />태그를 생성한다.
    						수정할 직원의 기존 직종이 미리 선택되어 있어야 한다.
    					 -->
    					<option value=""> 직종을 선택하세요</option>
    					<c:forEach var="job" items="${jobs }">
	    					<option value="${job.id }" ${job.id == employee.jobId? "selected" : "" }> ${job.title } (<fmt:formatNumber value="${job.minSalary }" pattern="##,###"/> ~ <fmt:formatNumber value="${job.maxSalary }" pattern="##,###"/> 달러)</option>
    					</c:forEach>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">소속 부서</label>
    				<select class="form-select" name="departmentId">
    					<!-- 
    						departments 테이블의 모든 부서정보를 조회해서 <option />태그를 생성한다.
    						수정할 직원의 기존 소속 부서가 미리 선택되어 있어야 한다.
    					 -->
    					<option value=""> 소속부서를 선택하세요</option>
    					<c:forEach var="department" items="${departments }">
    						<option value="${department.id }" ${department.id == employee.departmentId? "selected" : "" }> ${department.name }</option>
    					</c:forEach>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">급여</label>
    				<input type="number" class="form-control" name="salary" value="${employee.salary }" >
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">커미션</label>
    				<select class="form-select" name="commissionPct">
    					<!-- 
    						수정할 직원의 커미션이미리 선택되어 있어야 한다.
    					 -->
    					<option value=""> 소속부서를 선택하세요</option>
    					<c:forEach var="com" begin="1" end="9">
    						<option value="${0.05 * com }"> ${0.05 * com }</option>
    					</c:forEach>
    				</select>
  				</div>
  				<div class="col-12 text-end">
  					<button type="submit" class="btn btn-primary">수정</button>
  				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>