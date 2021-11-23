package example_09_17_polymorphism;
/**
 * 학생, 교수, 교직원에 대한 등록, 조회, 통계 정보를 제공하는 클래스다.
 * @author 오송희
 *
 */
public class PersonService {
	/**
	 * 학생, 교수, 교직원 정보가 저장되는 배열
	 */
	private Person[] database = new Person[100];
	
	/**
	 * database가 참조하는 배열에서 새로운 정보가 저장되는 위치정보를 가지고 있는 변수다.
	 */
	private int position = 0;
	/**
	 * PersonService의 기본 생성자 메소드 =>줄바꿈 <br/>
	 * 테스트를 위해서 위의 database참조변수가 참조하는 배열에 테스트용 데이터를 미리 저장한다.
	 */
	public PersonService() {
		database[position++] = new Student("학생", "홍길동", "010-2586-7530", 3, "전자공학과");
		database[position++] = new Student("학생", "강감찬", "010-2222-3333", 1, "생명공학과");
		database[position++] = new Student("학생", "김김김", "010-4567-7890", 2, "컴퓨터공학과");
		database[position++] = new Student("학생", "이이이", "010-3478-1231", 2, "경영학과");
		database[position++] = new Student("학생", "안중근", "010-2431-0000", 3, "전자공학과");
		database[position++] = new Student("학생", "안창호", "010-1892-4133", 2, "기계공학과");
		database[position++] = new Professor("교수", "김교수", "010-2586-7530", "전자공학과", "부교수", "신 재생에너지 개발 프로젝트");
		database[position++] = new Professor("교수", "오교수", "010-1111-7777", "생명공학", "부교수", "단백질 구조 개발 프로젝트");
		database[position++] = new Professor("교수", "박교수", "010-3211-1777", "기계공학과", "조교수", "인공지능 프로젝트");
		database[position++] = new Professor("교수", "이교수", "010-7878-9999", "컴퓨터공학과", "정교수", "프로그램 개발");
		database[position++] = new Employee("직원", "안중근", "010-853-9510", "교육팀", "과장", 4_500_000);
		database[position++] = new Employee("직원", "류관순", "010-1234-6543", "행정팀", "팀장", 4_000_000);
		database[position++] = new Employee("직원", "유유유", "010-8378-1207", "보안팀", "직원", 3_000_000);
		database[position++] = new Employee("직원", "김좌진", "010-8378-3249", "교육팀", "대리", 3_500_000);
		
	}
	
	/**
	 * 지정된 사람을 데이터베이스에 저장한다.
	 */
	public void addNewPerson(Person person) {	// 매개변수의 다형성이 적용되었다. Person 타입의 변수는 Student/Professor/Employee객체를 전달받을 수 있다.
		database[position] = person;
		position++;
	}
	/**
	 * 모든 사람정보를 화면에 출력한다.
	 */
	public void printAllPerson() {
		for (Person person : database) {
			if (person == null) {
				break;
			}
			// person 참조변수는 Student, Professor, Employee객체의 상위객체인 Person객체를 참조하고 있다.
			// person 참조변수로 print()를 실행하면, person참조변수가 참조하는 Person객체의 print()가 실행되는 것이 아니라
			// Student/Professor/Employee객체에 재정의된 print() 메소드가 실행된다.
			person.print();
			System.out.println();
		}
	}
	
	/**
	 * 지정된 번호로 사람을 찾아서 반환한다.
	 * @param no 일련번호
	 * @return	사람정보, null일 수 있음
	 */
	public Person searchPerson(int no) {	// 반환타입의 다형성이 적용되었다. Person 타입의 반환타입은 Student/Professor/Employee 객체를 모두 반환할 수 있다.
		Person foundPerson = null;
		
		for(Person person : database) {
			if (person != null && person.getNo()==no) {	// null을 먼저 확인해야 된다.!
				foundPerson = person;
				break;
			}
		}
		
		return foundPerson;
	}
	/**
	 * 지정된 이름으로 사람을 찾아서 반환한다.
	 * @param name	검색할 이름
	 * @return 사람정보, null일 수 있음
	 */
	public Person searchPerson(String name) {	// 반환타입의 다형성이 적용되었다. Person 타입의 반환타입은 Student/Professor/Employee 객체를 모두 반환할 수 있다.
		for (Person person : database) {
			if (person != null && person.getName().equals(name)) {	// null을 먼저 확인해야 된다.!
				return person;	// 거짓인경우의 return도 적어야됨
			} 
		}
		return null;
	}
}