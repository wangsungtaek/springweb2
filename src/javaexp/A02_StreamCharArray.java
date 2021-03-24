package javaexp;

import java.io.IOException;
import java.io.InputStream;

public class A02_StreamCharArray {

	public static void main(String[] args) {

/*
# 다수의 문자열 입력 처리
1. read(byte[])
	입력된 문자열을 byte[]담아서 처리해준다.
 */
		InputStream is = null;
		try {
			// 담을 문자 처리할 메모리 설정..
			byte[] b = new byte[5];
			System.out.println("데이터를 입력하세요");
			is = System.in;
			int n = is.read(b);
			System.out.println("입력개수: "+n);
			for(byte bb : b) { // 반복문을 통해서 담겨 있는 문자 출력
				System.out.println("입력값:"+(char)bb);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
