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
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1>상품 리스트</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table" id="table-products">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>제조회사</th>
						<th>가격</th>
						<th>할인가격</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	/* 
		자바스크립트에서 서버로 HTTP 통신하기
		$.getJSON(url, 함수)
			url : 클라이언트의 요청을 처리하는 웹애플리케이션의 URL (서버로 요청메세지를 보냄)
			--- 성공적인 응답을 받은 후 --
			함수 : 서버가 클라이언트의 요청을 처리하고, 응답데이터를 내려보내면 실행되는 함수다.
				function(data) { ... }
				+ data에는 서버가 내려보낸 데이터가 전달된다(응답)
				+ jQuery 서버가 json텍스트를 내려보내면(응답) 자바스크립트 객체나 배열로 변환후 data에 전달해준다.
				
	*/
	
	/*
		/script2/product/list.hta에서 보낸 응답 메세지(data)
				
		[{"no": 100, "name": "갤럭시z플립", "company": "삼성전자", "price": 1500000, "discountPrice": 1350000, "isOnSell": true},
		{"no": 200, "name": "ipone 13 Pro", "company": "애플", "price": 1600000, "discountPrice": 1400000, "isOnSell": true},
		{"no": 300, "name": "apple watch", "company": "애플", "price": 600000, "discountPrice": 550000, "isOnSell": false}]
				
				를 받으면 function이 실행됨*/
	$.getJSON("/script2/product/list.hta", function(data) {
		console.log(data)
		var htmlContent = "";
		data.forEach((product) => {
			htmlContent += "<tr>"
			htmlContent += "<td>"+ product.no +"</td>"
			htmlContent += "<td>"+ product.name +"</td>"
			htmlContent += "<td>"+ product.company +"</td>"
			htmlContent += "<td>"+ product.price +"</td>"
			htmlContent += "<td>"+ product.discountPrice +"</td>"
			htmlContent += "</tr>"
			
		})
		document.querySelector("#table-products tbody").innerHTML = htmlContent
	})
</script>
</body>
</html>