package example_10_14_copy;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileCopy2 {
	public static void main(String[] args) throws IOException {
		// 업로드 과정
		URL url = new URL("https://blogfiles.pstatic.net/MjAyMTA5MTFfMjE3/MDAxNjMxMzU4OTgxMzcz.4QjaA4SrGq3rj2Ho1uJslr5p5zrENv3Zmsx0cA0jmPUg.LUkCafdLXVtMZhCYBWKxNC4p6Um0Wi3hDRhhWd3WBt4g.JPEG.keiuyen130/bts-cover-1629338650671904064976.jpg");
		InputStream in = url.openStream();
		
		// 복사본파일로 1byte씩 출력하는 스트림객체 생성
		FileOutputStream out = new FileOutputStream("c:/temp/doc/방탄사진.jpg");
		
		int value = 0;
		while ((value = in.read()) != -1) {
			out.write(value);
		}
		in.close();
		out.close();
	}
}
