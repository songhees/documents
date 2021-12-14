package example_09_23_Interface;
/**
 * Reporter을 구현하는 객체
 * 엑셀로 data를 출력하는 객체
 * @author 오송희
 *
 */
public class ExcelReporter implements Reporter {
	/**
	 * 출력할 정보를 설정한다.
	 */
	private String title;
	private String[] columns;
	private String[] data;
	/**
	 * 출력할 정보를 생성자로 부터 초기화한다.
	 * @param title
	 * @param columns
	 * @param data
	 */
	public ExcelReporter(String title, String[] columns, String[] data) {
		this.title = title;
		this.columns = columns;
		this.data = data;
	}
	/**
	 * 생성자로 부터 초기화된 data를 출력하는 재정의된 메소드
	 */
	@Override
	public void printReport() {
		// 제목 표시
		System.out.println("[ " + title + " ]");
		
		// 칼럼명 표시
		for(String column : columns) {
			System.out.print(column + "\t");
		}
		System.out.println();
		
		// 데이터 표시
		for(String value : data) {
			System.out.print(value + "\t");
		}
		System.out.println();
	}
}
