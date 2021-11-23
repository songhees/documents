package example_10_05_1_generic;

public class GenericBoxApp2 {
	public static void main(String[] args) {
		
		GenericBox<Contact> contactBox = new GenericBox<>();
		
		Contact contact1 = new Contact("홍길동", "010-1234-5678", "삼성전자");
		Contact contact2 = new Contact("김유신", "010-1234-0001", "LG전자");
		Contact contact3 = new Contact("이순신", "010-1234-0005", "쿠팡");
		
		// void addItems(T item){...}이
		// void addItems(Contact item){...}으로 실행된다. 타입안전성이 보장됨
		contactBox.addItems(contact1);
		contactBox.addItems(contact2);
		contactBox.addItems(contact3);
		
		// T getItem(int index) {...}이
		// Contact getItem(int index) {...}으로 실행된다. 형변환 연산자 필요없음
		Contact savedContact1 = contactBox.getItem(0);
		Contact savedContact2 = contactBox.getItem(1);
		Contact savedContact3 = contactBox.getItem(2);
		
		System.out.println(savedContact1.getName() + ", " + savedContact1.getTel() + ", " + savedContact1.getCompany());
		System.out.println(savedContact2.getName() + ", " + savedContact2.getTel() + ", " + savedContact2.getCompany());
		System.out.println(savedContact3.getName() + ", " + savedContact3.getTel() + ", " + savedContact3.getCompany());
	}
}
