package example_10_13_exception;

import java.util.ArrayList;
import java.util.List;


public class CustomerService {
	private List<Customer> list = new ArrayList<Customer>();
	private Customer login;
	
	/**
	 * 새 사용자 정보를 등록하는 기능이다. <br/>
	 * 같은 아이디를 사용하는 사용자가 존재하는 경우, 예외를 발생시킨다. 
	 * @param user 새 사용자 정보
	 */
	public void registerUser(Customer cus) {
		Customer save = getCustomer(cus.getId());
		
		if (save != null) {
			throw new CustomerNotFoundException("같은 아이디가 존재합니다.");
		}
		list.add(cus);
		System.out.println("완료되었습니다.");
	}
	
	/**
	 * 아이디와 비밀번호를 전달받아서 로그인처리를 수행한다. <br/>
	 * 아이디 혹은 비밀번호가 올바르지 못한 경우, 예외를 발생시킨다.
	 * @param id 아이디
	 * @param password 비밀번호
	 */
	public void login(String id, String password) {
		Customer save = getCustomer(id);
		if (save == null) {
			throw new CustomerNotFoundException("사용자정보가 존재하지 않습니다.");
		}
		if (!password.equals(save.getPassword())) {
			throw new CustomerNotFoundException("틀린 비밀번호입니다.");
		}
		login = save;
		System.out.println("완료되었습니다.");
	}
	

	public void logout() {
		login = null;
	}
	
	/**
	 * 현재 로그인 여부를 반환한다.
	 * @return loginUser가 null이 아니면 true를 반환한다.
	 */
	public boolean isLogined() {
		return login != null;
	}
	
	public Customer getCustomer(String id) {
		Customer save = null;
		for (Customer cus : list) {
			if (id.equals(cus.getId())) {
				return cus;
			}
		}
		return save;
	}
	
}
