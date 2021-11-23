package example_09_09_constructor;

public class StudentScoreApp {
	public static void main(String[] args) {
		
		StudentScore score1 = new StudentScore(100, "홍길동", 100 ,80 ,80);
		StudentScore score2 = new StudentScore(200, "김유신", 90 ,80 ,80);
		StudentScore score3 = new StudentScore(300, "강감찬", 70 ,80 ,70);
		StudentScore score4 = new StudentScore(400, "이순신", 100 ,90 ,50);
		StudentScore score5 = new StudentScore(500, "류관순", 70 ,60 ,60);
		
		score1.printScore();
		score2.printScore();
		score3.printScore();
		score4.printScore();
		score5.printScore();
		
	}
}
