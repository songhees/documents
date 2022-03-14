package hundred;

import java.util.Scanner;

public class Base85 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long h = scan.nextInt();
		long b = scan.nextInt();
		long c = scan.nextInt();
		long s = scan.nextInt();
		
		double mb = (int)Math.round((h*b*c*s/(8*1024*1024.0))*10)/10.0;
		System.out.print(mb + " MB");
		scan.close();
	}
}
