package ch12.sec05;
//인코딩, 디코딩
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ByteToStringExample {

	public static void main(String[] args) throws Exception {
		String data="자바";
		
		try {
			byte[] arr1=data.getBytes("EUC-KR");
			System.out.println("arr1: "+Arrays.toString(arr1)+"\tlength:"+arr1.length);
		
			String str1=new String(arr1,"EUC-KR");
			System.out.println("str1: "+str1);
		
			byte[] arr2=data.getBytes();
			System.out.println("arr2: "+Arrays.toString(arr2));
		
			String str2=new String(arr2);
			System.out.println("str2: "+str2);
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		

	}

}
