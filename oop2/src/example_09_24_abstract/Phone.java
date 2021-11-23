package example_09_24_abstract;
/**
 * 폰이 기본적으로 가져야할 기능을 interface로 묶음
 * @author 오송희
 *
 */
public interface Phone {
	
	void on();
	void off();
	void call(String tel);					// 전화번호를 받아 전화하는 추상화메소드
	void sms(String tel, String message);	// 전화번호를 받아 메세지를 출력하는 추상화메소드
	
}
