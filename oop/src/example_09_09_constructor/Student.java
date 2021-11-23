package example_09_09_constructor;

public class Student {
	
	int no;
	String dept;		//멤버변수 설정 멤버변수의 초기값은 자동설정
	int grade;
	String name;
	String email;
	String phone;
	
	/*
	 * 생성자가 하나도 정의되어 있지 않으면 소스(Student.java)를 컴파일해서 실행파일을 만들 때
	 * 실행파일(Student.class)에 기본생성자 메소드가 자동으로 추가된다.
	 * 
	 * 컴파일러가 자동으로 추가된 기본 생성자 메소드
	 * public Student(){
	 * 
	 * }
	 */
	
	// 직접 기본 생성자 메소드를 정의함.
	public Student() {
		System.out.println("기본 생성자 메소드가 실행됨.");
		//멤버변수 초기화하기
		no = 0;
		dept = "컴퓨터공학과";
		grade = 1;
		name = "홍길동";
		email = "hong@gmail.com";
		phone = "010-1111-2222";
	}
	
	// 신입생인 경우 학과, 이름, 전화번호만 전달받아서Student객체를 초기화하는 생성자 메소드를 정의함
	public Student(String dept, String name, String phone) {
		this.no = 0;
		this.dept = dept;
		this.grade = 1;
		this.name = name;
		this.email = "없음";
		this.phone = phone;
	}
	

	// 매개변수가 있는 생성자를 정의함.
	public Student(int stuNo, String studDept, int studGrade, String studName, String studEmail, String studPhone) {
		no = stuNo;
		dept = studDept;
		grade = studGrade;
		name = studName;
		email = studEmail;
		phone = studPhone;
	}
	
	// 학생정보를 화면에 출려가는 멤버메소드 정의하기
	void printStudentInfo() {
		System.out.println("학	번: " + no);
		System.out.println("소속학과: " + dept);
		System.out.println("학	년: " + grade);
		System.out.println("이	름: " + name);
		System.out.println("메	일: " + email);
		System.out.println("전화번호: " + phone);
		System.out.println();
		
		
	}
	
	
	
	
}
