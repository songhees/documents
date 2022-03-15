package dataStructure;

import java.util.Arrays;

/**
 * 특정 index의 값 삭제 추가하기
 * @author song
 *
 */
public class Array {
	public static void main(String[] args) {
		ArrayInfo info = new ArrayInfo();
		insert(3, 60, info);
		erase(4, info);
	}
	
	// 배열에 값 추가하기
	static void insert(int index, int num, ArrayInfo info) {
		int len = info.len;
		
		int[] arry = new int[7];
		for (int i=0; i<len; i++) {
			arry[i] = info.array[i];
		}
		for (int i = 0; i<index; i++) {
			arry[len-i] = arry[len-(i+1)];
		}
		arry[index] = num;
		System.out.println(Arrays.toString(arry));
		
		info.len = 7;
		info.array = arry;
	}
	
	// 배열에 값 지우기
	static void erase(int index, ArrayInfo info) {
		int len = info.len;
		int[] array = info.array;
		System.out.println(len);
		for (int i =index; i<len-1; i++) {
			array[i] = array[i+1];
		}
		array[len-1] = 0;
		System.out.println(Arrays.toString(array));
		
		info.array = array;
	}
}

class ArrayInfo {
	int[] array = {10, 50, 40, 30, 70, 20};
	int len = 6;
}
