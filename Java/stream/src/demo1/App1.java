package demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App1 {
	public static void main(String[] args) {
		List<String> names = List.of("김유신", "강감찬", "이순신", "류관순", "홍길동");
		
		// 스트림의 생성
		Stream<String> stream = names.stream();
		// 스트림 최종연산 매개변수를 하나 받아 없앰(반환하지 않음)
		stream.forEach(name -> System.out.println(name));
		
		// 배열로 부터 스트림 생성하기
		int[] numbers = {100, 70, 50, 60, 70, 80, 90, 70};
		// 스트림 생성
		IntStream intStream =  Arrays.stream(numbers);
		// 스트림 최종연산
		int sum = intStream.sum();
		System.out.println("합계: " + sum);
		
		// 객체를 담고 있는 콜렉션으로 부터 스트림 생성하기
		List<Score> scores = List.of(new Score(100, 100, 100), new Score(100, 90, 80));
		// 스트림 생성
		Stream<Score> scoreStream = scores.stream();
		// 스트림 중간 연산
		Stream<Integer> totalStream = scoreStream.map(score -> score.kor + score.eng + score.math);
		// 스트림 최종 연산
		totalStream.forEach(total -> System.out.println(total));
	}
	
	static class Score {
		int kor;
		int math;
		int eng;
		
		public Score(int kor, int math, int eng) {
			this.kor = kor;
			this.math = math;
			this.eng = eng;
		}
	}
}
