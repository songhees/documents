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
<c:set var="menu" value="직종"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">직종 정보 수정 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">직종정보를 수정하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="modify.do" id="form-update-job">
  				<div class="col-md-6">
    				<label class="form-label">직종 아이디</label>
    				<input type="text" class="form-control" name="id" value="${job.id }" readonly="readonly">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">직종 제목</label>
    				<input type="text" class="form-control" name="title" value="${job.title }">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">최저 급여</label>
    				<select class="form-select" name="minSalary">
    					<!-- 
    						jobs 테이블의 최저급여를 오름차순으로 중복없이 조회해서 <option />태그를 생성하도록 한다
    						수정할 직종의 최저급여가 선택되어 있어야 한다.
    					 -->
						<c:forEach var="min" items="${mins }">
    						<option value="${min }" ${min == job.minSalary ? 'selected' : '' }> ${min}</option>
						</c:forEach>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">최고 급여</label>
    				<select class="form-select" name="maxSalary">
    					<!-- 
    						jobs 테이블의 최고급여를 오름차순으로 중복없이 조회해서 <option />태그를 생성하도록 한다.
    						수정할 직종의 최고급여가 선택되어 있어야 한다.
    					 -->
						<c:forEach var="max" items="${maxs }">
    						<option value="${max }" ${max == job.maxSalary ? 'selected' : '' }> ${max }</option>
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
<script type="text/javascript">
	$("#form-update-job").submit(function() {
		var min = parseInt($("[name=minSalary]").val())
		var max = parseInt($("[name=maxSalary]").val())
		var title = $(":input[name=title]").val()
		
		if (title == "") {
			alert("제목을 입력해 주세요.")
			return false
		}
		if (min == "" || max == "") {
			alert("급여를 입력해 주세요.")
			return false
		}
		if (min >= max) {
			alert("올바른 급여값을 입력해 주세요.")
			return false
		}
		return true
})
</script>
</html>