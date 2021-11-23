package example_09_16_polymorphism;

public class NewsServiceApp {
	public static void main(String[] args) {
		Messenger messenger1 = new Messenger();
		KakaoTalkMessenger messenger2 = new KakaoTalkMessenger("홍길동", "고양이 사진");
		EmailMessenger messenger3 = new EmailMessenger("admin", "zxcv1234");
		
		NewsService service = new NewsService();
		service.setMessenger(messenger2);
		service.boadcastNews("010-1111-1111", "011-2222-2222", "코로나가 종식되었습니다.");
		
		
	}
}
