package example_09_23_Interface;
/**
 * 차트로 data 출력을 하는 구현 클래스
 * @author 오송희
 *
 */
public class ChartReporter implements Reporter {
	
	/**
	 * 어떤 data를 출력할건지 설정
	 */
	private String title;
	private String[] columnLables;
	private int[] values;
	
	/**
	 * 생성자로 부터 초기화하여 data를 받는다.
	 * @param title
	 * @param columnLables 각 차트 이름
	 * @param values 각 차트 크기
	 */
	public ChartReporter(String title, String[] columnLables,int[] values) {
		this.title = title;
		this.columnLables = columnLables;
		this.values = values;
	}
	
	/**
	 * 받은 data를 출력하는 재정의 하는 메소드
	 */
	@Override
	public void printReport() {
		System.out.println("[ " + title + " ]\n");
		
		for ( int index = 0; index < columnLables.length; index++) {
			System.out.print(columnLables[index] + "\t");
			
			int value = values[index];
			int startCount = value/10_000_000; // 천만원 단위마다 *를 하나씩 표시
			for(int i = 1; i <= startCount; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
