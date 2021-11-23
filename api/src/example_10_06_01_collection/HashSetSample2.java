package example_10_06_01_collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetSample2 {
	public static void main(String[] args) {
		
		// HashSet<E>의 주요 API사용하기
		// HashSet<E>의 부모 인터페이스 Set<E>에는 Set.of() 정적메소드가 있다.
		// Set<E> Set.of()				: Set 구현객체를 생성한다.
		// Set<E> Set.of(E e)			: 객체가 하나 저장된 Set 구현객체를 생성한다.
		// Set<E> Set.of(E e, E e)		: 객체가 두개 저장된 Set 구현객체를 생성한다.
		// Set<E> Set.of(E e, ... E e)	: 객체가 여러개 저장된 Set 구현객체(HashSet or TreeSet)를 생성한다.
		Set<String> names = Set.of("김수", "서자영", "김사월", "김윤주");
		// Set참조변수			Set의 구현객체 형성
		HashSet<String> set = new HashSet<>();
		
		// boolean add(E e) : 지정된 객체를 HashSet객체에 저장한다. 저장이 성공하면 true를 반환한다.
		set.add("김수영");
		set.add("서자영");
		set.add("김수영");	// 이미 "김수영"이 HashSet에 존재하기 때문에 저장되지 않는다. 중복을 허용하지 않음
		set.add("김수영");	// 이미 "김수영"이 HashSet에 존재하기 때문에 저장되지 않는다.
		
		// boolean isEmpty() : HashSet<E>이 비어있으면 true를 반환한다.
		System.out.println("HashSet<E> 객체가 비어있는가? " + set.isEmpty()); // false
		
		// 	void clear() : HashSet<E>에 저장된 모든 객체를 삭제한다.
		// set.clear();
		System.out.println("HashSet<E> 객체가 비어있는가? " + set.isEmpty()); // true
		
		// String toString() : HashSet<E>는 Object의 toString() 메소드를 재정의했다.
		//					   HashSet<E>는 저장된 객체의 toString()을 실행한다.
		
		// boolean addAll(Collection<? extends E//==(String)//> collection) : 다른 Collection구현객체에 저장된 데이터(객체)를 전부 저장한다. 
		// 				  Collection<? extends E>는 Collection구현객체가 E나 E의 하위타입을 저장하고 있어야 된다.
		//				  E는 addAll()메소드를 호출하는 객체의 타입입파리미터를 따른다.
		//				  우리가 생성한 객체는 HashSet<String>이기 때문에 E는 String이다.
		//				  따라서, Collection<String>, Set<String>, List<String>, HashSet<String>,
		//				  		 ArrayList<String>, Vector<String>, LinkedList<String>, Stack<String>이 가능하다.
		set.addAll(names);
		System.out.println(set.toString());
		
		// int size() : HashSet<E>객체에 저장된 객체의 갯수를 반환한다.
		System.out.println("저장된 객체의 수: " + set.size());
		
		// boolean contain(Object e) : HashSet<E>객체에 지정된 객체가 존재하면 true를 반환한다.
		System.out.println("\"치즈\"라는 이름의 사람이 존재하는 가? " + set.contains("치즈"));
		System.out.println("\"서자영\"라는 이름의 사람이 존재하는 가? " + set.contains("서자영"));
		
		// boolean remove(Object e) : HashSet<E>객체에 지정된 객체가 존재하면 삭제하고 true를 반환한다.
		set.remove("서자영");
		System.out.println("삭제 후 저장된 객체의 수: " + set.size());
		
		
		System.out.println(set);
	}
}
