package example_09_24_abstract;
/*
 * 추상클래스
 * 		추상클래스는 구현부가 없는 메소드를 가질 수 있는 클래스다.
 * 		추상클래스는 구현부가 있는 메소드를 가질 수 있다.
 * 		멤버변수, 생성자, 멤버메소드, 정적변수, 정적메소드 전부 가질 수 있다.
 * 		구현부가 없는 메소드를 가질 수 있기 때문에 new 키워드로 객체 생성할 수 없다.
 * 
 */
/**
 * Phone 인터페이스를 구체화 하여 만든 추상 클래스
 * @author 오송희
 *
 */
public abstract class AbstractPhone implements Phone{
	
	private String tel;
	
	/*
	 * - 추상클래스는 new 키워드를 이용해서 직접 객체 생성은 할 수 없지만,
	 *   멤버변수를 가지고 있고, 그 멤버변수를 초기화하기 위한 생성자 메소드를 포함할 수 있다.
	 * - 추상클래스의 생성자 메소드는 이 클래스를 상속받은 구현클래스의 객체가 생성될 때 구현클래스의 생성자메소드에서
	 *   super() 메소드도 실행된다.
	 */
	public AbstractPhone() {}		
	public AbstractPhone(String tel) {		// 전화번호를 초기화하는 생성자
		this.tel = tel;
	}
	
	public String getTel() {	// tel을 반환하는 getter메소드
		return tel;
	}
	
	public void setTel(String tel) {	// tel을 설정하는 setter메소드
		this.tel = tel;
	}
	
	// Phone 인터페이스에 정의된 추상메소드 재정의
	@Override
	public void call(String tel) {		// 전화번호를 받아 전화를 거는 메소드
		System.out.println("[" + tel + "]로 전화를 겁니다.");		
	}
	
	// Phone 인터페이스에 정의된 추상메소드 재정의
	@Override
	public void sms(String tel, String message) {	// 전화번호와 메세지를 받아 문자를 출력하는 메소드
		System.out.println("[" + tel + "]로 [" + message + "]를 보냅니다." );
	}
	
	// Phone 인터페이스에 정의된 추상메소드 재정의
	@Override
	public void off() {		// 핸드폰 화면을 끄는 메소드
		System.out.println("화면을 끕니다.");
	}
}
