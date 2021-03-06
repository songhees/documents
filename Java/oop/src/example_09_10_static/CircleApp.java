package example_09_10_static;

public class CircleApp {
	public static void main(String[] args) {
		
		/*
		 *  정적변수는 클래스이름.변수명으로 사용한다.
		 *  객체 생성없이도 사용가능하다.
		 */
		System.out.println(Circle.PI);		// 클래스 저장공간에 있는 클래스변수 PI를 호출
		
		// 정적변수 중에서 final 키워드를 붙여서 상수로 만든 것은 한번 정해진 값을 변경할 수 없다.
		// Circle.PI = 3.14;	// 오류, 값을 변경할 수 없다.
		
		Circle circle1 = new Circle(5);
		Circle circle2 = new Circle(10);
		Circle circle3 = new Circle(15);
		Circle circle4 = new Circle(20);
		Circle circle5 = new Circle(25);
		
		System.out.println("반지름 5인 원의 넓이: " + circle1.getArea());
		System.out.println("반지름 10인 원의 넓이: " + circle2.getArea());
		System.out.println("반지름 15인 원의 넓이: " + circle3.getArea());
		System.out.println("반지름 20인 원의 넓이: " + circle4.getArea());
		System.out.println("반지름 25인 원의 넓이: " + circle5.getArea());
		
		
	}
	
}
