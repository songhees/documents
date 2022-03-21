package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base98 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int ss = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int[][] f = new int[ss][g];
		int count = Integer.parseInt(bf.readLine());
		
		while (count-- != 0) {
			StringTokenizer s = new StringTokenizer(bf.readLine(), " ");
			int len = Integer.parseInt(s.nextToken());
			int type = Integer.parseInt(s.nextToken());
			int x = Integer.parseInt(s.nextToken())-1;
			int y = Integer.parseInt(s.nextToken())-1;
			if (type == 0) {
				while (len-- != 0) {
					f[x][y] = 1;
					y++;
				}
			} else {
				while (len-- != 0) {
					f[x][y] = 1;
					x++;
				}
			}
		}
		
		for (int x=0; x<ss; x++) {
			for (int y=0; y<g; y++) {
				System.out.print(f[x][y] + " ");
			}
			System.out.println();
		}
	}
}
