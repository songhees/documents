package example_09_09_constructor;

public class Sample1 {

	
	// 기본자료형값을 전달받아서 값을 변경하는 메소드
	void changeValue(int number) {
		System.out.println("전달받은 number의 값" + number);
		number++;
		System.out.println("변경된 number의 값" + number);
	}
	
	
	// 객체를 전달받아서 값을 변경하는 메소드
	void changeValue(Student student) {
		System.out.println("전달받은 student의 값");
		student.printStudentInfo();
		
		student.no = 300;
		student.name = "강감찬";
		student.dept = "기계공학과";
		student.email = "kang@jhta.com";
		student.phone = "010-1111-1111";	//Student의 phone필드에 "010-1111-1111"값을 대입
		
		System.out.println("변경된 student의 값");
		student.printStudentInfo();			//student의 printStudentInfo 메소드를 사용하여 값을 화면에 출력
	}
	
}
