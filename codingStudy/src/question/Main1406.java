package question;

import java.io.*;
import java.util.*;

public class Main1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String initial = bf.readLine();
		List<Character> list = new LinkedList<>();
		for (int i=0; i<initial.length(); i++) {
			list.add(initial.charAt(i));
		}
		int count = Integer.parseInt(bf.readLine());
		
		ListIterator<Character> iter = list.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}
		for (int i=0; i<count; i++) {
			String order = bf.readLine();
			switch(order) {
				case "L" : {
					if (iter.hasPrevious()) {
						iter.previous();
					}
					break;
				}
				case "D" : {
					if (iter.hasNext()) {
						iter.next();
					}
					break;
				}
				case "B" : {
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				}
				default :{
					iter.add(order.charAt(2));
					break;
				}
			}
		}
		
		for (char c : list) {
			bw.write(c);
		}
		bw.flush();
		bw.close();
	}
}
