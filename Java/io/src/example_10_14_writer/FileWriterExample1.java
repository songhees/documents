package example_10_14_writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample1 {
	public static void main(String[] args) {
		
		/*
		 * FileWriter
		 * 		파일에 텍스트를 기록(출력)한다.
		 */
		try {
			// example.txt 파일에 텍스트를 기록하는 FileWriter객체를 생성함
			// example.txt 파일이 존재하지 않으면 example.txt 파일을 생성한 다음 텍스트를 기록한다.
			// example.txt 파일이 존재하면 새로 example.txt 파일을 생성하지 않고, 기존 데이터에 덮어쓴다.
			FileWriter writer = new FileWriter("c:/temp/doc/example1.txt");
			
			writer.write("아에이오우\n");
			writer.write("아에이오우\n");
			writer.write("아에이오우\n");
			writer.write("아에이오우\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
