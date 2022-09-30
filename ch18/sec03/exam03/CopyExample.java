package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) {
		String originalFileName = "C:/Temp/test.jpg";
		String targetFileName="C:/Temp/test2.jpg";
		
		try(InputStream is = new FileInputStream(originalFileName);
				OutputStream os =new FileOutputStream(targetFileName)){
			byte[] data = new byte[1024];
			while(true) {
				int num=is.read(data);//read는 읽을때 1024번 읽는다.
				if(num==-1) break;
				os.write(data,0,num);
			
			}
			os.flush();
			
			System.out.println("sucess");
//			os.close();//AutoCloseable 사용을 했음으로 close하지 않아도 된다.
//			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
