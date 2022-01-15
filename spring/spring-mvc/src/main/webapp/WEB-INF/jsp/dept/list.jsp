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
			<h1 class="fs-4">부서 목록 <a class="btn btn-outline-primary btn-sm float-end" href="insert.do">새 부서등록</a></h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<colgroup>
					<col width="10%"/>
					<col width="20%"/>
					<col width="15%"/>
					<col width="15%"/>
					<col width="*"/>
					<col width="6%"/>
				</colgroup>
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>관리자명</th>
						<th>부서 소재지</th>
						<th>소재지 주소</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty departments }">
						<tr>
							<td colspan="6">부서 정보가 존재하지 않습니다.</td>	
						</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="department" items="${departments }">
							<tr>
								<td>${department.id }</td>
								<td>${department.name }</td>
								<td>${department.managerName }</td>
								<td>${department.city }</td>
								<td>${department.streetAddress }</td>
								<td><a href="modify.do?id=${department.id }" class="btn btn-outline-primary btn-sm">수정</a></td>
							</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>