/************************************************
 * UDCcudBtn.js
 * Created at 2023. 1. 9. 오전 11:02:37.
 *
 * @author songhee
 ************************************************/

/**
 * UDC 컨트롤이 그리드의 뷰 모드에서 표시할 텍스트를 반환합니다.
 */
exports.getText = function(){
	// TODO: 그리드의 뷰 모드에서 표시할 텍스트를 반환하는 하는 코드를 작성해야 합니다.
	return "";
};

/*
 * "신규" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick2(e){
	var button = e.control;
	// 그리드 객체 
	 
	// alt + ctrl + /
	/** @type cpr.controls.Grid */
	var grd = app.getAppProperty("grid");
	// 행 추가 
	grd.insertRow(0, false);
}

/*
 * "삭제" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick3(e){
	var button = e.control;
	
	/** @type cpr.controls.Grid */
	var grid = app.getAppProperty("grid");
	
	var rowIndex = grid.getSelectedRowIndex();
	
	grid.deleteRow(rowIndex);
}

/*
 * "저장" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick5(e){
	var button = e.control;
	
	// 이벤트 생성
	var event = new cpr.events.CAppEvent("save");
	// 이벤트 전파
	app.dispatchEvent(event);
}
