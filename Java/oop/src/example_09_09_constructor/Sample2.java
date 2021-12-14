package example_09_09_constructor;

public class Sample2 {
	
	 // 정수(int number)를 전달받아서 짝수(number%2 == 0)면 true, 홀수면 false를 반환(boolean)하는 메소드
	boolean isEvenNumber(int number) {
		boolean result = false;
		
		if (number%2 == 0) {
			result = true;
		} 
		return result;
		//return (number%2 == 0)? true : false;
		//return number%2 == 0;
	}
	
	
	 // 정수배열객체(int[] numbers)를 전달받아서 배열에 저장된 값의 총합(int)을 반환하는 메소드
	int getTotal(int[] numbers) {
		int total = 0;
		for (int num : numbers) {
			total += num;
		}
		return total;
	}
	
	
	 // 정수배열객체(int[] numbers)를 전달받아서 배열에 저장된 값 중에서 가장 큰 값(int)을 반환하는 메소드
	int getMaxNumber(int[] numbers) {
		
		int max = numbers[0];
		
		for (int num : numbers) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}
	
	
	
	 // 정수배열객체(int[] numbers)와 숫자(int)를 전달받아서
	 //배열에 그 숫자가 포함되어 있으면 true, 없으면 false를 반환(boolean)하는 메소드
	 boolean isExist(int[] numbers, int num) {
		 boolean result = false;
		 
		 for (int number : numbers) {
			 if(number == num) {
				 result = true;
				 break;
			 }
		 }
		 return result;
	 }
	
	
	
	 // 정수(int num)를 전달받아서 그 숫자에 해당하는 구구단을 표시하는 메소드
	 void printGugudan(int num) {
		 
		 for (int i = 0; i<9; i++) {
			 System.out.printf("%d * %d = %d\n", num, i+1, num*(i+1));
		 }
	 }
	 
	 // 국어, 영어, 수학 점수를(int kor, int eng, int math) 전달받아서 평균이 60이상이면 true, 아니면 false를 반환(boolean)하는 메소드
	 boolean averageScore(int kor, int eng, int math) {
		 boolean result = false;
		 int total = kor + eng + math;
		 double average = total/3.0;
		 if (average >= 60) {
			 result = true;
		 }
		 return result;
	 }
	 
	 
	 
	
	 // 정수(int num)를 전달받아서 그 정수의 모든 약수를 화면에 표시하는 메소드
	 void printNumber(int num) {
		 
		 for (int i=1; i<=num; i++) {
			 if (num%i == 0 ) {
				 System.out.print(i + " " + -i + " ");
			 }
		 }	 
	 }
	
	
	

}
