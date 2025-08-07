package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data1 = br.readLine();
        String data2 = br.readLine();
        String data3 = br.readLine();

        int target = 0;

        if (isNum(data3)) {
            target = Integer.parseInt(data3)+1;
        } else if (isNum(data2)) {
            target = Integer.parseInt(data2)+2;
        } else if (isNum(data1)) {
            target = Integer.parseInt(data1)+3;
        }

        String result = "";
        if (target%3 == 0) {
            result += "Fizz";
        }

        if (target%5 == 0) {
            result += "Buzz";
        }

        System.out.println(result.isEmpty() ? target : result);
        br.close();
    }

    public static boolean isNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
