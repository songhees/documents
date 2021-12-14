package example_09_09_constructor;

public class Sample2App {
	public static void main(String[] args) {
		
		Sample2 sample = new Sample2();
		
		boolean value1 = sample.isEvenNumber(100);
		boolean value2 = sample.isEvenNumber(15);
		System.out.println(value1);
		System.out.println(value2);
		System.out.println();
		
		int[] numbers1 = {10, 20, 30, 40, 50};
		int[] numbers2 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15}; 
		int value3 = sample.getTotal(numbers1);
		int value4 = sample.getTotal(numbers2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println();
		
		int value5 = sample.getMaxNumber(new int[] {5, 0, 6, 4, 9, 8});
		int value6 = sample.getMaxNumber(numbers2);
		System.out.println("최대값" + value5);
		System.out.println("최대값" + value6);
		System.out.println();
		
		int[] numbers3 = {3, 6, 9, 2, 56, 8, 12};
		boolean value7 = sample.isExist(numbers3, 4);
		boolean value8 = sample.isExist(numbers1, 100);
		System.out.println("존재하는가? " + value7);
		System.out.println("존재하는가? " + value8);
		System.out.println();
		
		sample.printGugudan(81);
		System.out.println();
		
		boolean value9 = sample.averageScore(100, 90, 80);
		boolean value10 = sample.averageScore(50, 40, 60);
		System.out.println("통과여부: " + value9);
		System.out.println("통과여부: " + value10);
		System.out.println();
		
		sample.printNumber(9);
	}
}
