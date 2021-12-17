package stringArray;

import java.io.IOException;

public class StringArray05_2 {
	public static void main(String[] args) throws IOException {
		//0  26
		//65 90
		int[] arr = new int[26];
		int a = System.in.read();
		
		while (a>64) {
			if (a<91) {
				arr[a-65]++;
			} else {
				arr[a-97]++;
			}
			a = System.in.read();
		}
		int max = 0;
		int position = 0;
		for (int i = 0; i < 26; i ++) {
			if (arr[i]>max) {
				max = arr[i];
				position = i;
			} else if (arr[i] == max) {
				position = -2;
			}
		}
		System.out.println((char)(position+65));
	}
}
