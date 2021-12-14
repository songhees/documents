package example_10_06_01_collection;

import java.util.HashSet;

public class HashSample1 {
	public static void main(String[] args) {
		// 문자열을 여러 개 담는 배열을 저장하기
		String[] array = new String[5];
		// 배열에 데이터(객체)를 저장할 때는 인덱스를 계속 바꿔가면서 데이터를 저장한다.
		array[0] = "이순신";
		array[1] = "김유신";
		array[2] = "강감찬";
		array[3] = "류관순";
		array[4] = "안중근";
//		array[5] = "김구";		// 오류, 배열의 인덱스범위를 초과했다. 배열은 자동으로 크기가 증가되지 않는다.
		
		// 배열에 저장된 데이터(객체) 출력하기
		System.out.println("### 애국지사 이름 출력하기");
		for(String name : array) {
			System.out.println("애국지사 이름: " + name);
		}
		
		// 문자열을 여러 개 담는 Hashset객체를 생성하기
		HashSet<String> set = new HashSet<>();
		// HashSet객체에 데이터(객체)를 저장할 때는 add(E e)메소드를 실행해서 데이터를 저장한다.
		// 배열보다 쉽게 데이터를 저장할 수 있다.
		// 저장공간이 부족하면 자동으로 저장공간을 늘린다.
		set.add("김수영");		
		set.add("김윤주");		
		set.add("김민수");		
		set.add("김사월");		
		set.add("김담소");		
		set.add("서자영");		
		set.add("치즈");
		set.add("옙");
		set.add("수박");
		
		// HashSet<E>에 저장된 데이터(객체) 출력하기
		System.out.println("### 이름 출력하기");
		for(String name : set) {
			System.out.println("이름: " + name);
		}
		
	}
}
