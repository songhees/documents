package example_09_13_coding;

public class Student {
	
	private int no;
	private int grade;
	private String name;
	private ScoreDetail score;
	//ScoreDetail의 주소값을 저장하는 참조변수이므로 null값이 들어있다. 객체가 형성되기 전
	
	public Student() {}	//기본 생성자
	public Student(int no, int grade, String name, ScoreDetail score) {
		this.no = no;
		this.grade = grade;
		this.name = name;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScoreDetail getScore() {
		return score;	// ScoreDetail의 주소값을 반환하는 메소드
	}
	public void setScore(ScoreDetail score) {
		this.score = score;	// ScoreDetail의 주소값을 복사 받아서 저장하는 메소드
	}
}
