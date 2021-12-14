package example_09_06_class;

public class ScoreApp1 {
	public static void main(String[] args) {
		/*
		 * Score 클래스를 이용해서 성적정보를 관리하기
		 * 
		 * 여러 명(3명)의 성적정보를 관리하는 애플리케이션 구현
		 */
		Score score1 = new Score();
		score1.studentName = "김유신";
		score1.kor = 100;
		score1.eng = 80;
		score1.math = 80;
		score1.total = score1.kor + score1.eng + score1.math;
		score1.average = score1.total/3;
		
		Score score2 = new Score();
		score2.studentName = "홍길동";
		score2.kor = 70;
		score2.eng = 100;
		score2.math = 100;
		score2.total = score2.kor + score2.eng + score2.math;
		score2.average = score2.total/3;
		
		Score score3 = new Score();
		score3.studentName = "강감찬";
		score3.kor = 80;
		score3.eng = 80;
		score3.math = 80;
		score3.total = score3.kor + score3.eng + score3.math;
		score3.average = score3.total/3;
		
		/*
		 * 이번 시험에 참가한 학생의 이름을 출력하기
		 */
		System.out.println("시험에 참가한 학생들의 이름");
		System.out.println(score1.studentName);
		System.out.println(score2.studentName);
		System.out.println(score3.studentName);
		
		System.out.println("시험에 참가한 학생들의 평균점수");
		System.out.println(score1.average);
		System.out.println(score2.average);
		System.out.println(score3.average);
		System.out.println();
		
		System.out.println("시험에 참가한 학생들의 과목별 성적");
		System.out.println(score1.kor + "," + score1.eng + "," + score1.math);
		System.out.println(score2.kor + "," + score2.eng + "," + score2.math);
		System.out.println(score3.kor + "," + score3.eng + "," + score3.math);
		
	}
}
