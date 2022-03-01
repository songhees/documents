package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base27 {
	public static void main(String[] args) throws IOException, ParseException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String day = bf.readLine();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
		Date date = sd.parse(day);
		sd.applyPattern("dd-MM-yyyy");
		System.out.println(sd.format(date));
	}
}
