/************************************************
 * Dialog.js
 * Created at 2023. 1. 9. 오후 5:32:38.
 *
 * @author songhee
 ************************************************/

/*
 * "다이얼로그" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	
	var initValue = {
		"msg" : "exBuilder6"
	}	
	
	app.openDialog("Embedded/DialogPopup", {width: 400, height: 300}, function(dialog) {
		dialog.ready(function(dialogApp) {
			dialogApp.initValue = initValue;
			
		});
	}).then(function(returnValue) {
		alert(JSON.stringify(returnValue));
	})
}
