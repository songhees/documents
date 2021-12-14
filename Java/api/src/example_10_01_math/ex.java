package example_10_01_math;

public class ex {
	public static String delChar(String src, String target) {
		/*
		 * 문자열에 제거할 문자가 포함되어 있는 위치를 확인
		 * 확인후 위치에 있는 문자를 제거
		 * 문자열을 반환한다.
		 * 
		 */
		StringBuffer delate = new StringBuffer(src);
		int index = 0;
		int pos = 0;
		
		while (index != target.length()) {
			pos = src.indexOf(target.charAt(index), pos);
			if (pos == -1) {
				index ++;
				pos = 0;
				continue;
			}
			delate.deleteCharAt(pos);	
			src = delate.toString();
			pos++;
		}
		return src.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println(delChar("(1 2 3 4\t5)"," \t"));
	}
}
