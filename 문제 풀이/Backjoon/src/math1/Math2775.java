package math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2775 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sf = new StringBuffer();
		
		int num = Integer.parseInt(bf.readLine());

		for (int i = 0; i < num; i++) {
			int a = Integer.parseInt(bf.readLine());
			int b = Integer.parseInt(bf.readLine());
			sf.append(personNum(a, b) + "\n");
		}
		System.out.println(sf.toString());
	}
	
	public static int personNum(int a, int b) {
		int[][] floor = new int[a+1][b];
		for (int i = 0; i <= a; i++) {
			
			for (int j = 0; j <= b-1 ; j++) {
				
				if (j == 0) {
					floor[i][0] = 1;
				} else if (i == 0) {
					floor[0][j] = j+1;
				} else {
					floor[i][j] = floor[i-1][j] + floor[i][j-1];
				} 
			}
		}
		return floor[a][b-1];
	}
}
