package example_09_28_inner_class_example;

import java.util.Date;

public class Employee {

	private int no;			// 사원번호
	private String name; 	// 사원이름
	private String dept;	// 소속부서명
	private String position;// 직위
	private String email;	// 이메일 주소
	private String tel;		// 전화번호
	private String job;		// 업무
	private long salary;	// 급여
	private long commission;// 커미션
	private Date hireDate;	// 입사일

	
	// 생성자 못만듬
	//Employee employee = new Employee(); 수행문을 다른 클래스에서는 실행할 수 없다.
	// 접근 제한이 지정된 기본 생성자
	private Employee() {}
	
	// 접근제한이 지정된 중복정의된 생성자
	private Employee(int no, String name, String dept, String position, String email, String tel, String job,
			long salary, long commission, Date hireDate) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.position = position;
		this.email = email;
		this.tel = tel;
		this.job = job;
		this.salary = salary;
		this.commission = commission;
		this.hireDate = hireDate;
	}
	
//	public Employee(int no, String name, String dept, long salary, Date hireDate) {
//		super();
//		this.no = no;
//		this.name = name;
//		this.dept = dept;
//		this.salary = salary;
//		this.hireDate = hireDate;
//	}
//	public Employee(int no, String name, String dept, String position, String job, long salary, long commission,
//			Date hireDate) {
//		super();
//		this.no = no;
//		this.name = name;
//		this.dept = dept;
//		this.position = position;
//		this.job = job;
//		this.salary = salary;
//		this.commission = commission;
//		this.hireDate = hireDate;
//	}
//	// 필드가 많아질수록 만들어질 생성자가 많아질 수 있다. 매개변수의 순서를 넣기도 힘들다.



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getCommission() {
		return commission;
	}

	public void setCommission(long commission) {
		this.commission = commission;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	// static 메소드이므로 Employee객체를 생성하지 않고 클래스명으로 호출이 가능하다.
	/**
	 * EmployeeBuilder 객체를 제공하는 정적 메소드다
	 * @return	EmployeeBuilder 객체
	 */
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder();
	}
	/**
	 * EmployeeBuilder는 Employee객체를 생성시켜주는 클래스다.
	 * @author 오송희
	 *
	 */
	// 정적 내부클래스
	static class EmployeeBuilder {
		private int no;			
		private String name; 	
		private String dept;	
		private String position;
		private String email;	
		private String tel;		
		private String job;		
		private long salary;	
		private long commission;
		private Date hireDate;
		
		public EmployeeBuilder() {}
		
		public EmployeeBuilder no(int no) {
			this.no = no;
			return this;
		}
		
		public EmployeeBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public EmployeeBuilder dept(String dept) {
			this.dept = dept;
			return this;
		}
		
		public EmployeeBuilder position(String position) {
			this.position = position;
			return this;
		}
		
		public EmployeeBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public EmployeeBuilder tel(String tel) {
			this.tel = tel;
			return this;
		}
		
		public EmployeeBuilder job(String job) {
			this.job = job;
			return this;
		}
		
		public EmployeeBuilder salary(long salary) {
			this.salary = salary;
			return this;
		}
				
		public EmployeeBuilder commission(long commission) {
			this.commission = commission;
			return this;
		}
		
		public EmployeeBuilder hireDate(Date hireDate) {
			this.hireDate = hireDate;
			return this;
		}
		/**
		 * Employee객체를 생성하고 입력된 값을 사용해서 초기화된 Employee객체를 반환한다.
		 * @return Employee 객체
		 */
		public Employee build() {
			// EmployeBuilder객체에 초기화된 no, name값들이 매개변수로 하여금 Employee 생성자에 입력된다.
			// 초기화 안된 변수는 멤버 변수이므로 기본값이 들어 있다.
			// Employee객체를 생성하고 생성자를 초기화하고 주소값을 반환
			Employee employee = new Employee(no, name, dept, position, email, tel, job, salary, commission, hireDate);
			return employee;
		}
	}
	
}
