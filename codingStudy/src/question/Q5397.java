package question;

import java.io.*;
import java.util.*;

public class Q5397 {
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bf.readLine());
		while (count != 0) {
			func(bf.readLine());
			sb.append("\n");
			count--;
		}
		System.out.println(sb.toString());
	}
	
	static void func(String initial) {
		List<Character> result = new LinkedList<>();
		ListIterator<Character> iter = result.listIterator();
		
		for (int i=0; i<initial.length(); i++){
			switch (initial.charAt(i)) {
			case '<':
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case '>':
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case '-':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			default:
				iter.add(initial.charAt(i));
				break;
			}
		}
		for (Character re : result) {
			sb.append(re);
		}
	}
}
