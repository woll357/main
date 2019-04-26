package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Air_dereDTO {

	String code , id ,request , kind;
	Date requsetdate;
	
	
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Date getRequsetdate() {
		return requsetdate;
	}
	
	public String getRequsetdateStr() {
		return asd.format(requsetdate);
	}
	

	public void setRequsetdate(Date requsetdate) {
		this.requsetdate = requsetdate;
	}
	
	public void setRequsetdateStr(String requsetdateStr) {
		try {
			this.requsetdate = asd.parse(requsetdateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	
	SimpleDateFormat asd = new SimpleDateFormat("yyyy-MM-dd");
	
}
