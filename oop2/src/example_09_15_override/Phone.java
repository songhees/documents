package example_09_15_override;

public class Phone {
	
	private String tel;		// 번호를 저장하는 변수
	public void setTel(String tel) {
		this.tel = tel;		// 번호를 받아서 저장하는 메소드
	}
	
	public void call(String to) {
		System.out.println("["+ tel +"]이" + to + "에게 전화를 겁니다.");
	}	// 보낼 전화번호를 매개변수로 받아 전화를 출력
	
	public void off() {
		System.out.println("전원버튼을 눌러서 화면을 끕니다.");
	}	// 화면 종료를 출력하는 메소드
	
	public void on() {
		System.out.println("전원버튼을 눌러서 화면을 켭니다.");
	}	// 화면 켜짐을 출력하는 메소드
}
