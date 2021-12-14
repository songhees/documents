package example_10_01_system;

import java.io.IOException;

public class SystemApp {
	public static void main(String[] args) throws IOException{
		
		System.out.println(System.err);
		System.out.println(System.in);
		System.out.println(System.out);
		
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자");
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자");
		System.out.println("표준 에러출력장치로 메세지를 출력하자");
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자");
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자");
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("표준 입력장치로 부터 입력을 읽어보자");
		System.out.println("입력해보세요:");
		int value = System.in.read();
		System.out.println(value);
		System.out.println((char)value);
	}
}
