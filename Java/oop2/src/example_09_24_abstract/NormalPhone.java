package example_09_24_abstract;
/**
 * 추상 클래스를 상속받아 일반폰의 기능을 정의하는 클래스
 * @author 오송희
 *
 */
public class NormalPhone extends AbstractPhone{
	
	public NormalPhone() {}
	public NormalPhone(String tel) {	// 부모 클래스의 생성자에 tel을 받아 초기화함
		super(tel);
	}
	
	@Override
	public void on() {					// 일반폰의 화면이 켜지는 메소드 재정의
		System.out.println("전원버튼을 누르면 화면이 켜집니다.");
	}
}
