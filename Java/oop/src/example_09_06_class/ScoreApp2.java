package example_09_06_class;

public class ScoreApp2 {
	public static void main(String[] args) {
		/*
		 * 배열을 이용해서 여러 명의 성적을 관리하기
		 * 
		 * Score 객치의 주소값 3개를 저장할 수 있는 배열객체를 생성하고, 배열객체의 주소값을 참조변수 scores에 대입함
		 */
		Score[] scores = new Score[3];		// 객체 Score의 주소값을 저장할 수 있는 배열의 참조변수 scores를 생성
											// 객체 Score의 주소값 3개를 저장할 수 있는 배열객체를 생성하고 주소값을 참조변수에 대입함
		// Score 객체를 생성해서 참조변수 score1에 주소값 대입
		Score score1 = new Score();
		// 참조변수 score1으로 생성된 Score객체의 멤버변수에 상적정보 저장
		score1.studentName = "김유신";
		score1.kor = 100;
		score1.eng = 80;
		score1.math = 40;
		score1.total = score1.kor + score1.eng + score1.math;
		score1.average = score1.total/3;
		// 참조변수 score1에 저장된 주소값을 (배열객체를 참조하는 scores 참조변수를 이용해서) 배열객체의 0번째 칸에 저장
		// 배열객체의 0번째칸도 참조변수 score1이 참조하는 객체를 같이 참조하기 시작함
		// 따라서, score1이 참조하는 객체가 배열객체의 0번째 칸과 연결됨(저장)
		scores[0] = score1;
		
		Score score2 = new Score();
		score2.studentName = "이순신";
		score2.kor = 80;
		score2.eng = 75;
		score2.math = 70;
		score2.total = score2.kor + score2.eng + score2.math;
		score2.average = score2.total/3;		
		// 참조변수 score2에 저장된 주소값을 (배열객체를 참조하는 scores 참조변수를 이용해서) 배열객체의 1번째 칸에 저장
		scores[1] = score2;
		
		Score score3 = new Score();
		score3.studentName = "류관순";
		score3.kor = 100;
		score3.eng = 100;
		score3.math = 80;
		score3.total = score3.kor + score3.eng + score3.math;
		score3.average = score3.total/3;
		// 참조변수 score3에 저장된 주소값을 (배열객체를 참조하는 scores 참조변수를 이용해서) 배열객체의 2번째 칸에 저장
		scores[2] = score3;
		
		/*
		 *  참조변수 scores가 참조하는 배열의 0,1,2번째 칸에 각각 Score객체 연결(저장)이 완료됨
		 *  마침내, 참조변수 scores만 사용해서 모든 성적정보를 관리할 수 있다.
		 */
		System.out.println("이번 시험에 참가한 학생들의 이름과 평균점수 출력하기");
		System.out.println(scores[0].studentName + ", " + scores[0].average);
		System.out.println(scores[1].studentName + ", " + scores[1].average);
		System.out.println(scores[2].studentName + ", " + scores[2].average);
		
		// 배열에 순서대로 저장되어 있기 때문에 반복문을 사용해서 학생들의 성적정보를 처리할 수 있음
		System.out.println("반복문을 사용해서 이번 시험에 참가한 학생들의 이름과 평균점수 출력하기");
		for (int i = 0; i <scores.length; i++) {
			System.out.println(scores[i].studentName + ", " + scores[i].average);
		}
		
		// 배열에 순서대로 저장되어 있기 때문에 향상된-for문을 사용해서 학생들의 성적정보를 처리할 수 있음
		System.out.println("향상된-for문을 사용해서 이번 시험에 참가한 학생들의 이름과 평균점수 출력하기");
		for (Score score : scores) {
			System.out.println(score.studentName  + ", " + score.average);
		}
		
	}
}
