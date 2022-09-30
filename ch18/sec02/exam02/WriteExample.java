package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test2.db ");
			
			byte[] Array= {10,20,30};
			
			os.write(Array);
			
			os.flush();
			os.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		/*
		OutputStream os =null;
		try {
			os = new FileOutputStream("C:/Temp/test2.db ");
			byte[] Array= {10,20,30};
			os.write(Array);
			os.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
			}catch(IOException e) {}
		}*/
	
	}

}
