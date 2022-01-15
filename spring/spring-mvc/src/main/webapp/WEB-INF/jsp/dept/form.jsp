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
<c:set var="menu" value="부서"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">부서 정보 등록 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">새로 등록할 부서정보를 입력하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="insert.do" id="form-insert-dep">
  				<div class="col-md-6">
    				<label class="form-label">부서명</label>
    				<input type="text" class="form-control" name="name">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">부서 소재지</label>
    				<select class="form-select" name="locationId">
    					<option value=""> 부서 소재도시를 선택하세요</option>
    					<c:forEach var="location" items="${locations }">
    						<option value="${location.id }"> ${location.city }</option>
    					</c:forEach>
    				</select>
  				</div>
  				<div class="col-12 text-end">
  					<button type="button" class="btn btn-primary" id="btn-click">등록</button>
  				</div>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$("#btn-click").click(function() {
		var name = $("input[name=name]").val()
		if (name == "") {
			alert("부서명을 입력해주세요.")
		} else {
			$("#form-insert-dep").trigger("submit")
		}
	})
</script>
</html>