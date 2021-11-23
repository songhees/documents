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

public class service {
	private CustomerDao customerDao = new CustomerDao();
	private FoodDao foodDao = new FoodDao();
	private OrderDao orderDao = new OrderDao();
	
	public void order(int customerNo, int foodNo, int amount) throws SQLException {
		// 코드의 오류 부분을 확인 하기 위한 디버깅 사용을 위해 vo객체에 toString을 모두 정의하는게 좋다.
		// sql문을 먼저 developer에서 실행해보고 자바에 사용한다.
		Connection connection = null;
		try {											
			connection = ConnectionUtil.getConnection(); 
			connection.setAutoCommit(false); 
			
			// 1. 주문받기
			int orderNo = orderDao.selectOrderNo(connection); //주문번호 받기
			
			// 2. 어떤 음식인가
			Food food = new Food();
			food = foodDao.selectFood(foodNo, connection);
			
			// 3. 주문 등록하기
			Order order = new Order();
			
			Customer customer = new Customer();
			customer.setNo(customerNo);
			order.setCustomer(customer);
			
			order.setNo(orderNo);
			int totalPrice = amount*food.getPrice();
			order.setTotalPrice(totalPrice);
			
			orderDao.insertOrder(order, connection);
			
			// 4. 주문식품 등록
			OrderItem item = new OrderItem();
			item.setAmount(amount);
			item.setFood(food);
			item.setOrderNo(orderNo);
			
			orderDao.insertOrderItem(item, connection);
			
			// 5. 주문된 음식 수 만큼 재고 수정하기
			food.setStock(food.getStock() - amount);
			foodDao.updateFood(food, connection);
			
			// 6. 고객의 포인트 올리기
			customer = customerDao.selectCustomer(customerNo, connection);
			customer.setPoint((int)(totalPrice*0.01) + customer.getPoint());
			customerDao.updateCustomer(customer, connection);
			
			connection.commit();
			
		} catch (SQLException e) {
			connection.rollback();
		}
	}
}
