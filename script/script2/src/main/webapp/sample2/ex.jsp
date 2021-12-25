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
	<div class="row">
		<div class="col">
			<div class="mb-3 p-3" id="date-button-group">
				<button class="btn btn-outline-secondary btn-sm active" onclick="changeFromToEnd(-1, 'w', 'btn-1-week')" id="btn-1-week">1주일</button>
				<button class="btn btn-outline-secondary btn-sm" onclick="changeFromToEnd(-1, 'm', 'btn-1-months')" id="btn-1-months">1달</button>
				<button class="btn btn-outline-secondary btn-sm" onclick="changeFromToEnd(-3, 'w', 'btn-3-months')" id="btn-3-months">3개월</button>
			</div>
			<div class="mb-3">
				<input type="date" id="from-date" name="from"> ~ <input type="date" id="end-date" name="end" readonly>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/moment@2.29.1/moment.min.js"></script>
<script type="text/javascript">
	var from = document.getElementById("from-date")
	var end = document.getElementById("end-date")
	function changeFromToEnd(num, type, id) {
		
		from.value = moment().add(num, type).format("YYYY-MM-DD");
		end.value = moment().format("YYYY-MM-DD");
		
		var removebtn = document.querySelectorAll("#date-button-group button")
		removebtn.forEach(item => item.classList.remove('active'))
		
		document.getElementById(id).classList.add('active')
	}
</script>
</body>
</html>