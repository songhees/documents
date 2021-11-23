package example_09_17_polymorphism;
/**
 * 학생정보를 입력하고 출력하는 클래스
 * @author 오송희
 *
 */
public class Student extends Person{
	
	private int grade;		// 학년
	private String dept;	// 학과
	
	public Student() {}		// 기본생성자
	public Student(String type, String name, String tel, int grade, String dept) {	// 학생정보를 입력하는 생성자
		super(type, name, tel);		// 상위 클래스의 생성자를 가져와 기본 정보를 입력하도록 한다.
		this.grade =grade;
		this.dept = dept;
	}
	public int getGrade() {
		return grade;
	}
	public String getDept() {
		return dept;
	}
	//Person의 print() 기능 재정의 // 기본 정보를 출력하는 부모 클래스의 메소드를 실행한 다음 추가적인 학생정보를 출력한다.
	@Override
	public void print() {
		super.print();
		System.out.println("학   년:" + grade);
		System.out.println("소속학과:" + dept);
	}
}
