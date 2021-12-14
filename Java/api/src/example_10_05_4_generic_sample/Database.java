package example_10_05_4_generic_sample;

import java.lang.reflect.Array;

public class Database<T> {

	private T[] items;
	private int position = 0;
	
	public Database(Class<T[]> clazz) {
		items = clazz.cast(Array.newInstance(clazz.getComponentType(), 100));  
	}
	
	/**
	 * 아이템(책, 티켓, 사용자, 주문정보) 등록한다.
	 * @param item 책, 티켓, 사용자, 주문정보
	 */
	public void addItem(T item) {
		items[position] = item;
		position++;
	}
	
	/**
	 * 모든 아이템정보를 반환한다.
	 * @return 이 데이터베이스 객체에 등록된 모든 아이템정보
	 */
	public T[] getAllItems() {
		return (T[])items;
	}
	
	/**
	 * 지정된 번호의 아이템을 찾아서 반환한다.
	 * @param no 상품번호
	 * @return 책, 티켓, 사용자, 주문정보
	 */
	@SuppressWarnings("unchecked")
	public T getItem(int no) {
		Product product = null;
		for (Object obj : items) {
			if (obj == null) {
				break;
			}
			Product item = (Product)obj;
			if (item.getNo() == no) {
				product = item;
			}
		}
		return (T)product;
	}
	
	/**
	 * 변경된 아이템정보를 전달받아서 데이터베이스에 반영한다.
	 * @param item 변경된 아이템정보
	 */
	public void updateItem(T item) {
		
	}
	
	/**
	 * 지정된 번호의 아이템을 데이터베이스에서 삭제한다.
	 * @param no
	 */
	public void deleteItem(int no) {
		
	}
}

