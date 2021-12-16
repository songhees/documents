<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- uri에 해당하는 라이브러리를 c라는 이름으로 줄여서 사용한다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title></title>
</head>
<body>
<div class="container">    
	<div class="row">
		<div class="col">
			<h1>홈</h1>
			<p>${message }</p>	<!-- EL 표현식 : 값을 표현만 할 수 있다. -->
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>최신 게시글</h3>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
			<!-- for문을 대신하는 것 -->
			<c:forEach var="x" items="${boardList }">
				<tr>
					<td>${x.no }</td>
					<td>${x.title }</td>
					<td>${x.writer }</td>
					<td>${x.createdDate }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>