/************************************************
 * grid.js
 * Created at 2023. 1. 9. 오전 10:45:30.
 *
 * @author songhee
 ************************************************/

/*
 * "신규" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	// 그리드 객체 
	var grid = app.lookup("grd1");
	// 그리드에 행 추가 
	grid.insertRow(0, false);
}

/*
 * "삭제" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick2(e){
	var button = e.control;
	// 그리드 객체 
	var grid = app.lookup("grd1");
	// 선택한 행 index 
	var index = grid.getSelectedRowIndex()
	// 행 안보이게 삭제 
	grid.showDeletedRow = false;
	grid.deleteRow(index);
}

/*
 * "저장" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick3(e){
	var button = e.control;
	alert("저장하시겠습니까?");
	
}

/*
 * 사용자 정의 컨트롤에서 save 이벤트 발생 시 호출.
 */
function onUDCcudBtnSave(e){
	var uDCcudBtn = e.control;
	
	alert("저장하시겠습니까?");
}
