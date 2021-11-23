package example_10_08_exception;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionSample1 {
	public static void main(String[] args) {
		//파일을 기록하는 객체
		// 입출력 예외 IOException
		try {
			FileWriter writer = new FileWriter("c:/temp/java/test.txt");
			writer.write("중앙HTA 2106기 화이팅!!!");
			// 객체는 메모리안에서 생겨나고 사라진다 메모리에서 cpu가 실행되므로 실행속도가 빠르다.
			//
			// 객체에서 저장된 buffer에 있는 것들을 다 파일로 보낸다.
			// 
			
			writer.flush();
			// 
			writer.close();
			System.out.println("### 정상 실행 : 파일에 기록되었습니다.");
			// 에외 발생과 관련된 정보와 수행문이 들어 있는 예외 객체가 생성
		} catch (IOException ex) {
			// 오류 안내문
			System.out.println("### 오류 발생 : 파일 생성 중 오류가 발생하였습니다.");
			// 예외 객체의 메소드를 통해
			// 오류 발생시 오류 수정을 위한 디버깅 정보를 화면에 출력한다.
			//모든 예외 클래스가 가지고 있는 메소드
			ex.printStackTrace();
			
			// 예외 클래스 확인과 메세지 확인
			// 예외는 맨 위에서 아래로 내가 만든 class의 이름이 나오면
			// 어느 수행문인지 본다. 내가 수정할 수 있는 부분이다.
			// 예외는 30분 안에 해결할 수 없으면 물어본다.
		}
		
		
	}
}
