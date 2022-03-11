package hundred;

import java.util.Scanner;

/**
 * [기초-종합] 원하는 문자가 입력될 때까지 반복 출력하기
 * @author song
 *
 */
public class Base79 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char al = 0;
		
		while (al != 'q') {
			al = scan.next().charAt(0);
			System.out.println(al);
		} 
		scan.close();
	}
}
