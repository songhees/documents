package example_08_31_var;

public class Sample1 {
	public static void main(String[] args) {
		/*국어,		수학,		영어,		총점,		평균을 저장하는 변수 만들기
		  정수		정수		정수		정수		실수
		  int		int		int		int		double
		 korScore mathScore engScore totalScore averageScore */
		
		//변수(값을 담는 저장소) 생성하기
		
		int korScore; //정수를 저장하는 저장소를 메모리에 생성하고, 그 저장소의 이름을 korScore로 지정함.
		int mathScore;
		int engScore;
		int totalScore;
		double averageScore;
		
		//생성된 변수에 값을 대입(저장)하기
		korScore = 100;
		mathScore = 80;
		engScore = 90;
		
		//변수에 지정된 값 사용하기
		//변수에 지정된 값 화면에 출력하기
		System.out.println("국어, 수학, 영어점수 출력하기");
		System.out.println(korScore);
		System.out.println(mathScore);
		System.out.println(engScore);
		//System.out.println(totalScore);  //오류 : 값이 들어있지 않는 변수는 사용할 수 없다.
		
		//변수에 지정된 값을 연산에 활용하기
		//대입연산자(=)는 모든 연산자 중에서 우선 순위가 가장 낮다.
		totalScore = korScore + mathScore + engScore;
		averageScore = totalScore / 3;
		
		//변수에 지정된 값 화면에 출력하기
		System.out.println("총점, 평균 출력하기");
		System.out.println(totalScore);
		System.out.println(averageScore);
		
		
		
	}
}
