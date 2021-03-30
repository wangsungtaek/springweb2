package springweb2.mvc.dao;

import java.util.ArrayList;

import springweb2.z03_vo.FileVo;

public interface Z01_ExpDao {
	public void insertFile(FileVo ins);
	public ArrayList<FileVo> fileList();
}
