package question;

/**
 * ★★★★★
 * 배열에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1을 아니면 0을 반환하는 함수 구하기
 * @author song
 *
 */
public class Q0X01import {
	// 각 수의 등장 여부를 체크하는 배열 만들기
	// 100이 되는 수의 존재여부를 O(N)이 아닌 O(1)에서 알아 차리게 해야
	// O(N)인 해결책을 찾을 수 있다.
	public static void main(String[] args) {
		int[] array = {1, 23, 53, 77, 60};
		System.out.println(func2(array));
		
	}
	
	static int func2(int[] arr) {
		int[] num = new int[99]; // 1부터 99까지의 짝의 존재 여부를 저장하는 배열 생성
		int result = 0;
		
		for (int i=0; i<arr.length; i++) {
			// 배열의 값과 합이 100이되는 값의 index에 해당하는 num배열에 값이 0이면 짝이 없음이고 1이면 짝이 있음이다.
			// index의 값으로 바로 index값을 확인해서 짝여부를 판단하므로 전체적인 시간복잡도는 O(N)이다.
			int tar = 100-arr[i];
			if (num[tar-1] != 1) {
				num[arr[i]-1]++;
			} else {
				result = 1;
				break;
			}
		}
		return result;
	}
}
