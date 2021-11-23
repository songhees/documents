package example_10_15_object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectOutputStreamSample {
	public static void main(String[] args) {
		
		/*
		 * ObjectOutputStream
		 * 		- 객체를 직렬화시키고 출력하는 스트림이다.
		 * 		- 직렬화는 객체를 스트림으로 출력가능한 상태로 변환하는 것을 말한다.
		 * 		- 직렬화는 생성된 객체의 클래스명, 멤버변수의 이름과 타입, 멤버변수에 저장된 값을 스트림으로 출력하는 것이다. 하나씩 내보내는것
		 */
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/temp/doc/objcet.sav"));) {
			
			User user = new User();
			user.setId("hong");
			user.setName("ㅎ");
			user.setPassword("zxcv1234");
			user.setPoint(35000);
			user.setCreatedDate(new Date());
			
			user.setCar(new Car("제네시스", "현대", 80000000L));
			// 생성된 User객체를 직렬화해서 스트림으로 출력하기
			oos.writeObject(user);
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
