package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base95 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		// 배열을 안쓰고 변수 2개로 입력된 값마다 비교하여 최소값 확인
		int min = 10000;
		while (st.hasMoreTokens()) {
			int end = Integer.parseInt(st.nextToken());
			if (min > end) {
				min = end;
			}
		}
		System.out.println(min);
		
	}
}
