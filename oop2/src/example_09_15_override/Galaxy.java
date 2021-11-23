package example_09_15_override;

public class Galaxy extends Phone {
	
	@Override
	public void on() {
		System.out.println("폴더를 펼쳐서 화면을 켭니다.");
	}	// 폰객체의 메소드를 재정의 하여 화면 켜짐을 출력하는 방법을 다르게 출력

	@Override
	public void off() {
		System.out.println("폴더를 접어서 화면을 끕니다.");
	}	// 폰객체의 메소드를 재정의 하여 화면 종료를 출력하는 방법을 다르게 출력
	
	
	
}
