package example_10_08_exception;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionSample3 {
	
	// 예외처리를 위임하기
	// 1. new FileWriter(), write(), flush(), close() 메소드가 IOException의 처리를 writeText()에게 위임함
	// 2. writeText()메소드는 IOException의 처리를 main() 에게 위임함
	// 3. main() 메소드는 IOException의 처리를 JVM에게 위임함 
	// * JVM에게 예외처리를 위임하는 것은 예외처리를 하지 않은 것과 동일하다. -> 프로그램이 꺼짐
	public static void main(String[] args) throws IOException  {
		// 떠넘겨짐
		FileUtils.writeText("c:/temp/java/abc.text", "예외 떠넘기기 연습입니다.");
		
	}
	
	static class FileUtils{
		
		// 이 메소드에서 예외를 처리할 책임이 없어진다.
		// writeText() 메소드를 호출하는 측에서는 IOException 예외를 처리해야 한다.
		public static void writeText(String path, String text) throws IOException {
			FileWriter writer = new FileWriter(path);
			writer.write(text);
			writer.flush();
			writer.close();
			System.out.println("### 정상 실행 : 파일에 기록되었습니다.");
		}
	}
}
