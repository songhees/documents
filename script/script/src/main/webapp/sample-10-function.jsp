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

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	// 이름있는 함수와 이름 없는 함수
	/*
		이름 있는 함수
			function 함수이름(매개변수) {...}
		이름 없는 함수
			function(매개변수) {...}
			이름이 없으면 함수를 실행하기 못한다.
			
		실행방법은 같다. => 함수이름(매개변수);  () 함수를 실행시키는 기호
		함수이름 -> 함수를 가르키는 것(참조하는 것)
	*/
	// 이름 있는 함수를 정의
	// 이름 있는 함수에서 함수의 이름은 그 함수를 참조하는 값이다.
	 function greeting(name) {
		console.log(name+ "님 반갑습니다.");
	}
	greeting("홍길동");
	
	// 이름 없는 함수를 정의하고, 변수에 대입
	// 이름없는 함수가 저장된 변수도 그 함수를 참조하는 값을 가지고 있다.
	var bye = function(name) {
		console.log(name+ "님 안녕히가세요.");
	}
	bye("김유신");
	
	// 즉시 실행함수
	// 한번만 실행할 목적으로 만든 함수 ->> 웹 페이지가 화면에 로딩되자 마자 실행하는 함수
	// 이름이 없으므로 실행할 수 없고, return값이 없으므로 변수에 할당하여 실행할 수 없다.
	(function () {
		console.log("함수가 실행되었음");
	}) ();
	
	// 즉시 실행함수의 매개변수에 인자 전달하기
	(function(a, b, c) {
		console.log(a, b, c);
	}) (10, 20, 30);
	
</script>
</body>
</html>