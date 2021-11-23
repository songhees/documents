package example_09_09_constructor;

public class Sample1App {
	public static void main(String[] args) {
		// 값 변경 기능이 구현된 Sample1객체 생성
		Sample1 sample1 = new Sample1();	//Sample1클래스로부터 Sample1객체를 생성하여 sample1참조변수에 주소값을 대입
		// 변경할 값 생성
		int number = 100;					//int타입 number변수에 100을 대입
		Student student = new Student("컴퓨터공학과", "김유신", "010-1111-2222"); 
		//Student의 실행파일이 loading되고 파일로부터 Student객체를 생성한 직후 생성자를 실행하여 멤버변수 초기화실행 후 student참조변수에 주소값을 대입
		System.out.println();
		System.out.println("changeValue메소드 실행 전 number: " + number); //100
		System.out.println("changeValue메소드 실행 전 Student: ");
		student.printStudentInfo();		//dept = "컴퓨터공학과", name =  "김유신", phone = "010-1111-2222"
		
		// changeValue() 메소드를 실행해서 값 변경하기
		sample1.changeValue(number);		// 오리지널 number의 값은 변하지 않음 //sample1가 참조하는 객체Sample1의 changeValue에 number의 값을 대입
		sample1.changeValue(student);		// student의 멤버변수 값이 변함 ////sample1가 참조하는 객체Sample1의 changeValue에 Student 주소값을 대입
		
		System.out.println();
		System.out.println("changeValue메소드 실행 후 number: " + number); //100
		System.out.println("changeValue메소드 실행 후 Student: "); //dept = "기계공학과", name = "강감찬", phone = "010-1111-1111"
		student.printStudentInfo();
	}
}
