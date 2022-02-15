package test02.ex02.setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseDev {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url;
	private String uid;
	private String upw;
	private Connection conn;
	private Statement stmt;

	public DatabaseDev() {
		
	}

	public DatabaseDev(String url, String uid, String upw) {
	
		try {
			Class.forName(this.driver);		
			this.conn = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test() {
		try {
			this.conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
		System.out.println(this.url);
		System.out.println(this.uid);
		System.out.println(this.upw);
	}
	
	public ResultSet testQuery(String sql) {
		ResultSet rs= null;
		
		try {
			this.conn = DriverManager.getConnection(url, uid, upw);
			this.stmt = this.conn.createStatement();
			
			rs = stmt.executeQuery(sql);

			//System.out.println(rs.getString("name"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
					
	}
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}


}
