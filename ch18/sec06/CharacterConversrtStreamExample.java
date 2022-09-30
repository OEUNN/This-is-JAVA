package ch18.sec06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConversrtStreamExample {
	
	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림을 사용합니다.");
		String data=read();
		System.out.println(data);
	}
	
	public static void write(String str) throws Exception{
		OutputStream os=new FileOutputStream("C:/Temp/test.txt");
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		writer.write(str);//문자열을 바로 출력
		writer.flush();
		writer.close();
	}
	
	public static String read() throws Exception{
		/*InputStream is = new FileInputStream("C/Temp/test.txt");
		Reader reader = new InputStreamReader(is,"UTF-8");
		char[] data=new char[100];
		int num=reader.read(data);
		reader.close();
		String str=new String(data,0,num);
		return str;*/
		
		//편하게 사용하는 방법(보조스트림의 보조스트림 달기)
		InputStream is = new FileInputStream("C/Temp/test.txt");
		Reader reader = new InputStreamReader(is,"UTF-8");//보조스트림1
		BufferedReader br=new BufferedReader(reader);//보조스티림2
		String str=br.readLine();//BufferedReader를 통해 위의 줄이 없어지고 하나로 끝
		return str;
	}
	
	
	/*
	public static void main(String[] args) {
		try {
			OutputStream os=new FileOutputStream("C:/Temp/test.txt");
			Writer writer =new OutputStreamWriter(os,"UTF-8");
			String str="문자 변환 스트림을 사용합니다.";
			writer.write(str);
			writer.flush();
			writer.close();
			
			InputStream is =new FileInputStream("C:/Temp/test.txt");
			Reader reader = new InputStreamReader(is,"UTF-8");
			char[] data=new char[20];
			int num=reader.read(data);
			//data배열 안에서 0인덱스부터 num까지만 문자열로 만들겠다.
			//->하는 이유는 실제로 내가 읽은 수만큼만 변화하겠다는 것이다.
			String str2=new String(data,0,num);
			System.out.println(str2);
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
}
