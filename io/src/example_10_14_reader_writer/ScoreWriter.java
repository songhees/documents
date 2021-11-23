package example_10_14_reader_writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ScoreWriter {
	public static void main(String[] args) {
		List<Score> scoreList = new ArrayList<Score>();
		scoreList.add(new Score("홍길동", 100, 100, 100));
		scoreList.add(new Score("김유신", 90, 70, 80));
		scoreList.add(new Score("이순신", 60, 70, 70));
		scoreList.add(new Score("강감찬", 80, 70, 70));
		scoreList.add(new Score("류관순", 100, 90, 90));
		
		
		
		// List객체에 저장된 삭생성적 정보를 score.save 파일로 저장하기
		// 괄호안에 적으면 auto로 close가 된다.
		// 메모리 누수를 자동으로 방지해 준다.
		try (PrintWriter writer = new PrintWriter("c:/temp/doc/score.sav");){
			StringBuilder sb  = new StringBuilder();
			for (Score score : scoreList) {
				sb.append(score.getName() + ",");
				sb.append(score.getKor() + ",");
				sb.append(score.getEng() + ",");
				sb.append(score.getMath());
				
				writer.println(sb.toString());
				// StringBuilder에 있던 데이터를 0의 길이로 만들어 지워버린다.
				sb.setLength(0);
				
				
			}
			
			
			// 자원누수방지
//			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
