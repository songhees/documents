package example_10_08_formating;

import java.text.DecimalFormat;

public class DecimalFormatSample1 {
	public static void main(String[] args) {
		// 정수나 실수를 지정된 패턴의 문자열로 변환하기
		
		long amount = 100000000000L;
		
		DecimalFormat df = new DecimalFormat("##,###");
		//오른쪽 부터 읽어 가야됨
		String text1 = df.format(amount);
		System.out.println(text1);
		
		double number = 12345.67;
		df.applyPattern("##,###.#"); // 소수점은 한자리만 나오게
		String text2 = df.format(number);
		System.out.println(text2);
		
		double number2 = 1.0/3.0;
		df.applyPattern("##,###.##"); // 소수점은 두자리만 나오게
		String text3 = df.format(number2);
		System.out.println(text3);
		
		double number3 = 123.2400;
		df.applyPattern("##,###.####");
		String text4 = df.format(number3);
		System.out.println(text4);
		// 0은 #이 소수점에서 쓰일때 표시하지 않는다.
		
		df.applyPattern("##,###.0000");
		String text5 = df.format(number3);
		System.out.println(text5);
		// #은 0이거나 비어있으면 표시하지 않는다. 0은 비어있거나 0이어도 표시한다.(정밀도가 더 높다)
	}
}
