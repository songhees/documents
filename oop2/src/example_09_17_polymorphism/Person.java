package example_09_17_polymorphism;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {
	
	private static AtomicInteger atomicInteger = new AtomicInteger(1000);	//AtomicInteger 지정된 숫자부터 참조변수가 실행될때 마다 숫가 늘어남
	private int no;		// 사람들 번호
	private String type;// 어떤 직업?
	private String name;// 이름
	private String tel;// 전화번호
	
	public Person() {}	// 기본생성자
	public Person(String type, String name, String tel) {	//객체 생성시 초기화 하는 생성자
		this.no = atomicInteger.getAndIncrement();	// 1000부터 실행시 1씩 증가함
		this.type = type;
		this.name= name;
		this.tel = tel;
	}
	public int getNo() {
		return no;
	}

	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public void print() {
		
		System.out.println("일련번호: " + no);
		System.out.println("구   분: " + type);
		System.out.println("이   름: " + name);
		System.out.println("전화번호: " + tel);
	}
	
}
