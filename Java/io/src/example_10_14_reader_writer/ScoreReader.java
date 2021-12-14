package example_10_14_reader_writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreReader {
	public static void main(String[] args) {
		
		// 행 하나가 객체 하나에 해당하다.
		// score.sav 파일에서 읽어온 성적정보를 저장하는 ArrayList객체
		List<Score> scores = new ArrayList<Score>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader("c:/temp/doc/score.sav"));){
			String text = null;
			while ((text = reader.readLine()) != null) {
				// text -> "홍길동,100,100,100"
				// values -> ["홍길동", "100", "100", "100"]
				String[] values = text.split(",");
				// 배열의 값 분석하기
				String name = values[0];
				int kor = Integer.parseInt(values[1]);
				int eng = Integer.parseInt(values[2]);
				int math = Integer.parseInt(values[3]);
				
				// Score객체를 생성해서 분석된 성적정보를 저장하기
				scores.add(new Score(name, kor, eng, math));
				
				System.out.println(scores);
			}
			
			// 데이터 조작/분석하기
			// 학생들의 전체 평균점수 계산하기
			int totalAverage = 0;
			for (Score score : scores) {
				totalAverage += score.getAverage();
			}
			System.out.println("전체 평균점수: " + totalAverage/scores.size()+ "점");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
