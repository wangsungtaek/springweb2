package springweb2.a01_start;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springweb2.mvc.dao.Z01_ExpDao;
import springweb2.z03_vo.FileVo;
import springweb2.z03_vo.Repository;

@Service
public class B02_FileUploadService {
	
	@Value("${tmpUpload}")
	String tmpPath;
	@Value("${upload}")
	String orgPath;
	
	@Autowired(required = false)
	Z01_ExpDao dao;
	
	public void insertFile(Repository rep) {
		
		String fname = null;
		File orgFile = null;
		File tmpFile = null;
		
		File pathFile = new File(tmpPath);
		for(File f:pathFile.listFiles()) {
			f.delete();
		}
		
		for(MultipartFile f : rep.getReport()) {
			fname = f.getOriginalFilename();
			if(fname!=null && !fname.trim().equals("")) {
				tmpFile = new File(tmpPath + fname);
				
				try {
					f.transferTo(tmpFile);
					
					orgFile = new File(orgPath + fname);
					Files.copy(tmpFile.toPath(), orgFile.toPath(),
								StandardCopyOption.REPLACE_EXISTING);
					dao.insertFile(new FileVo(rep.getContent(),fname));
					
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("생성에러:"+e.getMessage());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("기타에러:"+e.getMessage());
				}
			}
		}
	}
	public ArrayList<FileVo> fileList(){
		return dao.fileList();
	}
}
