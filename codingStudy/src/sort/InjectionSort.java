package sort;

public class InjectionSort {
	public static void main(String[] args) {
		int temp = 0;
		int j = 0;
		int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		
		for (int i=0; i<9; i++) {
			j = i;
			// j+1의 값이 기준이다!
			while (array[j] > array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
			}
		}
		
		for(int i : array) {
			System.out.println(i);
		}
	}
}
