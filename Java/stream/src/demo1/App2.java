package demo1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class App2 {
	public static void main(String[] args) {
		// 스트림 생성
		IntStream numberStream = IntStream.rangeClosed(1, 10);
		// 스트림 필터링 참인 것만 stream에 포함
		numberStream
					.filter(num -> num <= 5)					// filter(람다식) : 람다식의 값이 true를 반환하는 것만 새 스트림에 포함된다.
					.forEach(num -> System.out.println(num));	
		
		String[] names = {"서울", "경기", "인천", "서울", "부산", "인천", "울산"};
		Arrays.stream(names)
				.distinct()										// distinct() : 중복된 요소가 제거된 새 스트림을 반환하다.
				.forEach(name -> System.out.println(name));
	}
}
