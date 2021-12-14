package example_09_28_inner_class_example;


import example_09_28_inner_class_example.Employee.EmployeeBuilder;

public class EmployeeApp {
	public static void main(String[] args) {
		/*
		 * Employee객체는 생성자를 이용해서 생성할 수 없다.
		 * 
		 * public class Employee {
		 * 		private int no;
		 * 		private String name;
		 * 		...
		 * 		private Employee() {}
		 * 		private Employee(int no, String name,...){}
		 */
		// Employee employee = new Employee();
//		Employee employee = new Employee(100, "홍길동", "영업팀", "과장", "hong@gmail.com", "010-1111-2222", "해외영업",
//						450000000L, 0L, new Date());
		
		// static method이므로 클래스인 Employee로 주소값을 호출
		// Builder객체를 이용해서 객체를 생성하고 초기화된 객체를 획득하기
		EmployeeBuilder builder = Employee.builder();
		// 메소드 체이닝   // builder가 얻어짐
		Employee employee = builder.no(100).name("홍길동").dept("영업1팀")
									.position("과장")
									.salary(5_000_000)
									.job("해외영업")
									.build();
		
		// Builder객체를 이용해서 객체를 생성하고 초기화된 객체를 획득하기
		// builder()는 정적 메소드이므로 Employee객체를 생성하지 않고 사용가능
		Employee employee2 = Employee.builder()
								.no(200)
								.name("김유신")
								.dept("연구소")
								.salary(4_000_000)
								.build();
		
		// 객체를 직접 생성
		Employee.EmployeeBuilder builder2 = new Employee.EmployeeBuilder();
		Employee employee3 = builder2.no(200)
								.name("김유신")
								.dept("연구소")
								.salary(4_000_000)
								.build();
	}
}
