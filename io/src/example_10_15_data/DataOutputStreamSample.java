package example_10_15_data;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamSample {
	public static void main(String[] args) {
		
		/*
		 * DataOutputStream
		 * 		기본자료형 및 문자열을 타입과 값 그대로 출력하는 스트림이다.
		 */
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("c:/temp/doc/data.sav"));) {
			
			dos.writeInt(100);				// 번호
			dos.writeUTF("자바의 정석");		// 제목
			dos.writeInt(35000);			// 가격
			dos.writeDouble(0.03);			// 할인율
			dos.writeBoolean(false);		// 매진여부
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
