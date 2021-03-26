package javaexp.z02_test;

import java.io.File;

public class A05_File {

	public static void main(String[] args) {
		
		try {
			String orpath = "/Users/wangsungtaek/taek/project/springweb2/src/javaexp";
			String mkDir = "/z02_test";
			boolean b = new File(orpath+mkDir).mkdir(); // 디렉토리 생성
			String path = orpath + mkDir;
			for(int cnt=1; cnt<10; cnt++) {
				File f = new File(path, "z"+cnt+"_test.txt");
				f.createNewFile(); // 파일 생성 처리.
				System.out.println(f.getName()); // 파일명
				System.out.println(f.exists()); // 존재여부
				System.out.println(f.getPath()); // 경로
				System.out.println(f.length()); // 크기
			}
			
			System.out.println(File.separator);
			
			boolean b2 = new File(path, "z1_test.txt").delete();
			
			String[] listing = new File(path).list();
			
			for(String str : listing) {
				System.out.println("현재 폴더내용:"+str);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
