package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hold_tableDTO {
	String rcode, reason;
	Integer norescnt;
	Date noresdate;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getNorescnt() {
		return norescnt;
	}

	public void setNorescnt(Integer norescnt) {
		this.norescnt = norescnt;
	}

	public Date getNoresdate() {
		return noresdate;
	}

	public void setNoresdate(Date noresdate) {
		this.noresdate = noresdate;
	}
	
	public String getNoresdateStr() {
		return sdf.format(noresdate);
	}

	public void setNoresdateStr(String noresdate) {
		try {
			this.noresdate = sdf.parse(noresdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
