package springweb2.z03_vo;

public class SearchType {
	private int code;
	private String text;
	
	public SearchType() {
		// TODO Auto-generated constructor stub
	}

	public SearchType(int code, String text) {
		super();
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
