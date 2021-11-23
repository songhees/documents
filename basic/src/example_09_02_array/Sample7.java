package example_09_02_array;

public class Sample7 {
	public static void main(String[] args) {
		/*
		 * 다차원 배열
		 * 타입[] 변수명 = new 타입[크기];					1차원 배열
		 * 타입[][] 변수명 = new 타입[크기][크기];			2차원 배열
		 * 타입[][][] 변수명 = new 타입[크기][크기][크기];		3차원 배열
		 * 
		 * 연락처 정보(이름, 전화번호, 이메일)를 저장하는 2차원 배열 생성하기
		 */
		String[][] contacts = new String[2][3];
		
		// 2차원배열의 각 요소에 연락처 정보 저장하기
		contacts[0][0] = "홍길동";
		contacts[0][1] = "010-1234-5678";
		contacts[0][2] = "gildon@naver.con";
		contacts[1][0] = "김유신";
		contacts[1][1] = "010-9857-7457";
		contacts[1][2] = "kim-sy@gmail.com";
		
		// 내포된 for문을 사용해서 다차원 배열 다루기
		for (int i = 0; i < 2; i++) {
			String[] row = contacts[i];
			for (int j = 0; j < 3; j++) {
				String value = row[j];
				System.out.print(value + "\t");		
			}
			System.out.println();
		}
		
		for (String[] contact : contacts ) {
			for (String value : contact) {
				System.out.print(value + "\t");
			}
			System.out.println();
		}
	}
}
