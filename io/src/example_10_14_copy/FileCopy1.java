package example_10_14_copy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy1 {
	public static void main(String[] args) throws IOException {
		
		// 원본파일을 1byte씩 읽어오는 스트림 객체 생성
		FileInputStream in = new FileInputStream("c:/temp/doc/DdZiiuvUQAI2sJe.jfif");
		// 복사본파일을 생성하고 1byte씩 출력하는 스트림 객체 생성
		FileOutputStream out = new FileOutputStream("c:/temp/doc/DdZiiuvUQAI2sJe복사본.jfif");
		
		// 1byte씩 읽은 값을 저장하는 변수
		int value = 0;
		// 1byte씩 읽어서 value에 저장하고, value에 저장된 값이 -1이 나올 때 까지 수행문 반복
		while((value = in.read()) != -1){
			// value에 저장된 값을 복사본파일에 저장
			out.write(value);
		}
				
		in.close();
		out.close();
		
	}
}
