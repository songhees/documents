package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base93 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int[] row = new int[23];
		while (st.hasMoreTokens()) {
			int no = Integer.parseInt(st.nextToken());
			row[no-1]++;
		}
		
		for (int ro : row) {
			System.out.print(ro + " ");
		}
	}
}
