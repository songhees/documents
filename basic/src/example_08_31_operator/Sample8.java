package example_08_31_operator;

public class Sample8 {
	public static void main(String[] args) {
		/*
		 * 비교연산자와 논리연산자로 연산결과 판정하기
		 * 논리연산자는 다른연산자 보다 우선순위가 낮다
		 * 자동차 유상수리여부 판정하기
		 * 판정기준 : 운행거리가 50000km이상인 경우 유상수리, 운행기간이 3년 이상인 경우 유상수리다.
		 * or
		 */
		int standardDistance = 50000;
		int standardPeriod = 3;
		int distance = 35000;
		int period = 2;
		
		boolean 유상수리판정결과 = (distance >= standardDistance) || (period >= standardPeriod);
		System.out.println("유상수리 여부: " + 유상수리판정결과);   //false
				
		 /* 고객 사은품 지급여부 판정하기
		 * 판정기준 : 적립포인트가 1백만점 이상이고, 오늘 구매금액이 50만원 이상인 경우 사은품을 지급한다.
		 * and
		 */
		int standardPoint = 1_000_000;
		int standardPrice = 500_000;
		int point = 1_500_000;
		int price = 750_000;
		
		boolean 사은품지급여부판정결과 = (point >= standardPoint) && (price >= standardPrice);
		System.out.println("사은품 지급여부: " + 사은품지급여부판정결과);  //true
		
		 /* 정회원 등업기준
		 * 판정기준 : 방문획수가 50회 이상이고, 댓글작성 갯수가 10개 이상인 경우 혹은 10만원 후원한 경우 정회원으로 등업한다.
		 * and !
		 */
		int standardVisit = 50;
		int standardComment = 10;
		int standardDonation = 100_00;
		int totalVisit = 60;
		int totalComment = 15;
		int donation = 200_000;
		
		boolean result = ((totalVisit >= standardVisit) && (totalComment >= standardComment)) || (donation >= standardDonation);
		System.out.println("정회원 등업 여부: " + result); 			//true
	}
}
