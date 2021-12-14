package example_09_24_abstract;
/**
 * 스마트폰에 대한 기본적인 기능을 정의한 인터페이스
 * @author 오송희
 *
 */
public interface SmartPhone {
	
	void sendEmail(String from, String to, String title, String content); // 이메일을 보내는 메소드
	void internet(String url);	// 인터넷을 실행시키는 메소드
	void game();	// 게임을 실행시키는 메소드
	
	
	
	
}
