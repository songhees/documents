package math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math10250 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int num = Integer.parseInt(br.readLine());
		
		int i = 1;
		while (num >= i) {
			i++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); 
			int n = Integer.parseInt(st.nextToken()); 
			
			if (n%h == 0) {
				sb.append(h);
			} else {
				sb.append(String.valueOf(n%h));
			}
			
			int wf = (int)Math.ceil(((double)n/h));
			
			if (wf < 10) {
				sb.append("0");
			} 
			sb.append(String.valueOf(wf) + "\n");
		}
		System.out.println(sb);
	}
}
