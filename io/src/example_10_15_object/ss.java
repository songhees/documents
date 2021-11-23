package example_10_15_object;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ss {
	public static void main(String[] args) {
		try(DataInputStream in = new DataInputStream(new FileInputStream("c:/temp/doc/sim.txt"));){
			int a = in.read();
			double d = in.readDouble();
			boolean s = in.readBoolean();
			String q = in.readUTF();
			int f = in.readInt();
			
			System.out.println(a);
			System.out.println(d);
			System.out.println(s);
			System.out.println(q);
			System.out.println(f);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
