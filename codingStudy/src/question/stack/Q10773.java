package question.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bf.readLine());
			
		Stack<Integer> s = new Stack<>();
		int total = 0;
		while (count != 0) {
			int no = Integer.parseInt(bf.readLine());
			if (no == 0) {
				s.pop();
			} else {
				s.push(no);
			}
			count--;
		}
		
		while (!s.isEmpty()) {
			total += s.pop();
		}
		
		System.out.print(total);
	}
}
