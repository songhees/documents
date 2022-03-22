package hundred;

import java.io.*;
import java.util.*;

public class Base99 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] road = new int[10][10];
		for (int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j=0; j<10; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] trace = {1, 1};
		int count = 9;
		while (count != 2) {
			if (road[trace[0]][trace[1]] == 0) {
				road[trace[0]][trace[1]] = 9;
				trace[1]++;
			} else if (road[trace[0]][trace[1]] == 1) {
				trace[1]--;
				trace[0]++;
			} else if (road[trace[0]][trace[1]] == 2) {
				road[trace[0]][trace[1]] = 9;
				count = 2;
			}
			
			if (trace[0] ==9 && trace[1] ==8) {
				break;
			}
		}
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				System.out.print(road[i][j] + " ");
			}
			System.out.println();
		}
	}
}
