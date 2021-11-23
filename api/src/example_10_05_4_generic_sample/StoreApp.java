package example_10_05_4_generic_sample;

import java.util.Scanner;

public class StoreApp {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 도서목록 출력, 도서 상세정보 출력, 모든 티켓정보 출력, 티켓상세정보 출력 기능을 제공하는 객체 생성
		Store store = new Store();
		
		while(true) {
			boolean isLogined = store.isLogined();
			
			System.out.println("----------------------------------------------------");
			System.out.println("1.도서메뉴  2.티켓메뉴  3.사용자메뉴  0.종료");
			System.out.println("----------------------------------------------------");
			
			System.out.print("[메뉴선택]: ");
			int topLevelMenu = scan.nextInt();
			System.out.println();
			
			if (topLevelMenu == 1) {
				
				System.out.println("[도서 메뉴]");
				System.out.println("----------------------------------------------------");
				if (isLogined) {
					System.out.println("1.도서목록  2.도서상세정보  3.주문하기");
				} else {
					System.out.println("1.도서목록  2.도서상세정보");
				}
				System.out.println("----------------------------------------------------");

				System.out.print("[도서메뉴 선택]: ");
				int subLevelMenuNo = scan.nextInt();
				System.out.println();
				
				if (subLevelMenuNo == 1) {
					System.out.println("[도서 목록]");
					store.displayAllBooks();
					
				} else if (subLevelMenuNo == 2) {
					System.out.println("[도서 상세정보]");
					
					System.out.print("도서 번호 입력: ");
					int bookNo = scan.nextInt();
					
					store.displayBookDetail(bookNo);
					
				} else if (subLevelMenuNo == 3) {
					if (!isLogined) {
						System.err.println("### 오류 : 로그인 후 이용가능한 서비스 입니다.");
						continue;
					}
					System.out.println("[도서 주문하기]");
					
					System.out.println("주문할 도서 번호입력: ");
					int bookNumber = scan.nextInt();
					System.out.println("주문할 도서 수량입력: ");
					int amount = scan.nextInt();
					
					store.orderBook(bookNumber,amount);
				}
				
				
			} else if (topLevelMenu == 2) {
				System.out.println("[티켓 메뉴]");				
				System.out.println("----------------------------------------------------");
				if (isLogined) {
					System.out.println("1.티켓목록  2.타켓상세정보  3.예매하기");
				} else {
					System.out.println("1.티켓목록  2.타켓상세정보");
				}
				System.out.println("----------------------------------------------------");
				
				System.out.print("[티켓메뉴 선택]: ");
				int subLevelMenuNo = scan.nextInt();
				System.out.println();
				
				if (subLevelMenuNo == 1) {
					System.out.println("[티켓 목록]");
					store.displayAllBooks();
					
				} else if (subLevelMenuNo == 2) {
					
					System.out.println("[티켓 상세정보]");
					
					System.out.print("티켓 번호 입력: ");
					int ticketNo = scan.nextInt();
					
					store.displayTicketDetail(ticketNo);
					
				} else if (subLevelMenuNo == 3) {
					if(!isLogined) {
						System.err.println("### 오류 : 로그인 후 이용가능한 서비스 입니다.");
						continue;
					}
					System.err.println("[티켓 예매하기]");
					
					System.out.println("주문할 티켓 번호입력: ");
					int ticketNumber = scan.nextInt();
					System.out.println("주문할 티켓 수량입력: ");
					int amount = scan.nextInt();
					
					store.orderTicket(ticketNumber,amount);
				}
				
				
				
				
					
			} else if (topLevelMenu == 3) {
				System.out.println("[사용자 메뉴]");
				
				System.out.println("----------------------------------------------------------");
				if (isLogined) {
					System.out.println("1.로그인  2.회원가입 3.로그아웃 4.탈퇴하기 5.주문내역보기 6.주문취소하기 7.내정보보기");
				} else {
					System.out.println("1.로그인  2.회원가입");
				}
				System.out.println("----------------------------------------------------------");

				System.out.print("[사용자메뉴 선택]: ");
				int subLevelMenuNo = scan.nextInt();
				System.out.println();
				
				if (subLevelMenuNo == 1) {
					System.out.println("[로그인]");
					
					System.out.print("사용자 아이디입력: ");
					String id = scan.next();					
					System.out.print("사용자 비밀번호입력: ");
					String password = scan.next();
					
					System.out.println();					
					store.login(id, password);
					
					
				} else if (subLevelMenuNo == 2) {
					System.out.println("[회원가입]");
					
					System.out.print("사용자 이름입력: ");
					String name = scan.next();
					System.out.print("사용자 아이디입력: ");
					String id = scan.next();					
					System.out.print("사용자 비밀번호입력: ");
					String password = scan.next();					
					System.out.println();					
					store.signUp(new User(name, id, password));

					
				} else if (subLevelMenuNo == 3) {
					if(!isLogined) {
						continue;
					}
					System.out.println("[로그아웃]");
					
					store.logout();
					
				} else if (subLevelMenuNo == 4) {
					if(!isLogined) {
						continue;
					}
					System.out.println("[탈퇴하기]");
					
					System.out.print("사용자 아이디입력: ");
					String id = scan.next();					
					System.out.print("사용자 비밀번호입력: ");
					String password = scan.next();	
					System.out.println();					
					store.exit(id, password);
					
				} else if (subLevelMenuNo == 5) {
					if(!isLogined) {
						continue;
					}
					System.out.println("[주문내역보기]");
					store.displayMyOrders();
					
				} else if (subLevelMenuNo == 6) {
					if(!isLogined) {
						continue;
					}
					System.out.println("[주문취소하기]");
					
					System.out.println("주문번호 입력: ");
					int no = scan.nextInt();
					store.cancelOrder(no);
					
				} else if (subLevelMenuNo == 7) {
					if(!isLogined) {
						continue;
					}
					System.out.println("[내 정보 보기]");
					System.out.println();					
					
					store.printMyInfo();
					
					
				}
				
			} else if (topLevelMenu == 0) {
				System.out.println("[애플리케이션 종료]");
				break;
			}
			System.out.println();
			System.out.println();
		}
		scan.close();
	}
}
