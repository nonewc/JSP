package test02.ex02.setter;

public class DatabaseDev {

	private String url;
	private String uid;
	private String upw;

	
	
	public void test() {
		System.out.println(this.url);
		System.out.println(this.uid);
		System.out.println(this.upw);
	}
	
	
	
	public String getUrl() {
		return url;
	}

	public String getUid() {
		return uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public void setUpw(String upw) {
		this.upw = upw;
	}
	
	
}
