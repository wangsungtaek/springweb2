package javaexp;

import java.io.File;

public class A04_File {
	public static void main(String[] args) {

/*
11. FileReader와 Filewriter
	시스템에 있는 모든 문자 파일을 읽거나 파일에 쓸 수 있는 기능을 제공
	생성자로 스트림 객체를 생성할 때는 FileNotFoundException 예외 처리 필요
12. 파일 관리
	입출력 스트림은 파일이나 장치를 읽거나 쓰기 위해 사용
	입출력 스트림에 파일 생성 혹은 삭제, 파일 속성 변경 등의 관리 기능은 없음
	자바는 파일을 관리하기 위해 File 클래스를 제공
	여전히 File 클래스를 많이 사용하지만, 자바 4부터 도입되고 자바 7에서 기능을
	보완한 NIO(java.nio) 및 NIO2(java.nio2)
	기반의 Path 인터페이스, Files 클래스 및 FileChannel1도 유용
13. File 클래스
	파일이나 폴더의 경로를 추상화한 클래스로 java.io 패키지에 포함
	파일 유무, 삭제, 접근 권한 조사 등을 수행
	File 클래스 생성자
14. 버퍼
	Buffer는 NIO 기반의 데이터 입출력을 위해 사용되는 메모리 배열이며,
	java.nio 패키지에 있는 추상 클래스이다.
	Buffer의 구현 클래스는 모두 특정 기초 타입을 지원하기 위한 것으로
	ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer 등이 있음
15. 채널
	FileChannel은 NIO 기반의 데이터 흐름을 위한 수단을 제공하려는 클래스
	입출력 양방향 지원
	기본적으로 버퍼를 이용
	FileChannel은 java.nio.channels 패키지에 있는 추상 클래스로서
	동기화 처리가 되어 있어 다중 스레드 환경에서도 안전
	일번적으로 소용량 파일을 처리할 땐 FileChannel1dl 빠르지만, 대용량 파일이라면
	IO 기반의 파일 처리보다 복잡하고 성능이 떨어질 수 있다.
 */	
		try {
			String path="/Users/wangsungtaek/taek/project/springweb2/src/javaexp";
			
			File f = new File(path,"z01_test.txt");
			f.createNewFile();
			System.out.println(f.getName());
			System.out.println(f.exists());
			System.out.println(f.getPath());
			System.out.println(f.length());
			System.out.println(File.separator);
			boolean b = new File(path+"/z01_test").mkdir(); // 디렉토리 생성
			boolean b2 = new File(path, "z02_test.txt").delete();
			// 파일 삭제 처리./
			String [] listing = new File(path).list();
			// 해당 경로에 있는 파일명 리스트
			for(String str : listing) {
				System.out.println("현재 폴더내용:"+str);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
/*
ex) z01_text/z02_test.txt 임의의 데이터로 파일저장하고
	해당 파일 정보를 읽어 오고, 해당 폴드의 파일의 리스트를 읽어
	오고, 마지막으로 삭제 처리하세요.
 */
		try {
			System.out.println("==================");
			String path = "/Users/wangsungtaek/taek/project/springweb2/src/javaexp";
			File f1 = new File(path, "z02_test.txt");
			System.out.println(f1.getName());
			System.out.println(f1.getPath());
			System.out.println(f1.exists());
			System.out.println(f1.length());
			String [] listing = new File(path).list();
			for(String str : listing) {
				System.out.println("현재 폴더내용:"+str);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
