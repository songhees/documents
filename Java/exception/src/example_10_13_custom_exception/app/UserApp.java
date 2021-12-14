package example_10_13_custom_exception.app;

import java.util.Scanner;

import example_10_13_custom_exception.exception.HtaException;
import example_10_13_custom_exception.service.UserService;
import example_10_13_custom_exception.vo.User;

public class UserApp {
	// 하나의 메소드안에서 너무 많은 일을 하지 않게 하고 코드를 변경/수정시 찾기 쉽게하기 위해서
	// 기능마다 메소드 단위로 나눠서 다시 구현한다. 
	// 사용자의 키보드 입력을 읽어오는 객체
	Scanner scan = new Scanner(System.in);
	// 사용자와 관련된 업무로직이 구현되어 있는 객체
	UserService userService = new UserService();

	public void displayMenu() {
		try {
			System.out.println("------------------------------------------------");
			if (userService.isLogined()) {
				System.out.println("3.내 정보보기 4.로그아웃 0.종료");
			} else {
				System.out.println("1.로그인 2.회원가입 0.종료");
			}
			System.out.println("------------------------------------------------");
			
			System.out.println("### 메뉴를 선택하세요.");
			int menuNo = scan.nextInt();
			
			if (menuNo == 1) {
				로그인하기();
			} else if (menuNo == 2) { 
				회원가입하기();
			} else if (menuNo == 3) { 
				내정보보기();
			} else if (menuNo == 4) { 
				로그아웃하기();
			} else if (menuNo == 0) {
				종료하기();
			}
		} catch (HtaException ex) {
			System.out.println("### [오류 발생] " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("### [오류 발생] 알 수 없는 오류가 발생하였습니다.");
		}
		System.out.println();
		displayMenu(); // while문이 없어도 반복호출이 된다.
	}
	
	private void 로그인하기() {
		System.out.println("[로그인]");
		
		// 사용자와 상호작용하기
		System.out.println("### 아이디와 비밀번호를 입력하세요.");
		System.out.println("### 아이디 입력: ");
		String id = scan.next();
		System.out.println("### 비밀번호 입력: ");
		String password = scan.next();
		
		// 업무로직 실행
		userService.login(id, password);
		// 사용자 화면에 처리결과 표시하기
		System.out.println("### [처리 성공] 로그인 처리가 완료되었습니다.");
	}
	private void 회원가입하기() {
		System.out.println("[회원가입하기]");
		
		// 사용자와 상호작용하기
		System.out.println("### 아이디, 비밀번호, 이름을 입력하세요.");
		System.out.println("### 아이디 입력: ");
		String id = scan.next();
		System.out.println("### 비밀번호 입력: ");
		String password = scan.next();
		System.out.println("### 이름 입력: ");
		String name = scan.next();
		
		// 업무로직 실행
		userService.registerUser(new User(id, password, name));
		
		// 사용자 화면에 처리결과 표시하기
		System.out.println("### [처리 성공] 회원가입이 완료되었습니다.");
	}
	
	private void 내정보보기() {
		System.out.println("[내 정보 보기]");
		
	}
		
	private void 로그아웃하기() {
		userService.logout();
		System.out.println("### [처리 성공] 로그아웃이 완료되었습니다.");
	}
	
	private void 종료하기() {
		System.out.println("[프로그램 종료]");
		System.out.println("### 프로그램을 종료합니다.");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		// 사용자와 상호작용하는  UserApp객체 생성
		UserApp app = new UserApp();
		// UserApp의 기능중에서 메뉴 표시하기 기능실행
		app.displayMenu();
		
	}
}
