package example_10_15_object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamSample {
	public static void main(String[] args) {
		
		/*
		 * ObjectIntputStream
		 * 		- 직렬화된 객체를 읽어와서 역직렬화하는 스트림이다.
		 * 		- 역직렬화는 직렬화된 객체 정보를 읽어서 객체를 생성하고, 멤버변수 값도 복원하는 것이다.
		 */
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/temp/doc/objcet.sav"))){
			// object.sav 파일에 직렬화된 객체정보를 읽어서 역직렬화(객체로 복원) 한다.
			User user = (User)ois.readObject(); // Object타입 
			
			System.out.println("아이디: " + user.getId());
			System.out.println("비밀번호: " + user.getPassword());
			System.out.println("자동차명: " + user.getCar().getName());
			System.out.println("가입일: " + user.getCreatedDate());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
