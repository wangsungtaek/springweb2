package springweb2.z02_vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberReg {
	private boolean allowNoti;
	private Date birthday;
	
	private String email;
	private String jobCode;
	private String[] favoriteOs;
	private String tool;
	
	public MemberReg() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

	public Date getBirthday() {
		return birthday;
	}

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String[] getFavoriteOs() {
		return favoriteOs;
	}

	public void setFavoriteOs(String[] favoriteOs) {
		this.favoriteOs = favoriteOs;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
}
