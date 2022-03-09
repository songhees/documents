package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base69 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String score = bf.readLine();
		
		switch (score) {
			case "A": {
				score = "best!!!";
				break;
			}
			case "B": {
				score = "good!!";
				break;
			}
			case "C": {
				score = "run!";
				break;
			}
			case "D": {
				score = "slowly~";
				break;
			}
			default:
				score="what?";
		}
		System.out.println(score);
	}
}
