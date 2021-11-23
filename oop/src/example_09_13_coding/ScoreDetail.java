package example_09_13_coding;

public class ScoreDetail {
	
	private int kor;	//인스턴스 변수
	private int eng;	
	private int math;	
	

	public ScoreDetail() {}
	public ScoreDetail(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getKor() {	// 인스턴스 메소드
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getTotal() {			// 계산으로 가능한 값은 되도록 변수를 따로 만들어 놓지 않는다.
		return kor + eng + math;
	}
	public int getAverage() {
		return getTotal()/3;
	}
}
