package example_10_05_4_generic_sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {
	
	//private Database<Book> books = new Database<>(Book[].class);
	//private Database<Ticket> tickets = new Database<>(Ticket[].class);
	private Set<Book> books = new HashSet<>();
	private Set<Ticket> tickets = new HashSet<>();
	private Set<User> users = new HashSet<>();
	private List<Order> orders = new ArrayList<>();
	//private Database<User> users = new Database<>();
	//private Database<Order> orderDatabase = new Database<>();
	
	// 주문번호를 제공하는 객체를 생성한다.
	// sequence.getAndIncrement(); 메소드를 실행하면 10000번부터 순서대로 번호를 제공한다.
	private AtomicInteger sequence = new AtomicInteger(10000);
	
	// loginUsers는 로그인과정을 통과한 사용자 정보가 저장되는 Map객체다.
	// loginUsers Map객체에는 로그인한 사람의 아이디(String)와 그 사람의 정보(User)가 저장된다.
	// 로그인된 사용자의 정보를 저장하는 변수
	private User loginUsers;
	
	public Store() {
		books.add(new Book(101, "이것이 자바다", "신용권", "컴퓨터", 35000));
		books.add(new Book(102, "자바의 정석편", "남궁성", "컴퓨터", 30000));
		books.add(new Book(103, "해커스토익보카", "해커스", "외국어", 28000));
		books.add(new Book(104, "깃허브 입문편", "홍길동", "컴퓨터", 25000));
		books.add(new Book(105, "자바코딩 인터뷰", "이창협", "컴퓨터", 38000));
		
		tickets.add(new Ticket(201, "김수영 공연", "2021-10-15", 66000));
		tickets.add(new Ticket(202, "선우정아 공연", "2021-10-17", 55000));
		tickets.add(new Ticket(203, "옥상달빛 공연", "2021-10-25", 44000));
		tickets.add(new Ticket(204, "담소네공방 공연", "2021-10-28", 66000));
		tickets.add(new Ticket(205, "스웨덴세탁소 공연", "2021-10-31", 44000));
		
		users.add(new User("홍길동", "hong", "zxcv1234"));
		users.add(new User("김유신", "yousin", "zxcv1234"));
		users.add(new User("강감찬", "kang", "zxcv1234"));
		users.add(new User("이순신", "sunshin", "zxcv1234"));
		
		orders.add(new Order(sequence.getAndIncrement(), "hong", "도서", 101, 1, "결재완료"));
		orders.add(new Order(sequence.getAndIncrement(), "hong", "도서", 103, 2, "결재완료"));
		orders.add(new Order(sequence.getAndIncrement(), "youshin", "티켓", 201, 2, "결재완료"));
		orders.add(new Order(sequence.getAndIncrement(), "kang", "도서", 104, 2, "결재완료"));
		orders.add(new Order(sequence.getAndIncrement(), "kang", "티켓", 202, 4, "결재완료"));
	}
	
	// 모든 책 정보를 출력하는 기능
	public void displayAllBooks() {
		for (Book book : books) {
			System.out.println("번호 " + book.getNo());
			System.out.println("이름 " + book.getName());
			System.out.println("작가 " + book.getWriter());
			System.out.println("장르 " + book.getGenre());
			System.out.println("가격 " + book.getPrice());
			System.out.println("재고 " + book.getStock());
			System.out.println();
		}
	}

	// 책정보를 책의 상세정보를 출력하는 기능
	public void displayBookDetail(int bookNo) {
		Book foundBook = null;
		for(Book book : books) {
			if (book.getNo() == bookNo) {
				foundBook = book;
				break;
			}
		}
		if (foundBook == null) {
			System.out.println("### 오류 : 책정보를 찾을 수 없습니다.");
			return;
		}
		System.out.println("번호 " + foundBook.getNo());
		System.out.println("이름 " + foundBook.getName());
		System.out.println("작가 " + foundBook.getWriter());
		System.out.println("장르 " + foundBook.getGenre());
		System.out.println("가격 " + foundBook.getPrice());
		System.out.println("재고 " + foundBook.getStock());
		System.out.println();
	}
	
	// 책 구매하기
	public void orderBook(int bookNumber,int amount) {
		Book foundBook = null;
		for(Book book : books) {
			if (book.getNo()==bookNumber) {
				foundBook = book;
			}
		}
		if (foundBook == null) {
			System.err.println("존재하지 않는 책 번호입니다.");
			return;
		}
		if (foundBook.getStock()==0) {
			System.err.println("재고가 없습니다.");
			return;
		}
		
		Order order = new Order();
		order.setNo(sequence.getAndIncrement());
		order.setUserId(loginUsers.getUserId());
		order.setProductType("도서");
		order.setProductNo(bookNumber);
		order.setOrderDate(new Date());
		order.setStatus("결재완료");
		order.setAmount(amount);
		
		orders.add(order);
		foundBook.setStock(foundBook.getStock()-1);
		loginUsers.setPoint(loginUsers.getPoint() + foundBook.getPrice()/100);
	}
	
	
	// 모든 티켓정보를 출력하는 기능
	public void displayAllTickets() {
		for (Ticket ticket : tickets) {
			System.out.println("번호: " + ticket.getNo());
			System.out.println("이름: " + ticket.getName());
			System.out.println("가격: " + ticket.getPrice());
			System.out.println("여유좌석: " + ticket.getStock());
			System.out.println();
		}
	}

	// 티켓 상세정보를 출력하는 기능
	public void displayTicketDetail(int ticketNo) {
		
		Ticket foundTicket = null;
		for (Ticket ticket : tickets) {
			if (ticket.getNo() == ticketNo) {
				foundTicket = ticket;
				break;
			}
		}
		if (foundTicket == null) {
			System.err.println("### 오류 : 티켓정보가 존재하지 않습니다.");
			return;
		}
		System.out.println("번호 " + foundTicket.getNo());
		System.out.println("이름 " + foundTicket.getName());
		System.out.println("가격 " + foundTicket.getPrice());
		System.out.println("재고 " + foundTicket.getStock());
		System.out.println();
	}
	
	// 티켓 예매하기
	public void orderTicket(int ticketNumber,int amount) {
		Ticket foundTicket = null;
		for(Ticket ticket : tickets) {
			if (ticket.getNo() == ticketNumber) {
				foundTicket = ticket;
			}
		}
		if (foundTicket == null) {
			System.err.println("존재하지 않는 티켓 번호입니다.");
			return;
		}
		if (foundTicket.getStock()==0) {
			System.err.println("재고가 없습니다.");
			return;
		}
		
		Order order = new Order();
		order.setNo(sequence.getAndIncrement());
		order.setUserId(loginUsers.getUserId());
		order.setProductType("티켓");
		order.setProductNo(ticketNumber);
		order.setOrderDate(new Date());
		order.setStatus("결재완료");
		order.setAmount(amount);
		
		orders.add(order);
		foundTicket.setStock(foundTicket.getStock()-1);
		loginUsers.setPoint(loginUsers.getPoint() + foundTicket.getPrice()/100);
	}
	
	
	
	// 회원 가입 기능
	// 아이디가 동일한 사용자는 가입될 수 없다.
	public void signUp(User user) {
		boolean isSuccess = users.add(user);
		if (isSuccess) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.err.println("### 오류 : 동일한 아이디를 가진 사용자가 이미 존재합니다.");
		}
	}
	
	// 회원 탈퇴 기능
	// HashSet에서 사용자정보를 삭제한다.
	public void exit(String id, String password) {
		User savedUser = this.findUserById(id);
		if (savedUser == null) {
			System.err.println("### 오류 : 사용자정보를 찾을 수 없습니다.");
			return;
		}
		if (!savedUser.getPassword().equals(password)) {
			System.err.println("### 오류 : 비밀번호가 일치하지 않습니다.");
			return;
		}
		
		users.remove(savedUser);
		// 탈퇴했으면 로그아웃
		logout();
		System.out.println("### 사용자 정보가 삭제되었습니다.");
		// 이미 hash랑 equals를 재정의하였으므로 remove가 된다.
		
//		Iterator<User> iter = users.iterator();
//		while(iter.hasNext()) {
//			User data = iter.next();
//			if (data == savedUser) {
//				iter.remove();
//			}
//		}
		
//		Iterator<User> iter = users.iterator();
//		while(iter.hasNext()) {
//			User data = iter.next();
//			if (data.getUserId().equals(id) && data.getPassword().equals(password)) {
//				iter.remove();
//				System.out.println("회원탈퇴가 완료되었습니다.");
//				return;
//			}
//		}
//		System.out.println("맞지않는 회원정보입니다.");
	}
	
	
	// 로그인 기능
	public void login(String id, String password) {
		User savedUser = findUserById(id);
		if (savedUser == null) {
			System.err.println("### 오류 : 사용자정보를 찾을 수 없습니다.");
			return;
		}
		if (!savedUser.getPassword().equals(password)) {
			System.err.println("### 오류 : 비밀번호가 일치하지 않습니다.");
			return;
		}
		loginUsers = savedUser;
		System.out.println("### 로그인이 완료되었습니다.");
	}
	
	// 로그아웃 기능
	public void logout() {
		loginUsers = null;
		System.out.println("### 로그아웃이 완료되었습니다.");
	}
	
	// 내정보보기
	public void printMyInfo() {
		if (loginUsers==null) {
			System.err.println("### 오류: 로그인을 하십시오.");
			return;
		}
		System.out.println("아이디\t이름\t잔여포인트");
		System.out.print(loginUsers.getUserId() + "\t");
		System.out.print(loginUsers.getUsername() + "\t");
		System.out.print(loginUsers.getPoint() + "\t");
	}
	
	// 주문내역보는 메소드
	public void displayMyOrders() {
		if (!isLogined()) {
			System.out.println("### 오류: 로그인을 하십시오.");
			return;
		}
		Order findOrder = null;
		for(Order order : orders) {
			if (order.getUserId().equals(loginUsers.getUserId())) {
				findOrder = order;
				System.out.println("주문번호: " + findOrder.getNo());
				System.out.println("주문자아이디: " + findOrder.getUserId());
				System.out.println("주문상품: " + findOrder.getProductType());
				System.out.println("상품번호: " + findOrder.getProductNo());
				System.out.println("수량: " + findOrder.getAmount());
				System.out.println("주문상태: " + findOrder.getStatus());
				System.out.println("주문일자: " + findOrder.getOrderDate());
				System.out.println("주문취소일자: " + findOrder.getCancelDate());
				System.out.println();
			}
		}
		if(findOrder==null) {
			System.out.println("주문정보가 존재하지 않습니다.");
			return;
		}
	}
	
	
	// 주문 취소 메소드
	public void cancelOrder(int no) {
		if (!isLogined()) {
			System.out.println("### 오류: 로그인을 하십시오.");
			return;
		}
		Order findOrder = null;
		for (Order order : orders) {
			if(order.getNo()==no) {
				findOrder = order;
			}
		}
		if (findOrder==null) {
			System.err.println("오류: 주문 정보가 존재하지 않습니다.");
			return;
		}
		
		if (!findOrder.getUserId().equals(loginUsers.getUserId())) {
			System.err.println("### 오류: 같은 아이디가 아닙니다.");
			return;
		}
		if ("주문취소".equals(findOrder.getStatus())) {
			System.out.println("이미 취소된 주문입니다.");
		}
		
		findOrder.setStatus("주문취소");
		findOrder.setCancelDate(new Date());

		Product findProduct = null;
		for(Book book : books) {
			if(book.getNo()==findOrder.getProductNo()) {
				findProduct = book;
			}
		}
		for(Ticket ticket : tickets) {
			if(ticket.getNo()==findOrder.getProductNo()) {
				findProduct = ticket;
			}
		}
		
		int point = (findProduct.getPrice()*findOrder.getAmount())/100;
		User user = findUserById(findOrder.getUserId());
		user.setPoint(user.getPoint()-point);
		findProduct.setStock(findProduct.getStock()+1);
		
		orders.remove(findOrder);
		System.out.println("주문이 취소되었습니다.");
		
	}
	
	
	//로그인 여부를 반환하는 메소드
	public boolean isLogined() {
		return loginUsers != null;
	}
	
	
	private User findUserById(String userId) {
		for (User user : users) {
			if (user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
}
