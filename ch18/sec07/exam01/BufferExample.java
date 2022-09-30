package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {

	public static void main(String[] args) {
		try {
			//Buffer가 없는 stream생성
			String originalFilePath1 = BufferExample.class.getResource("originalFile1.jpg").getPath();
			String targetFilePath1= "C:/Temp/targetFile1.jpg";
			
			FileInputStream fis1 =new FileInputStream(originalFilePath1);
			FileOutputStream fos1=new FileOutputStream(targetFilePath1);
			
			//Buffer가 있는 stream생성
			String originalFilePath2 = BufferExample.class.getResource("originalFile1.jpg").getPath();
			String targetFilePath2= "C:/Temp/targetFile1.jpg";
			
			FileInputStream fis2 =new FileInputStream(originalFilePath2);
			BufferedInputStream bis=new BufferedInputStream(fis2);
			
			FileOutputStream fos2=new FileOutputStream(targetFilePath2);
			BufferedOutputStream bos=new BufferedOutputStream(fos2);
			
			//copy시간 측정
			long nonBufferTime=copy(fis1,fos1);
			System.out.println("버퍼 미사용:\t" +nonBufferTime+"ns");
			
			long bufferTime=copy(bis,bos);
			System.out.println("버퍼 미사용:\t" +bufferTime+"ns");
			
			fis1.close();
			fos1.close();
			//보조스트림이 닫히면 연결된 스트림이 닫힌다.
			bis.close();
			bos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//copy하는데 걸린시간 return 
	public static long copy(InputStream is, OutputStream os)throws Exception{
		long start=System.nanoTime();
		
		while(true) {
			int data=is.read();
			if(data==-1) break;
			//왜 1byte 읽고 1byte 쓰는 이유는 느리게 읽기 위해서이다.
			os.write(data);
		}
		os.flush();
		
		long end=System.nanoTime();
		return (end-start);
	}

}
