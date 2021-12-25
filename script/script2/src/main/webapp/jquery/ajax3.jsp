<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h1>박스오피스 조회하기</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<div class="mb-3 d-flex justify-content-end">
				<form class="row row-cols-lg-auto g-3 align-items-center">
  					<div class="col-12">
    					<label class="form-label">조회날짜</label>
  					</div>
  					<div class="col-12">
    					<input type="date" name="date" class="form-control"/>
  					</div>
  					<div class="col-12">
    					<button type="button" class="btn btn-outline-dark" id="btn-get-boxoffice">조회</button>
  					</div>
				</form>
			</div>
			<table class="table" id="table-boxoffice">
				<thead>
					<tr>
						<th style="width: 5%;" class="text-center">순위</th>
						<th style="width: 45%;">제목</th>
						<th style="width: 10%;">개봉일</th>
						<th style="width: 15%;" class="text-end pe-3">관객수</th>
						<th style="width: 15%;" class="text-end pe-3">누적관객수</th>
						<th style="width: 10%;" class="text-end pe-3">점유율</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	// 조회버튼 클릭할 때 실행되는 이벤트핸들러 메소드 등록
	$("#btn-get-boxoffice").click(function() {
		// 테이블의 tbody를 선택하고, 안을 비운다. 반환되는 집합객체를 $tbody에 저장한다.
		var $tbody = $("#table-boxoffice tbody").empty()
		// 날짜입력칸에서 날짜정보를 조회한다.
		// 날짜정보에 포함된 -를 없앤다.
		var date = $("input[name=date]").val().replace(/-/g, "")
		
		if (date == "") {
			alert("조회날짜를 입력하세요")
		}
		
		// $.ajax()를 이용해서 요청URL로 요청을 보낸다.
		// 응답데이터를 받아서 tbody에 표현한다.
		$.ajax({
			type: 'get',
			url: 'http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
			data: {key: "f5eef3421c602c6cb7ea224104795888", targetDt: date },
			dataType: 'json',
			success: function(result){
				// 여기에서 colsole.log()가 안나오면 ajax 에서 문자가 오류난것...
				var boxOfficeList = result.boxOfficeResult.dailyBoxOfficeList
				$.each(boxOfficeList, function(index, boxoffice){
					var row = "<tr>"
						row += "<td>" + boxoffice.rank + "</td>"
						row += "<td>" + boxoffice.movieNm + "</td>"
						row += "<td>" + boxoffice.openDt + "</td>"
						row += "<td class='text-end pe-3'>" + parseInt(boxoffice.audiCnt).toLocaleString() + " 명</td>"
						row += "<td class='text-end pe-3'>" + parseInt(boxoffice.audiAcc).toLocaleString() + " 명</td>"
						row += "<td class='text-end pe-3'>" + boxoffice.salesShare + "%</td>"
						row += "</tr>"
					$tbody.append(row)
				})
			}
		})
	})
</script>
</body>
</html>