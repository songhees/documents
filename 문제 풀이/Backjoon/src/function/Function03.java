package function;

import java.util.Scanner;

public class Function03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int a = 0;
		for(int i = 1; i <= N; i++) {
			a += su(i);
		}
		System.out.println(a);
		scan.close();
	}
	
	public static int su(int num) {
		if (num < 100) {
			return 1;
		} else if (num == 1000) {
			return 0;
		}
		
		int[] b = new int[3];
		int i = 0;
		while(num>0) {
			b[i]= num%10;
			num /= 10;
			i++;
		}
		int	q = (b[0]-b[1] == b[1]-b[2])? 1 : 0;
		return q;
	}
}
