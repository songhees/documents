package example_09_17_polymorphism;

import java.util.Scanner;

public class PersonApp {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PersonService personService = new PersonService();
		
		while(true) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1.조회	2.등록	3.검색	0.종료");
			System.out.println("--------------------------------------------------------");
			
			System.out.print("메뉴 번호 입력: ");
			int menuNo = scan.nextInt();
			
			if (menuNo == 1) {
				System.out.println("[조회]");
				personService.printAllPerson();
				
				
			} else if (menuNo == 2) {
				System.out.println("[신규 등록]");
				System.out.println("### 신규 등록할 학생, 교수 혹은 직원정보를 입력하세요.");				
				
				System.out.println("이름 입력: ");
				String name = scan.next();
				
				System.out.println("전화번호 입력: ");
				String tel = scan.next();
				
				
				System.out.println("등록타입 선택(학생, 교수, 직원 중 택일): ");
				String type = scan.next();
			
				if ("교수".equals(type)) {
					System.out.println("담당학과 입력: ");
					String dept = scan.next();
					
					System.out.println("직위 입력: ");
					String position = scan.next();
					
					System.out.println("연구과제 입력: ");
					String researchProject = scan.next();
					
					personService.addNewPerson(new Professor(type, name, tel, dept, position, researchProject));
				
				} else if ("학생".equals(type)) {
					System.out.println("학년 입력: ");
					int grade = scan.nextInt();
					
					System.out.println("소속학과 입력: ");
					String dept = scan.next();
					
					personService.addNewPerson(new Student(type, name, tel, grade, dept));
					
				} else if ("직원".equals(type)) {
					System.out.println("소속부서 입력: ");
					String dept = scan.next();
					
					System.out.println("업무 입력: ");
					String job = scan.next();
					
					System.out.println("급여 입력: ");
					int salary = scan.nextInt();
					
					Employee employee = new Employee(type, name, tel, dept, job, salary);
					personService.addNewPerson(employee);
				}
				
				
			} else if (menuNo == 3) {
				System.out.println("[검색]");
		
				System.out.println("검색방식 입력(번호, 이름 중 택일)");
				String opt = scan.next();
				
				if ("번호".equals(opt)) {
					System.out.println("번호 입력: ");
					int no = scan.nextInt();
					// 참조자료형은 null인지 항상 확인
					// 반환타입이 참조자료형인 메소드의 반환값은 null일 수도 있다.★.★.★.★.★
					Person person = personService.searchPerson(no);
					if ( person != null) {
						person.print();
					} else {
						System.out.println("### 입력한 번호와 일치하는 정보가 없습니다.");
					}
					
				} else if ("이름".equals(opt)) {
					System.out.println("이름 입력: ");
					String name = scan.next();
					// 반환타입이 참조자료형인 메소드의 반환값은 null일 수도 있다.★.★.★.★.★
					Person person = personService.searchPerson(name);
					if ( person != null) {
						person.print();
					} else {
						System.out.println("### 입력한 이름과 일치하는 정보가 없습니다.");
					}
				}
				
				
			} else if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			} 	
		}
		scan.close();
	}
}
