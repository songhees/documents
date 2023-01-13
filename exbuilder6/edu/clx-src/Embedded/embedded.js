/************************************************
 * embedded.js
 * Created at 2023. 1. 9. 오후 4:44:12.
 *
 * @author songhee
 ************************************************/

/*
 * 트리에서 item-click 이벤트 발생 시 호출.
 * 아이템 클릭시 발생하는 이벤트.
 */
function onTre1ItemClick(e){
	var tre1 = e.control;
	var vsAppId = e.item.value;
	
	if (vsAppId == "") {
		return;
	};
	
	var vcEmb = app.lookup("ea1");
	
//	var voInitValue = {
//		"value" : e.item.label,
//		"appId" : vsAppId
//	};
	
	cpr.core.App.load(vsAppId, function(loadedApp) {
		// 임베디드앱에 안에 앱이 있는 경우 앱을 삭제해 준다. 
		if(vcEmb.getEmbeddedAppInstance()) {
			vcEmb.getEmbeddedAppInstance().dispose();	
		}
		
		// load된 앱이 있는 경우 
		if (loadedApp) {
			vcEmb.ready(function(embApp) {
//				embApp.initValue = voInitValue;
			})
			vcEmb.app = loadedApp;
		}
	})	
}

