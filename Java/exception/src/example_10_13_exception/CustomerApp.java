package example_10_13_exception;

import java.util.Scanner;

import example_10_13_exception.ExampleSample4.CustomException;

public class CustomerApp {
	Scanner scan = new Scanner(System.in);
	CustomerService service = new CustomerService();
	
	public void menu() {
		
		try {
			System.out.println("----------------------------------------------------------");
			if (service.isLogined()) {
				System.out.println("3.로그아웃 0.종류");
			} else {
				System.out.println("1.로그인 2.회원가입 0.종료");
			}
			System.out.println("----------------------------------------------------------");
			System.out.print("### 메뉴 선택: ");
			int menuNo = scan.nextInt();
			
			if (menuNo == 1) {
				login();
			} else if (menuNo == 2) {
				newCustomer();
			} else if (menuNo == 3) {
				logout();
			} else if (menuNo == 0) {
				logout();
			}
		} catch (CustomException ex) {
			System.out.println("### 오류 메세지: " + ex.getMessage());
		}
		menu();
	}
	
	void login () {
		System.out.println("[로그인]");
		System.out.println("### 로그인할 회원 아이디 입력: ");
		String id = scan.next();
		System.out.println("### 로그인할 회원 비밀번호 입력: ");
		String password = scan.next();
		
		service.login(id, password);
		System.out.println("### 로그인이 완료되었습니다.");
	}
	
	void newCustomer() {
		System.out.println("[회원가입]");
		System.out.println("### 가입할 회원 아이디 입력: ");
		String id = scan.next();
		System.out.println("### 가입할 회원 비밀번호 입력: ");
		String password = scan.next();
		System.out.println("### 가입할 회원 이름 입력: ");
		String name = scan.next();
		
		service.registerUser(new Customer(id, password, name)); // 예외가 던져지는 메소드
		System.out.println("### 회원가입이 완료되었습니다.");
	}
	
	void logout() {
		System.out.println("[로그아웃]");
		service.logout();
	}
	
	void exists() {
		System.out.println("[프로그램 종료]");
		
	}
	
	
	public static void main(String[] args) {
		CustomerApp app = new CustomerApp();
		app.menu();
		
	}
}
