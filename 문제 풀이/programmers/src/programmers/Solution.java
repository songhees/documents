package programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public static void main(String[] args) {
		String answer = "";
		String new_id = "=.=";
		List<String> strs = new ArrayList<String>(); 
		
		new_id = new_id.toLowerCase();
		
		for (int i=0; i<new_id.length(); i++) {
			
			if (new_id.charAt(i) >= 97 && new_id.charAt(i) <= 122) {
				strs.add(String.valueOf(new_id.charAt(i)));
			} else if (Character.isDigit(new_id.charAt(i))) {
				strs.add(String.valueOf(new_id.charAt(i)));
			} else if (new_id.charAt(i) == 95 || new_id.charAt(i) == 45 || new_id.charAt(i) == 46) {
				strs.add(String.valueOf(new_id.charAt(i)));
			}
		}
		
		int len = strs.size();
		for (int i=1; i<len; i++) {
			if (".".equals(strs.get(len-i)) && ".".equals(strs.get(len-(i+1)))) {
				strs.remove(len-i);
			}
		}
		
		if ( ".".equals(strs.get(0))) {
			strs.remove(0);
		} 
		
		if (".".equals(strs.get(strs.size()-1))) {
			strs.remove(strs.size()-1);
		}
		
		if (strs.isEmpty()) {
			strs.add("a");
		}
		
		while (strs.size() >= 16) {
			strs.remove(strs.size()-1);
		}
		
		while (strs.size() <= 2) {
			strs.add(strs.get(strs.size()-1));
		}
		
		for (String str : strs) {
			answer += str;
		}
		System.out.println(answer);
	}
//    public String solution(String new_id) {
        
//    	
    	
//        return answer;
//    }
}