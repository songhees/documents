package math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2869 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
		int a = Integer.parseInt(st.nextToken()); //첫번째 호출
		int b = Integer.parseInt(st.nextToken()); 
		int v = Integer.parseInt(st.nextToken()); 
		
		int n = (int)Math.ceil((double)(v-a)/(a-b));
		
		System.out.println(n+1);
	}
}
