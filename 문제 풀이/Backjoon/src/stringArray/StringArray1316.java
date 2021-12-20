package stringArray;
import java.util.Scanner;
 
public class StringArray1316 {
 
	static Scanner scan = new Scanner(System.in);
 
	public static void main(String[] args) {
		
		int num = scan.nextInt();
		
		int group = 0;
		int count = 0;
		while (count != num) {
			
			String words = scan.next();

			boolean inValid = true;
			for (int i=0; i<words.length(); i++) {
				String c = words.substring(i, i+1);
				
				if (words.indexOf(c, i+1) == -1) {
					continue;
				} else if (words.indexOf(c, i+1) == i+1) {
					continue;
				} else if (words.indexOf(c, i+1) != i+1) {
					inValid = false;
					break;
				}  
			}
			if (inValid) {
				group++;
			}
			count++;
		}
		System.out.println(group);
	}
}