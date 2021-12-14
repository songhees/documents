package example_11_2_transaction.service;

import java.sql.Connection;
import java.sql.SQLException;

import example_11_2_transaction.dao.CustomerDao;
import example_11_2_transaction.dao.FoodDao;
import example_11_2_transaction.dao.OrderDao;
import example_11_2_transaction.vo.Customer;
import example_11_2_transaction.vo.Food;
import example_11_2_transaction.vo.Order;
import example_11_2_transaction.vo.OrderItem;
import utils.ConnectionUtil;

public class FoodService {
	
	private CustomerDao customerDao = new CustomerDao();
	private FoodDao foodDao = new FoodDao();
	private OrderDao orderDao = new OrderDao();
	
	public void order(int customerNo, int foodNo, int amount) {
		// 코드의 오류 부분을 확인 하기 위한 디버깅 사용을 위해 vo객체에 toString을 모두 정의하는게 좋다.
		// sql문을 먼저 developer에서 실행해보고 자바에 사용한다.
		Connection connection = null;
		try {																			// 새로운 트랜잭션 시작
			connection = ConnectionUtil.getConnection(); // 기능그룹을 설정하기 위해서는 connection을 따로 만들어야 한다.
			connection.setAutoCommit(false); // 오토 커밋 기능 꺼버림 직접 커밋과 롤백을 해야 됨
			/*
			 * 자바는 기본적으로 connection.setAutoCommit(ture);이다. insert되자 마자 commit을 한다.
			 * 따라서 부분 오류가 일어남. 음식을 주문할 때 식품의 수량보다 더 초과하는 주문일 경우
			 * 코드에 따라서 주문 정보는 저장되지만 그 후에 주문식품정보의 정보는 오류가 생기므로 저장하지 못학게 된다.
			 * 즉 주문 정보는 있지만 그에 따른 어떤 식품을 주문했는지 알지 못하는 코드의 일관성이 떨어지게 된다.
			 */
			
			// 1. food_seq 시퀀스에서 주문번호 획득하기 - select
			int orderNo = orderDao.selectOrderNo(connection);							// 트랜잭션안에서 조회작업 실행
			
			// 2. 식품번호에 해당하는 식품정보를 조회한다. - select
			Food food = foodDao.selectFood(foodNo, connection);							// 트랜잭션안에서 조회작업 실행
			
			// 2. 고객번호에 해당하는 고객정보를 조회한다.
			Customer customer = customerDao.selectCustomer(customerNo, connection);		// 트랜잭션안에서 조회작업 실행
			
			// 3. Order객체를 생성하고, 주문정보(주문번호, 주문자, 총구매금액)을 저장하고, tb_sample_food_orders 테이블에 //저장시킨다. - insert
			Order order = new Order();
			order.setNo(orderNo);								// 주문번호 저장
			order.setCustomer(customer);						// 고객정보가 포함된 Customer객체 저장
			order.setTotalPrice(food.getPrice()*amount);		// 총구매가격 저장
			orderDao.insertOrder(order, connection);			// 주문정보 테이블에 저장	// 트랜잭션안에서 저장작업 실행
			
			// 4. OrderItem객체를 생성하고, 주문상품정보(주문번호, 식품번호, 구매수량)을 저장하고, 테이블에 //저장시킨다. - insert
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderNo(orderNo);						// 주문번호 저장
			orderItem.setFood(food);							// 주문식품번호를 포함하고 있는 Food객체 저장
			orderItem.setAmount(amount);						// 주문수량 저장

			orderDao.insertOrderItem(orderItem, connection);	// 주문식품정보 데이블에 저장	// 트랜잭션안에서 저장작업 실행
			
			// 5. 총구매금액의 1%에 해당하는 포인트를 계산한다.
			int depositPoint = (int)(food.getPrice()*amount*0.01);
			
			// 6. 조회된 고객정보의 포인트를 변경하고 테이블에 //저장시킨다. - update
			customer.setPoint(depositPoint + customer.getPoint());		// 업데이트 할 때 : 업데이트 전 정보를 조회 업데이트할 내용만 바꿔치기하고 DB에 저장
			customerDao.updateCustomer(customer, connection);			// 포인트가 변경된 고객정보를 업데이트한다.	// 트랜잭션안에서 변경작업 실행
			
			// 7. 식품정보의 재고를 구매수량만큼 감소시키고, 테이블에 //저장시킨다. - update
			food.setStock(food.getStock() - amount);
			foodDao.updateFood(food, connection);				// 구매수량만큼 재고가 변경된 식품정보를 업데이트한다.	// 트랜잭션안에서 변경작업 실행
			
			// 8. 모든 데이터베이스 엑세스 작업이 오류없이 완료되면 수행했던 모든 작업을 데이터 베이스에 반영시킨다.
			connection.commit();															// 트랜잭션안에서 실행했던 작업을 DB에 반영
			
		} catch (SQLException e) {
			// 9. 데이터베이스 엑세스 작업중 오류가 발생하면 수행했던 모든 작업의 데이터베이스 반영을 취소한다.
			try {
				connection.rollback();														// 트랜잭션안에서 실행했던 작업을 전부 취소
																							// 트랜잭션 종료
			} catch (SQLException ex) {
			
			}
			throw new RuntimeException("데이터베이스 엑세스 작업 오류", e);
		} finally {
			// 정상종료/오류 발생과 상관없이 무조건 실행해야 하는 코드를 작성하는 곳이다.
			// 주로, 사용했던 리소스를 반환하는 코드가 위치한다.
			// 자원을 반납하는 코드
			try {
				// 10. 데이터베이스와 연결된 커넥션을 닫는다.
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
	}
	
	
	
}
