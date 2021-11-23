package example_09_02_array;

public class Sample2 {
	public static void main(String[] args) {
		/*
		 * 새 배열을 생성하기
		 */
		int[] scores;			// 정수값을 여러 개 저장하는 배열객체의 주소값을 저장하는 변수 생성하기
		scores = new int[5]; 	// 정수를 5개 저장하는 배열객체를 생성하고, 그 객체의 주소값을 scores에 대입
		
		// 배열의 각 요소에 인덱스를 사용해서 값을 저장하기
		scores[0] = 70;			// socres 변수가 참조하는 배열객체의 0번째 요소에 70을 저장
		scores[1] = 65;
		scores[2] = 90;
		scores[3] = 60;
		scores[4] = 80;
		
		// 배열의 각 요소에 저장된 값을 인덱스를 사용해서 조회하기
		System.out.println("0번째 요소의 값: " + scores[0]);
		System.out.println("1번째 요소의 값: " + scores[1]);
		System.out.println("2번째 요소의 값: " + scores[2]);
		System.out.println("3번째 요소의 값: " + scores[3]);
		System.out.println("4번째 요소의 값: " + scores[4]);
		
		// 배열의 크기를 조회하기
		int size = scores.length;
		System.out.println("배열의 크기: " + size);
		
		// 배열의 각 요소에 저장된 값을 반복문을 사용해서 조회하기
		for (int i = 0; i < size; i++) {		// 
			System.out.println(i + "번째 요소의 값: " + scores[i]);
		}
		
		// 배열의 각 요소에 저장된 값을 향상된-for문을 사용해서 조회하기
		/*
		 * 데이터타입[] 배열 = new 데이터타입[3];
		 * int[] 배열 = new int[3];
		 * 배열[0] = 10;
		 * 배열[1] = 30;
		 * 배열[2] = 70;
		 * 
		 * 배열이나 collection에서만 사용가능
		 * 항상 배열의 처음부터 끝까지 알아서 반복을 수행한다.
		 * enhanced-for문(향상된-for문) 데이터 조회할 때만 쓴다.
		 * for (배열에서 꺼낸 값을 담을 변수 : 배열(하나씩 추출할 배열의 참조변수))
		 * for (데이터타입 변수명 : 배열)
		 */
		for (int score  : scores) {
			System.out.println("점수: " + score);
		}
	
		
		
		
	}
}
