package example_09_17_polymorphism;
/**
 * 직원들의 정보를 입력/출력하는 클래스
 * @author 오송희
 *
 */
public class Employee extends Person{
	
	private String dept;	// 담당 부서
	private String job;		// 맡은 업무
	private int salary;		// 봉금
	
	public Employee() {}
	public Employee(String type, String name, String tel, String dept, String job, int salary) {
		super(type, name, tel);		// 
		this.dept = dept;
		this.job =job;
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public String getJob() {
		return job;
	}
	public int getSalary() {
		return salary;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("소속부서: " + dept);
		System.out.println("담당업무: " + job);
		System.out.println("급   여: " + salary);
	}
}
