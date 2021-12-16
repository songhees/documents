<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title></title>
</head>
<body>
<fmt:bundle basename="messages">
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1></h1>
			<p><fmt:message key="label.message" /></p>
			<!-- 바로옆에 닫는 태그가 있는 경우 <    /> 를 안에 붙여도 된다. -->
			<p><c:out value="${content }"/></p>
		</div>
	</div>
</div>
</fmt:bundle>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>