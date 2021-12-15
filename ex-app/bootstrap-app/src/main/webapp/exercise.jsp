<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title></title>
</head>
<body>
<div class="container-fluid mt-3">
  <h1>Responsive Columns</h1>
  <p>Resize the browser window to see the effect.</p>
  <p>The columns will automatically stack on top of each other when the screen is less than 576px wide.</p>
  <div class="row">
    <div class="col-lg-3">.col</div> <!-- col뒤에 붙이는 화면 크기에 따라 sm - md - lg -등의 순으로 큰 화면일때 열이 자동으로 겹친다.-->
    <div class="col-lg-3">.col</div>
    <div class="col-lg-3">.col</div>
    <div class="col-lg-3">.col</div>
  </div>
  <p>
	Text in a pre element
	is displayed in a fixed-width
	font, and it preserves
	both      spaces and
	line breaks.
</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>