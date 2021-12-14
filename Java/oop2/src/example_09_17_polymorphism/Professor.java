package example_09_17_polymorphism;
/**
 * 교수의 정보를 입/출력하는 클래스
 * @author 오송희
 *
 */
public class Professor extends Person{
	private String dept;				// 담당학과 입력
	private String position;			// 직위
	private String researchProject;		// 연구하는 내용
	
	public Professor() {}
	public Professor(String type, String name, String tel, String dept, String position, String researchProject) {
		super(type, name, tel);			// 기본 정보를 상위 객체의 메소드에 넣음
		this.dept = dept;
		this.position = position;
		this.researchProject = researchProject;
		
	}
	
	public String getDept() {
		return dept;
	}
	public String getPosition() {
		return position;
	}
	
	public String getResearchProject() {
		return researchProject;
	}
	/**
	 * 메소드 재정의 상위 객체로 부터 기본 정보를 출력하고 재정의된 메소드로 출력
	 */
	@Override
	public void print() {
		super.print();
		System.out.println("담당학과: " + dept);
		System.out.println("직   위: " + position);
		System.out.println("연구과제: " + researchProject);
	}
	
	
	
	
	
}
