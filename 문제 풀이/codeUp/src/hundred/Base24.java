package hundred;

import java.io.*;
import java.util.*;

public class Base24 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String word = bf.readLine();

//		String[] words = word.split("");
//		Arrays.stream(words).forEach(s -> System.out.println("'"+ s + "'"));
		
		for (int i=0; i<word.length(); i++) {
			System.out.println("'" + word.charAt(i) + "'");
		}
	}
}
