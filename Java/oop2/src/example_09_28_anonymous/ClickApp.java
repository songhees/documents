package example_09_28_anonymous;

public class ClickApp {
	public static void main(String[] args) {
		
		Click homeButtonClick = new Click() {
			public void actionPerformed() {
				System.out.println("홈페이지를 표시합니다.");
			}
		};
		
		Click preButtonClick = new Click() {
			public void actionPerformed() {
				System.out.println("이전 페이지를 표시합니다.");
			}
		};
		
		Click nextButtonClick = new Click() {
			public void actionPerformed() {
				System.out.println("다음 페이지를 표시합니다.");
			}
		};
		
		Click ne = new Click() {
			public void actionPerformed() {
				System.out.println("호");
			}
		};

	}
}
