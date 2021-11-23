package example_09_16_polymorphism;

public class EventServiceApp {
	public static void main(String[] args) {
		// 최신 이벤트 등록, 이벤트 알림, 이벤트 당첨자 선정 기능이 구현된 EventService객체를 생성한다.
		EventService service = new EventService();
		
		// 최신 이벤트 소식을 고객에게 알린다.
		service.noticeEvent("hong@gmail.com", "kim@gmail.com", "추석 선물세트가 새로 나왔습니다.");
		
	}
}
