package sort;
/**
 * ���� ����
 * @author song
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		int temp = 0;
		
		int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<9-i; j++) {
				if (array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		for (int ar : array) {
			System.out.println(ar);
		}
		
	}
}
