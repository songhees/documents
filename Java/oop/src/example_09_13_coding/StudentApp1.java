package example_09_13_coding;

public class StudentApp1 {
	public static void main(String[] args) {
		
		Student student1 = new Student();	// 시험을 본 학생 //객체 형성하고 주소값을 참조변수에 대입
		Student student2 = new Student();	// 시험을 본 학생
		Student student3 = new Student();	// 시험을 안본 학생
		
		student1.setNo(10);				// 참조변수가 참조하는 객체의 메소드에 값을 전달하며 메소드를 실행
		student1.setGrade(2);
		student1.setName("이순신");
		
		ScoreDetail scoreDetail1 = new ScoreDetail();	// ScoreDetail객체를 형성후 참조변수에 주소값 대입
		scoreDetail1.setKor(80);	// 참조변수가 참조하는 객체ScoreDetail의 setKor에 매개변수 80를 전달하여 실행
		scoreDetail1.setEng(70);
		scoreDetail1.setMath(85);
		student1.setScore(scoreDetail1);
		// student1참조변수가 참조하는 객체Student에 매개변수 scoreDetail가 가지는 ScoreDetail객체의 주소값을
		// 매개변수로 하여금 setScore을 실행하여 주소값을 복사/저장
		
		student2.setNo(12);
		student2.setGrade(2);
		student2.setName("강감찬");
		
		ScoreDetail scoreDetail2 = new ScoreDetail();
		scoreDetail2.setKor(60);
		scoreDetail2.setEng(55);
		scoreDetail2.setMath(40);
		student2.setScore(scoreDetail2);

		student3.setNo(1);
		student3.setGrade(1);
		student3.setName("류관순");
		
		//이순신의 번호, 학년, 이름, 국ㅇ, 영어, 수학, 총점, 평균을 출력하기
		System.out.println("### 이순신의 정보 및 시험정보 출력하기");
		System.out.println("번호: " + student1.getNo());
		System.out.println("이름: " + student1.getName());
		System.out.println("학년: " + student1.getGrade());
		
		System.out.println(student1.getScore());
		// main메소드가 println메소드를 실행시키고 그다음
		//student1변수가 참조하는 Student객체의 메소드를 실행하여 객체의 score변수가 가지고있는 주소값을 반환
		// 하지만 자바는 주소값을 출력하지 않고  해시?를 반환하여 메소드를 끝내고 println메소드가 이를 출력
		// 한다음 메소드를 끝내고 main메소드를 마저 실행시킨다.
		
		System.out.println("국어: " + student1.getScore().getKor());
		// student1변수가 참조하는 Student객체의 getScore()변수의 반환되는 변수가 참조하는
		// ScoreDetail객체의 getKor메소드를 실행시켜 kor변수가 갖는 값을 반환시킨다.
		
		System.out.println("영어: " + student1.getScore().getEng());
		System.out.println("수학: " + student1.getScore().getMath());
		System.out.println("총점: " + student1.getScore().getTotal());
		System.out.println("평균: " + student1.getScore().getAverage());
		System.out.println();
		
		
		System.out.println("### 강감찬의 정보 및 시험정보 출력하기");
		System.out.println("번호: " + student2.getNo());
		System.out.println("이름: " + student2.getName());
		System.out.println("학년: " + student2.getGrade());

		System.out.println(student2.getScore());
		System.out.println("국어: " + student2.getScore().getKor());
		System.out.println("영어: " + student2.getScore().getEng());
		System.out.println("수학: " + student2.getScore().getMath());
		System.out.println("총점: " + student2.getScore().getTotal());
		System.out.println("총점: " + student2.getScore().getAverage());
		System.out.println();
		
		
		System.out.println("### 류관순의 정보 및 시험정보 출력하기");
		System.out.println("번호: " + student3.getNo());
		System.out.println("이름: " + student3.getName());
		System.out.println("학년: " + student3.getGrade());
		
		System.out.println(student3.getScore()); //student3변수가 참조하는 객체는 없으므로 null값을 갖는다.
		System.out.println("국어: " + student3.getScore().getKor());
		System.out.println("영어: " + student3.getScore().getEng());
		System.out.println("수학: " + student3.getScore().getMath());
		System.out.println("총점: " + student3.getScore().getTotal());
		System.out.println("총점: " + student3.getScore().getAverage());
		System.out.println();
	}
}
