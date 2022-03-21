package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base91 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		long start = Integer.parseInt(st.nextToken());
		int muti = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int no = Integer.parseInt(st.nextToken());
		
		int count = 1;
		while (count++ != no) {
			start *= muti; 
			start += num;
		}
		System.out.println(start);
	}
}
