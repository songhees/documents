/************************************************
 * EmployeeList.js
 * Created at 2023. 1. 10. 오후 2:04:28.
 *
 * @author songhee
 ************************************************/

/*
 * "조회" 버튼(btnSearch)에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onBtnSearchClick(e) {
	var btnSearch = e.control;
	
	app.lookup("subList").send();
}

/*
 * "추가" 버튼(btnInsert)에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onBtnInsertClick(e) {
	var btnInsert = e.control;
	
	var grid = app.lookup("grd1");
	var rowIndex = grid.getSelectedRowIndex();
	grid.insertRow(rowIndex, true);
}

/*
 * "삭제" 버튼(btnDelete)에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onBtnDeleteClick(e) {
	var btnDelete = e.control;
	
	var grid = app.lookup("grd1");
	
	var rowIndices = grid.getCheckRowIndices();
	
	grid.deleteRow(rowIndices);
}

/*
 * "저장" 버튼(btnSave)에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onBtnSaveClick(e) {
	var btnSave = e.control;
	
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onSubListSubmitSuccess(e) {
	var subList = e.control;
	var grid = app.lookup("grd1").redraw();
	
}

/*
 * 루트 컨테이너에서 init 이벤트 발생 시 호출.
 * 앱이 최초 구성될 때 발생하는 이벤트 입니다.
 */
function onBodyInit(e) {
	app.lookup("subInit").send();
}

/*
 * 인풋 박스에서 keydown 이벤트 발생 시 호출.
 * 사용자가 키를 누를 때 발생하는 이벤트. 키코드 관련 상수는 {@link cpr.events.KeyCode}에서 참조할 수 있습니다.
 */
function onIpb1Keydown(e) {
	var ipb1 = e.control;
	
	if (e.keyCode == cpr.events.KeyCode.ENTER) {
		app.lookup("btnSearch").click();
	}
}