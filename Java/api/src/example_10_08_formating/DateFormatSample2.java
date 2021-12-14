package example_10_08_formating;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatSample2 {
	public static void main(String[] args) throws ParseException {
		
		Date today = new Date();
		
		String text1 = "1997-04-04";
		// parse할 text와 똑같은 패턴을 지정해준다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = sdf.parse(text1);
		// 사용자가 입력한 날짜를 잘못된 입력을 했을때 어떻게 처리할 것 인가? ex) 13월
		//사용자의 실수나 시스템 문제로 오류나 연결이 끊어질때 어떻게 처리할 건지 코드에 명시해 놔야된다.
		// 사용자의 실수나 시스템 문제로 오류가 발생할 가능성이
		// 있는 메소드의 경우 ParseException라는 예외 객체(오류정보를 담고 있는)를 생성해서 던진다.
		// 예외 객체를 사용한 메소드(main)에 던져진다.
		// 되던지는것 = 종료(throws) 예외가 발생하면 그 예외를 catch하는 구문을 적는것(try catch) 
		
		long todayUnixTime = today.getTime();
		long birthdayUnixTime = birthday.getTime();
		
		long day = (todayUnixTime-birthdayUnixTime)/(60*60*24*1000);
		
		System.out.println(day);
		
		
	}
}
