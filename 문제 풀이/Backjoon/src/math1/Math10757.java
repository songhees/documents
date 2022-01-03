package math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Math10757 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String[] first = st.nextToken().split("");
		String[] second = st.nextToken().split(""); 
		
		List<Integer> num = new ArrayList<Integer>();
		if (first.length <= second.length ) {
			for (int i=0; i<first.length; i++) {
				num.add(Integer.parseInt(first[i]) + Integer.parseInt(second[i]));
			}
		} else {
			for (int i=0; i<second.length; i++) {
				num.add(Integer.parseInt(first[i]) + Integer.parseInt(second[i]));
			}
		}
		
		for (int i=1; i<num.size(); i++) {
			if (num.get(num.size() -i) >= 10) {
				num.set((num.size() -(i+1)), (num.get(num.size() -(i+1))+1));
				num.set(num.size() -i, (num.get(num.size() -i))-10);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int n : num) {
			sb.append(n);
		}
		System.out.println(sb.toString());
	}
}
