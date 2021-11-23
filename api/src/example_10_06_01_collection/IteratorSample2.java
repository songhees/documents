package example_10_06_01_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorSample2 {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(100, "이순신", "영업팀", false));
		employeeList.add(new Employee(101, "김유신", "영업팀", false));
		employeeList.add(new Employee(102, "강감찬", "총무팀", true));
		employeeList.add(new Employee(103, "이성계", "총무팀", false));
		employeeList.add(new Employee(104, "을지문덕", "총무팀", true));
		employeeList.add(new Employee(105, "권률", "홍보팀", false));
		employeeList.add(new Employee(106, "임경업", "홍보팀", true));
		
		System.out.println("### 계약기간이 만료된 직원정보 삭제하기");
		Iterator<Employee> iter = employeeList.iterator();
		
		while(iter.hasNext()) {
			Employee emp = iter.next();
			if (emp.isExpried()) {
				iter.remove(); // Iterator를 사용하면 자료구조내에 저장된 객체를 삭제할 수 있다.
			}
		}
		
//		Iterator<E>는 1회용 객체다.
//		위에서 반복작업에 사용했던 Iterator를 재사용할 수 없다.
//		이 코드에서 iter.hasNext() 무조건 false다. <= 아까 반복을 끝까지 했기 때문에
//		iter = employeeList.iterator();
//		System.out.println("### 계약기간이 남아있는 직원정보 출력하기");
//		while(iter.hasNext()) {
//			Employee emp = iter.next();
//			System.out.println(emp.getName());
//		}
		
		System.out.println("### 계약기간이 남아있는 직원정보 출력하기");
		for (Employee emp : employeeList) {
			System.out.println(emp.getName() + ", " + emp.getId() + ", " + emp.getDept());
		}
	}
	
	public static class Employee{
		private int id;
		private String name;
		private String dept;
		private boolean isExpried;
		
		public Employee(int id, String name, String dept, boolean isExpried) {
			this.id = id;
			this.name = name;
			this.dept = dept;
			this.isExpried = isExpried;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getDept() {
			return dept;
		}

		public boolean isExpried() {
			return isExpried;
		}
		
		
		
	}
}
