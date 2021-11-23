package example_09_24_abstract;
/**
 * 폰 추상클래스를 상속받아 기본 폰의 기능을 상속받고
 * SmartPhone인터페이스를 구체화하여 스마트폰의 기능을 정의한다.
 * @author 오송희
 *
 */
public abstract class AbstractSmartPhone extends AbstractPhone implements SmartPhone{
	
	private String ip;					// 스마트폰마다 존재하는 고유 ip
	public AbstractSmartPhone() {}
	public AbstractSmartPhone(String tel, String ip) {	// 상속받은 클래스의 생성자와 본 클래스의 기본값을 초기화하는 생성자
		super(tel);
		this.ip = ip;
	}
	
	public String getIp() {		// ip를 반환하는 메소드
		return ip;
	}
	
	public void setIp(String ip) {	// ip를 받아 값을 넣는 메소드
		this.ip = ip;
	}
	
	@Override
	public void sendEmail(String from, String to, String title, String content) {
		System.out.println("[" + from + "]이 [" + to + "]에게 [" + title +"][" + content + "]를 메일로 보냅니다.");
	}
	
	@Override
	public void internet(String url) {
		System.out.println("[" + url + "]에 해당하는 웹 페이지를 표시합니다.");
		
	}
}
