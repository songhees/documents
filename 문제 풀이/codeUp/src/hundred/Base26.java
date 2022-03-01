package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base26 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String time = bf.readLine();
		
		StringTokenizer st = new StringTokenizer(time, ":");
		String[] str = new String[3];
		int i=0;
		while(st.hasMoreTokens()) {
			str[i]=st.nextToken();
			i++;
		}
		int min = Integer.parseInt(str[1]);
		System.out.println(min);
		
//		String[] minute = time.split(":");
//		System.out.println(Integer.parseInt(minute[1]));
	}
}
