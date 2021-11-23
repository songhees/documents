package example_10_01_system;

import java.util.Date;

public class SystemApp2 {
	public static void main(String[] args) {
		
		// 시스템의 유닉스타임을 조회하기
		long unixTime = System.currentTimeMillis();
		System.out.println("유닉스 타임: " + unixTime);
		// 유닉스 타임을 이용해서 url을 계속 새로운 것을 가져온다.
		// 파일 앞에 유닉스 타임을 붙여서
		// 똑같은 파일이름이 존재하지 않으므로 중복처리되지 않을 수 있다
		// 매번 다른 값을 출력하므로
		// 1633059112280내사진.jpg 	Sns에서 같은 이름으로 올려도 저장되는 파일이 다르다.
		// 1633059112780내사진.jpg	유닉스 타임으로 인해 중복으로 처리되지 않는다.
		
		// 시스템의 현재 날짜와 시간정보를 제공하는 객체 생성하기
		Date now = new Date();
		System.out.println(now);// toString이 재정의되어 있다.
		// now 객체가 만들어지는 순간의 시스템의 날짜와 시간정보를 가지고있다.
		
		Date day = new Date(0);		// 현재 날짜와 시간만 필요할 경우 사용
		System.out.println(day);	// 유닉스타임이 출력되는데 영국이 유닉스 타임이 0시일때 한국이 9시이므로 9가 나온다.
									// Date에는 날짜와 시간 관련된 연산이 없다.
		// 날짜와 시간정보를 제공하는 객체 java.util.Date
		// 날짜정보를 제공하는 객체 java.sql.Date
		// 시간정보를 제공하는 객체 java.sql.Timestamp
		//java.time 패키지에는 날짜 시간 연산의 라이브러리가 있다
		// 날짜정보를 제공하는 객체 java.time.LocalDate	//Local == 지역
		// 시간정보를 제공하는 객체 java.time.LocalTime
		// 날짜와 시간정보를 제공하는 객체 java.time.LocalDateTime
	}
}
