package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base97 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] f = new int[19][19];
		for (int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j=0; j<19; j++) {
				f[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Integer.parseInt(bf.readLine());
		while (count-- != 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			for (int i=0; i<19; i++) {
				if (f[i][y]==1) {
					f[i][y]=0;
				} else {
					f[i][y]=1;
				}
				for (int j=0; j<19; j++) {
					if (f[x][j]==1) {
						f[x][j]=0;
					} else {
						f[x][j]=1;
					}
				}
			}
		}
		
		for (int x=0; x<19; x++) {
			for (int y=0; y<19; y++) {
				System.out.print(f[x][y] + " ");
			}
			System.out.println();
		}
	}
}
