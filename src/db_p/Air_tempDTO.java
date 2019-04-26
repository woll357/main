package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Air_tempDTO { //회원등급요청 dto
	
	
	String crn , img , air_name,grade , id;
	Date time;
	
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAir_name() {
		return air_name;
	}
	public void setAir_name(String air_name) {
		this.air_name = air_name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getTime() {
		return time;
	}
	public String getTimeStr() {
		return asd.format(getTime());
	}
	public void setTimeStr(String timeStr) {
		try {
			this.time = asd.parse(timeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	SimpleDateFormat asd = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
}
