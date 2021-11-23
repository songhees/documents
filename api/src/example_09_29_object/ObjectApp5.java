package example_09_29_object;


public class ObjectApp5 extends Student implements Cloneable{
	public static void main(String[] args) throws CloneNotSupportedException {
		Person original = new Person("홍길동", "010-1111-1111", "hong@gmail.com");
		Person clonePerson = original.copy();
		
		// 원본객체와 복제된 객체의 정보를 확인해보면, 해시코드값이 다르다.
		// 즉, 원본객체와 복제된 객체는 서로 다른 객체임을 알 수 있다.
		System.out.println("원본객체: " + original);			//ObjectApp5$Person@7d6f77cc
		System.out.println("복제된 객체: " + clonePerson);		//ObjectApp5$Person@5aaa6d82
		
		System.out.println("복제된 객체 확인하기");
		System.out.println(clonePerson.name);
		System.out.println(clonePerson.tel);
		System.out.println(clonePerson.email);

	}
//Person은 오브젝트의 자손이기 때문에 클론 메소드를 사용할 수 있다. 
// Person라는 객체에 대해서 클론하는것이고 실행하는 것은 App안에서 실행하는 것이므로
//App안에서 clone을 하면 App를 복제하는 꼴이기 때문에 바로 사용이 불가능하다 내가 복제할려는게 복제할 객체안에서 만 복제 가능
	//정적 내부 클래스
	static class Person implements Cloneable{
		String name;
		String tel;
		String email;
		
		public Person(String name, String tel, String email) {
			super();
			this.name = name;
			this.tel = tel;
			this.email = email;
		}
		
		// 객체의 복제본을 제공하는 메소드다.
		public Person copy() throws CloneNotSupportedException {
			Person person =(Person)this.clone();
			return person;
		}
		
		
	}
}


//