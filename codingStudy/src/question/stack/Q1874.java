package question.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int count = Integer.parseInt(bf.readLine());
		
		Stack<Integer> s = new Stack<>();
		int f = 0;
		while (count != 0) {
			int a = Integer.parseInt(bf.readLine());
			
			if (f < a) {
				for (int i=f+1; i<=a; i++) {
					s.push(i);
					sb.append("+").append("\n");
				}
				f = a;
			} else if (s.peek() != a) {
				System.out.println("NO");
				return;
			}
			
			s.pop();
			sb.append("-").append("\n");
			count--;
 		}
		
		System.out.println(sb);
	}
}
