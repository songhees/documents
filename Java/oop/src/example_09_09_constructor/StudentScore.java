package example_09_09_constructor;

public class StudentScore {
	/*
	 * 학생 시험점수 객체용 클래스
	 * 		1. 멤버변수
	 * 			학번
	 * 			이름
	 * 			국어점수
	 * 			영어점수
	 * 			수학점수
	 * 			총점
	 * 			평균
	 * 		2. 생성자 메소드
	 * 			기본 생성자 메소드
	 * 			학번, 이름을 초기화하는 생성자 메소드
	 * 			학번, 이름, 국어점수, 영어점수, 수학점수을 전달받아서 총점과 평균까지 초기화하는 생성자 메소드
	 * 		3. 멤버메소드
	 * 			학생의 시험점수 출력하는 메소드
	 * 				학번, 이름, 국어/영어/수학/총점/평균을 출력하는 메소드
	 * 				
	 */
	int no;
	String name;
	int kor;
	int eng;
	int math;
	int totalScore;
	double average;

	public StudentScore(){
		
	}
		
	//source -> generate using fields 로 생성자를 자동생성
	
	public StudentScore(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	

	public StudentScore(int no, String name, int kor, int eng, int math) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		totalScore = kor + eng + math;
		average = totalScore/3.0;
	}

	public void printScore() {
		System.out.println("이름: " + no);
		System.out.println("학번: " + name);
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + math);
		System.out.println("총점수: " + totalScore);
		System.out.println("평균점수: " + average);
		System.out.println();
	}
	

}
