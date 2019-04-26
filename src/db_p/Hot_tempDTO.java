package db_p;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hot_tempDTO {
	Integer no;
	String id,crn,hname,hinfo,grade,himg,country,city;
	Date time;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCrn() {
		return crn;
	}
	public void setCrn(String crn) {
		this.crn = crn;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHinfo() {
		return hinfo;
	}
	public void setHinfo(String hinfo) {
		this.hinfo = hinfo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getTimeStr() {
		return sdf.format(time);
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setTimeStr(String time) {
		try {
			this.time = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
