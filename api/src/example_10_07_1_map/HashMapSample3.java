package example_10_07_1_map;

import java.util.HashMap;
import java.util.Map;

public class HashMapSample3 {
	public static void main(String[] args) {
		// Map을 사용하지 않은 경우
		System.out.println("### EventService1에서 Map을 사용하지 않은 경우");
		EventService1 service1 = new EventService1();
		service1.sendEventMessage("가을 신상품 할인 행사 진행!!", "SMS");
		service1.sendEventMessage("카톡 채널가입시 할인쿠폰 지급!!", "KAKAOTALK");
		
		// Map을 사용하는 경우
		System.out.println("### EventService2에서 Map을 사용하는 경우");
		EventService2 service2 = new EventService2();
		service2.sendEventMessage("가을 신상품 할인 행사 진행!!", "SMS");
		service2.sendEventMessage("카톡 채널가입시 할인쿠폰 지급!!", "KAKAOTALK");
	}
	
	static class EventService1 {
		// 무조건 두개 다 써야되므로 interface로 받지 않는다.
		SmsSender sms = new SmsSender();
		KakaoTalkSender kakao = new KakaoTalkSender();
		
		// senderType에 따라서 메세지를 전송하는 Sender를 고르는 if ~ else if 문이 필요하다.
		public void sendEventMessage(String message, String senderType) {
			// 상수값이 있을 때 상수값.equals(객체)를 한다. 객체가 null인 경우를 피하기 위해서
			if ("SMS".equals(senderType)) {
				sms.sendMessage(message);
			} else if ("KAKAOTALK".equals(senderType)) {
				kakao.sendMessage(message);
			}
		}
	}
	
	static class EventService2 {
		Map<String, Sender> senderMap = new HashMap<>();
		
		public EventService2() {
			senderMap.put("SMS", new SmsSender());
			senderMap.put("KAKOTALK", new KakaoTalkSender());
		}
		
		// 각종 Sender구현객체를 각각 SMS와 KAKAOTALK을 키로 SmsSender와 KakaoTalkSender를 Map에 저장한다.
		// key값으로 사용할 Sender를 고를 수 있다.
		public void sendEventMessage(String message, String senderType) {
			Sender sender = senderMap.get(senderType);
			sender.sendMessage(message);
		}
		
	}
	
	static interface Sender {
		void sendMessage(String message);
		
	}
	
	static class SmsSender implements Sender {
		@Override
		public void sendMessage(String message) {
			System.out.println("[SMS 메세지 발송]" + message);
		}
	}
	
	static class KakaoTalkSender implements Sender {
		@Override
		public void sendMessage(String message) {
			System.out.println("[카카오톡 메세지 발송]" + message);
		}
	}
}
