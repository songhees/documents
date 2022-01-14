package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base19 {
	public static void main(String[] args) throws IOException {
		// 메타문자는 정규표현식에서 일정한 의미를 가지고 쓰는 특수문자를 메타문자라고 부른다.
		// split() 함수 사용 시 메타문자로 들어가는 특수문자를 구분자로 사용할 때는 메타문자 앞에 \(역슬래쉬) 2번 붙인다.
		// https://codevang.tistory.com/114
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] array = bf.readLine().split("\\.");
		// %04d 4자리의 d값을 만드는데 모자르면 앞에 0을 붙인다.
		System.out.printf("%04d.%02d.%02d", Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
	}
}
