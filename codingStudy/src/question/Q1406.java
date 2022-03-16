package question;

import java.io.*;
import java.util.*;

public class Q1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] initial = bf.readLine().split("");
		List<String> list = new LinkedList<String>(Arrays.asList(initial));
		int count = Integer.parseInt(bf.readLine());
		
		int index = list.size();
		while (count != 0) {
			index = editor(list, bf.readLine(), index);
			count--;
		}
		for (String c : list) {
			bw.write(c);
		}
		bw.flush();
		bw.close();
	}
	
	static int editor(List<String> list, String order, int index) {
		
		switch(order) {
			case "L" : {
				if (index > 0) {
					index--;
				}
				break;
			}
			case "D" : {
				if (index < list.size()) {
					index++;
				}
				break;
			}
			case "B" : {
				if (index > 0) {
					list.remove(--index);
				}
				break;
			}
			default :{
				list.add(index, order.split(" ")[1]);
				index++;
				break;
			}
		}
		return index;
	}
}
