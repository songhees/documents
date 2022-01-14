package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base18 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer strs = new StringTokenizer(bf.readLine(), ":");
//		System.out.printf("%d:%d", Integer.parseInt(strs.nextToken()), Integer.parseInt(strs.nextToken()));
		String[] ad = bf.readLine().split(":");
		System.out.printf("%d:%d", Integer.parseInt(ad[0]), Integer.parseInt(ad[1]));
	}
}
