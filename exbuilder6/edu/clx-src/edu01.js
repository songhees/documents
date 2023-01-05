/************************************************
 * edu01.js
 * Created at 2023. 1. 3. 오후 1:11:59.
 *
 * @author songhee
 ************************************************/


function test() {
	
}

/*
 * "aaa
 * 버튼이다" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	// 서브 미션 객체 찾기
	var sms = app.lookup("sms1");
	// 서브 미션 전송
	sms.send();
}

/*
 * 그리드에서 selection-change 이벤트 발생 시 호출.
 * detail의 cell 클릭하여 설정된 selectionunit에 해당되는 단위가 선택될 때 발생하는 이벤트.
 */
function onGrd1SelectionChange(e){
	var grd1 = e.control;
	
}
