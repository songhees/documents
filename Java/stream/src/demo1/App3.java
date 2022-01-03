package demo1;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App3 {
	public static void main(String[] args) {
		// 스트림의 생성
		IntStream intStream = IntStream.rangeClosed(1, 10);
		// 스트림의 변환
		intStream.map(num -> num*2)					// map(람다식) : 람다식의 반환값이 포함된 새 스트림을 반환한다.
					.forEach(System.out::println);
		// System.out::println 값 한개 씩 출력할 때 사용
		
		String[] arr = {"나는 학교에 값니다.", "올해는 2022년 입니다.", "학생들은 줌으로 수업을 듣습니다."};
		// 스트림 생성
		Arrays.stream(arr)
		// 스트림 변환
//		.map(text -> text.split(" "))
			.flatMap(text -> Stream.of(text.split(" ")))	// flatMap(람다식) : 람다식이 반환하는 스트림들이 전부 병합된 새 스트림을 반화한다.
			.forEach(System.out::println);
	}
}
