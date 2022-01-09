package programmers;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
	public static void main(String[] args) {
		String answer = "";
		String new_id = "";
		
		new_id = new_id.toLowerCase();
		StringBuilder sb = new StringBuilder();
		
		int len = new_id.length();
		for (int i=0; i<len; i++) {
//			if (new_id.charAt(i) >= 97 && new_id.charAt(i) <= 122) {
//				sb.append(new_id.charAt(i));
//			} else if (Character.isDigit(new_id.charAt(i))) {
//				sb.append(new_id.charAt(i));
//			} else if (new_id.charAt(i) == 95 || new_id.charAt(i) == 45 || new_id.charAt(i) == 46) {
//				sb.append(new_id.charAt(i));
//			}
			if (Character.isLetterOrDigit(new_id.charAt(i))) {
				sb.append(new_id.charAt(i));
			} else if (new_id.charAt(i) == 95 || new_id.charAt(i) == 45 || new_id.charAt(i) == 46) {
				sb.append(new_id.charAt(i));
			}
		}

		new_id = sb.toString();
		
		while (new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
		
		// ".."를 찾아서 relpace한다.
		sb.setLength(0);
		sb.append(new_id);
		
		if(sb != null) {
			if (sb.charAt(0) == 46) {
				sb = sb.deleteCharAt(0);
			} 
			
			while (sb.length() >= 16) {
				sb = sb.delete(15, sb.length());
			}
	
			if (sb.charAt(sb.length()-1) == 46) {
				sb = sb.deleteCharAt(sb.length()-1);
			}
		}
		
		if (sb == null) {
			sb.setLength(0);
			sb.append("a");
		}

		while (sb.length() <= 2) {
			sb.append(sb.charAt(sb.length()-1));
		}
		
		answer = sb.toString();
		
		System.out.println(answer);
	}
//    public String solution(String new_id) {
        
//        return answer;
//    }
}