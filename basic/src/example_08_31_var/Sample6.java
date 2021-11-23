package example_08_31_var;

public class Sample6 {
	public static void main(String[] args) {
		/*
		 * 연습1
		 * 		변수를 선언하고 값을 출력해보기
		 * 자신의 이름, 나이, 키, 몸무게, 혈액형, 전화번호, 이메일, 우편번호, 주소를 변수에 저장하고, 변수에 저장된 값을 출력한다.
		 * 
		 */
		String name = "오송희";
		int age = 25;					// 사칙연산 비교연산 가능하므로 숫자로 표현
		double height = 163.0;			// ==
		double weight = 47.0;			// ==
		String bloodType = "AB";
		String number = "010-7282-4449";
		String email = "osh4880@naver.com";
		String postCode = "03302";		//숫자여도 사칙연산 안하는것은 문자열로 표현한다.
		String address = "서울시 은평구 진관4로 37";
				
		System.out.println(name);
		System.out.println(age);
		System.out.println(height+"cm");
		System.out.println(weight+"kg");
		System.out.println(bloodType);
		System.out.println(number);
		System.out.println(email);
		System.out.println(postCode);
		System.out.println(address);
	}
}
