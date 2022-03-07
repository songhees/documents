package hundred;

import java.io.*;

public class Base67 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(bf.readLine());
		
		System.out.println(num < 0 ? "minus" : "plus");
		System.out.println(num%2 == 0 ? "even" : "odd");
	}
}
