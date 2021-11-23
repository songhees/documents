package example_10_06_01_collection;

import java.util.HashSet;
import java.util.Set;

public class ex {
	public static void main(String[] args) {
		
		Set<String> a = new HashSet<>();
		
		a.add("");
		a.add("·¹");
		a.add("¹Ì");
		a.add("µµ");
		
		HashSet<String> data = new HashSet<>();
		
		data.add("È«");
		data.add("¾Æ");
		data.add("ÀÌ");
		data.add("È«¤·¿À");
		data.add("È«");
		
		System.out.println(data.size()); //4
		System.out.println(data.contains("¾Æ")); //true
		System.out.println(data.isEmpty()); //false
		data.remove("ÀÌ");
		System.out.println(data.toString()); //
		
		
		data.addAll(a);
		System.out.println(data.toString()); //
		
		data.clear();
		System.out.println(data.toString()); //
		
		
		
	}
}
