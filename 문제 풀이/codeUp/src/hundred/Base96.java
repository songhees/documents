package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base96 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bf.readLine());
		
		int[][] f = new int[19][19];
		while (count-- != 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			f[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		for (int x=0; x<19; x++) {
			for (int y=0; y<19; y++) {
				System.out.print(f[x][y] + " ");
			}
			System.out.println();
		}
	}
}
