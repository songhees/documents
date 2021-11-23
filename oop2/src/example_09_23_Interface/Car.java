package example_09_23_Interface;
/**
 * 모든 자동차 객체가 반드시 포함할 기능을 정의하는 인터페이스. <br/>
 * 모든 자동차는 출발, 정지, 속도변경, 속도조회 기능이 있어야 한다.
 * @author 오송희
 *
 */
public interface Car {
	
	//  상수 정의하기
	/*
	 *  상수는 변하지 않는 값의 저장소다.
	 *  상수는 public static final 키워드를 포함한다.
	 *	상수의 이름은 전부 대문자로 쓰고, 두 단어이상일 때는 _를 삽입한다.
	 *	인터페이스에서는 public static final를 생략할 수 있다.  
	 */
	/*public static final*/ int MIN_SPEED = 0;		//생략 가능
	public static final int MAX_SPEED = 200;
	
	// 이 인터페이스를 구현하는 구현클래스가 반드시 재정의할 기능을 추상메소드로 정의한다.
	
	// 구현부가 없는 추상메소드 정의하기
	/*
	 * 추상메소드는 구현부가 없는 메소드다
	 * 추상메소드는 abstract키워드를 포함해야 한다.
	 * 인터페이스에서는 public abstract를 생략할 수 있다.
	 */
	public abstract void start();		//추상 메소드
	public abstract void stop();		
	/*public abstract*/ void speedUp();	//인터페이스는 모두 추상메소드이기 때문에 생략가능
	/*public abstract*/ void speedDown();
	/*public abstract*/ int getCurrentSpeed();
	
	
	
}
