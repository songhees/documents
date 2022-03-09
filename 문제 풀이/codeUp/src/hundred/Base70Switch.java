package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base70Switch {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String month = bf.readLine();
		
        if ("12".equals(month) || "1".equals(month) || "2".equals(month)) {
			month = "winter";
		} else if ("3".equals(month) || "4".equals(month) || "5".equals(month)) {
			month = "spring";
		} else if ("6".equals(month) || "7".equals(month) || "8".equals(month)) {
			month = "summer";
		} else {
			month = "fall";
		}
		
        // swtich( ).. case ... break; 제어문에서
        // break;를 제거하면 멈추지 않고 다음 명령이 실행되는 특성을 이용
		switch (month) {
			case("12") : {
			}
			case("1") : {
			}
			case("2") : {
				month = "winter";
				break;
			}
			case("3") : {
			}
			case("4") : {
			}			
			case("5") : {
				month = "spring";
				break;
			}
			case("6") : {
			}
			case("7") : {
			}
			case("8") : {
				month = "summer";
				break;
			}
			case("9") : {
			}
			case("10") : {
			}
			case("11") : {
				month = "fall";
				break;
			}
		}
		System.out.print(month);
	}
}
