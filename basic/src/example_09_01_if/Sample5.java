package example_09_01_if;

public class Sample5 {
	public static void main(String[] args) {
		/*
		 * 국어, 영어, 수학점수를 입력받아서 총점과 평균을 계산해서 출력한다.
		 * 평균이 60점 이상인 경우 "합격입니다."를 출력하고, 60점 미만은 "불합격입니다."를 출력한다.
		 * 명사의 갯수만큼 변수를 만든다.
		 * 
		 * 출력예시
		 * 		국어점수 : 100
		 * 		영어점수 : 80
		 * 		수학점수 : 90
		 * 		총점 : 290
		 * 		평균 : 90
		 * 		합격여부 : 합격입니다. 
		 */
		int korScore = 100;
		int engScore = 80;
		int mathScore = 90;									//점수 입력
		
		/*int totalScore = 0;
		 * totalScore += korScore
		 * totalScore += engScore
		 * totalScore += mathScore
		 */
		int totalScore = korScore + engScore + mathScore; 	//총점계산
	
		int average = totalScore/3;							//평균
		
		String passResult = "";
		if (average >= 60) {
			passResult = "합격입니다.";
		} else {
			passResult = "불합격입니다.";
		}													//합격여부
		
		System.out.println("국어점수 : "+ korScore);
		System.out.println("영어점수 : "+ engScore);
		System.out.println("수학점수 : "+ mathScore);
		System.out.println("총   점 : "+ totalScore);
		System.out.println("평   균 : "+ average);
		System.out.println("합격여부 : " + passResult); 		//결과 출력
	}
}
