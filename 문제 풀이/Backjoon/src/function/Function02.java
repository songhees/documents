package function;

public class Function02 {
	public static void main(String[] args) {
		int[] a = new int[10000];

		for (int i = 0; i < 10000; i++) {
			int c = self(i+1);
			if (c < 10001) {
				a[i] = c;
			}
		}
			
		int b = 1;
		while (b<9999) {
			boolean q = false;
			for (int i = 0; i < 10000; i++) {
				if(b == a[i]) {
					q = true;
				} 
			}
			if(q == false) {
				System.out.println(b);
			}
			b++;
		}
		
	}
	public static int self(int num) {
		int selfNum = num;
		while(num>0) {
			selfNum += num%10;
			num /= 10;
		}
		return selfNum;
	}
}
