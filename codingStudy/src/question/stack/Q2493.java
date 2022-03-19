package question.stack;

import java.util.Scanner;
import java.util.Stack;

public class Q2493 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int count = scan.nextInt();
		
		Stack<Integer> s = new Stack<>();
		while (count-- != 0) {
			s.push(scan.nextInt());
		}
		
		int other = 1;
		for (int i=1; i<=s.size(); i++) {
			int start = s.pop();
			
		}
	}
}
