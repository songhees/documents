package example_10_21_store.service;
/**
 * 상품관리 기능을 제공하는 서비스 인터페이스다.
 * @author song
 *
 */

import java.sql.SQLException;
import java.util.List;

import example_10_21_store.vo.Product;

public interface ProdcutService {
	
	/**
	 * 
	 * @return 상품정보 리스트
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	List<Product> getAllProducts() throws SQLException;
	
	/**
	 * 지정된 상품번호에 대한 상품상세정보를 반환한다.
	 * @param productNo 상품번호
	 * @return 상품상세정보
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	Product getProductDetail(int productNo) throws SQLException;
	
	/**
	 * 지정된 상품정보를 등록한다.<br/>
	 * 동일한 이름의 상품정보가 존재하면 해당 상품의 재고량을 증가시킨다.
	 * @param product 등록할 상품정보
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	void addNewProduct(Product product) throws SQLException;
	
	/**
	 * 지정된 정보로 상품의 가격을 수정한다.
	 * @param productNo 상품번호
	 * @param price 수정된 상품가격
	 * @param discountPrice 수정된 할인가격
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	void updateProductPrice(int productNo, int price, int discountPrice)throws SQLException;
	
	/**
	 * 지정된 상품번호에 해당하는 상품정보를 삭제한다.
	 * @param productNo 삭제할 상품의 번호
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	void removeProduct(int productNo) throws SQLException;
	
	/**
	 * 지정된 카테고리에 해당하는 상품정보들 반환한다.
	 * @param category 조회할 상품의 카테고리
	 * @return 지정된 카테고리의 상품정보 목록
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	List<Product> searchProductsByCategory(String category) throws SQLException;
	
	/**
	 * 지정된 키워드가 상품명에 포함된 상품정보를 반환한다.
	 * @param keyword 검색어
	 * @return 상품정보 목록
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	List<Product> searchProductsByName(String keyword) throws SQLException;
	
	/**
	 * 지정된 가격범위에 해당하는 상품정보들 반환한다
	 * @param minPrice 최소가격
	 * @param maxPrice 최대가격
	 * @return 상품정보 목록
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	List<Product> searchProductsByPrice(int minPrice, int maxPrice) throws SQLException;
	
	/**
	 * 지정된 재고량 보다 적은 상품정보들 반환한다
	 * @param minStock 최소 재고량
	 * @return 상품정보 목록
	 * @throws SQLException DB Access 오류시 예외가 발생한다.
	 */
	List<Product> searchLowerStockProducts(int minStock) throws SQLException;
}
