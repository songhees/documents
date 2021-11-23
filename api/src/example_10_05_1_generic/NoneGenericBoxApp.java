package example_10_05_1_generic;

public class NoneGenericBoxApp {
	public static void main(String[] args) {
		// Food객체를 여러개 저장하는 NoneGenericBox 객체 생성
		NoneGenericBox foodBox = new NoneGenericBox();
		
		// 생성된 NoneGenericBox객체에 Food객체 저장하기
		Food food1 = new Food("토마토", 5000);
		Food food2 = new Food("고등어", 12000);
		Food food3 = new Food("치킨", 20000);
		
		foodBox.addItem(food1); // 저장될 때 Object 타입으로 클래스 형변환이 된다.
		foodBox.addItem(food2);	// 저장될 때 Object 타입으로 클래스 형변환이 된다.
		foodBox.addItem(food3);	// 저장될 때 Object 타입으로 클래스 형변환이 된다.
		
		Contact contact = new Contact("홍길동", "010-1111-2222", "삼성전자");
		foodBox.addItem(contact); // 생성된 Box객체에 Food객체와 다른 객체가 저장해도 오류가 발생하기 않는다.(타입 안전성이 보장되지 않음.)
								  // 오류가 나야 되는데 오류가 나지 않음 // 정상동작함, Food객체가 아닌 객체도 저장이 된다.
		// NoneGenericBox 객체에 저장된 Food객체 가져오기
		// Object 객체의 주소값이 반환됨
		// Object getItem(int index) {...}이 실행됨
		Object obj1 = foodBox.getItem(0);
		Object obj2 = foodBox.getItem(1);
		Object obj3 = foodBox.getItem(2);
		
		// Food 타입으로 가젱 형변환한다. 형변환연산자를 꼭 사용해야 한다.
		Food saveFood1 = (Food)obj1;
		Food saveFood2 = (Food)obj2;
		Food saveFood3 = (Food)obj3;
		
		System.out.println(saveFood1.getName() + ", " + saveFood1.getPrice());
		System.out.println(saveFood2.getName() + ", " + saveFood2.getPrice());
		System.out.println(saveFood3.getName() + ", " + saveFood3.getPrice());
	}
}
