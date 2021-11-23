package example_09_01_if;

public class Sample7 {
	public static void main(String[] args) {
		/*
		 * 국어, 영어, 수학점수의 평균이 60점 이상이면 합격이다. 단, 평균이 90점 이상이면 장학금을 지급한다.
		 */
		int korScore = 60;
		int engScore = 80;
		int mathScore = 80;
		int totalScore = korScore +engScore +mathScore;
		int average = totalScore/3;
		
		 // 내포된 if문을 사용하지 않는 경우
		if (average >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		
		if (average >= 90) {
			System.out.println("장학금 지금대상으로 선정되었습니다.");
		}	//이 경우 불합격 대상도 장학금 여부를 판단하는 코드를 거친다.
		
		
		// 내포된 if문을 사용하는 경우
		if (average >= 60) {
			System.out.println("합격입니다.");
			if (average >= 90) {
				System.out.println("장학금 지급대상으로 선정되었습니다.");
			}	//합격대상으로 장학금 지급 확인하는 if문을 실행 (더 경쟁적이다.)
		} else {
			System.out.println("불합격입니다.");
		}	
		
		
		if (average >= 90) {
			System.out.println("장학금 지급대상으로 선정되었습니다.");
		} else if (average >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
	}
}
