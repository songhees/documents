package implementation.sliver;

import java.io.*;
import java.util.*;


public class Q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] croatia = new String[]{"c=", "c-", "d-", "lj", "nj", "s=", "z="};

        String target = br.readLine();

        int count = 0;
        purpose : for(int i=0; i<target.length(); i++) {
            if (target.length()-i >= 3 
                && "dz=".equals(target.substring(i, i+3))) {
                    count++;
                    i += 2;
            } else if (target.length()-i >= 2) {
                for (String cro : croatia) {
                    if (cro.equals(target.substring(i, i+2))) {
                        count++;
                        i++;
                        continue purpose;
                    }
                }
                count++;
            } else {
                count++;
            }
        }
        System.out.print(count);
    }
}
