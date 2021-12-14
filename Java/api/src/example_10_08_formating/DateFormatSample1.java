package example_10_08_formating;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatSample1 {
	public static void main(String[] args) {
		// 시스템의 현재 날짜와 시간정보를 포함하고 있는 Date객체 생성
		Date date = new Date();
		
		System.out.println("### Date객체의 toString() 메소드가 반환하는 문자열 출력하기");
		System.out.println(date);
		
		// Date를 지정된 패턴의 문자열로 바꾸기
		System.out.println("Date에 포함된 날자를 형식화된 텍스트로 변환하기");
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		
		// Date에 포함된 날짜와 시간정보를 "2010-10-08" 형식으로 포맷팅하는 패턴을 적용하기
		sdf1.applyPattern("yyyy-MM-dd");
		String dateText1 = sdf1.format(date);
		System.out.println("[yyyy-MM-dd] " +dateText1);
		
		sdf1.applyPattern("yyyy년 M월 d일 EEEE");
		String dateText2 = sdf1.format(date);
		System.out.println("[yyyy년 M월 d일 EEEE]"+ dateText2);
		
		sdf1.applyPattern("HH:mm:ss");
		String dateText3 = sdf1.format(date);
		System.out.println("[HH:mm:ss]" + dateText3);
		
		sdf1.applyPattern("a h시 m분 s초");
		
		sdf1.applyPattern("yy년 M월 d일 EEEE a h시 m분 s초");
		String dateText5 = sdf1.format(date);
		System.out.println("[yy년 M월 d일 EEEE a h시 m분 s초] "+ dateText5);
		
	}
}
