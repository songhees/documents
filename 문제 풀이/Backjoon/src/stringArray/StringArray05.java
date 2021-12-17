package stringArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringArray05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> same = new ArrayList<Integer>();
		
		String al = scan.next();
		al = al.toUpperCase();
		
		String[] als = al.split("");
		Arrays.sort(als);
		int max = 0;
		int position = 0;
		
		list.add(0);
		for(int i = 1; i < als.length; i++) {
			if (!als[i-1].equals(als[i])) {
				list.add(i);
			}
		}
		list.add(als.length);
		
		for (int i = 1; i < list.size(); i++) {
			int difference = (list.get(i) - list.get(i-1));
			if (difference > max) {
				max = difference;
				position = i;
			} 
			same.add(difference);
		}
		
		for (int i = 0; i < same.size(); i++) {
			if (max == same.get(i) && position-1 != i) {
				System.out.println("?");
				return;	
			}
		}
		System.out.println(als[list.get(position-1)]);
	}
}
