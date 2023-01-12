/************************************************
 * common.module.js
 * Created at 2023. 1. 9. 오후 2:50:49.
 *
 * @author songhee
 ************************************************/


// 글로벌 출판 방식
// 스크립트 작성시 모듈을 선언하지 않고 바로 사용가능 
globals.alertTest1 = function() {
	alert("test1");
}

// 모듈 출판 방식 
function alertTest2() {
	alert("test2");
}

exports.alertTest2 = alertTest2;


// 오브젝트 출판 방식 
var tmt = function(){};
tmt.prototype.alertTst3 = function() {
	alert("test3");
}
globals.alertTest3 = function() {
	return new tmt();
}


// 비표준 출판 방식 
tomatosystem = {
	alertTest4 : function() {
		alert("test4");
	}
}

