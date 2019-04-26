package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Air_itemDTO {
	
	Date ddate ;
	String darea , carea , img , air_code , ap_code , ccode , flightclass ,air_p;
	Date a_time;
	int money ,seatcnt , totseatcnt;
	
	
	
	
	public String getAir_p() {
		return air_p;
	}

	public void setAir_p(String air_p) {
		this.air_p = air_p;
	}

	public int getTotseatcnt() {
		return totseatcnt;
	}

	public void setTotseatcnt(int totseatcnt) {
		this.totseatcnt = totseatcnt;
	}

	public Date getA_time() {
		return a_time;
	}
	
	public String getA_timeStr() {
		return asd.format(a_time);
	}
	
	public void setA_timeStr(String a_timeStr) {
		try {
			this.a_time = asd.parse(a_timeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setA_time(Date a_time) {
		this.a_time = a_time;
	}
	
	public Date getDdate() {
		return ddate;
	}
	
	public String getDdateStr() {
		return asd.format(ddate);
	}
	
	public void setDdateStr(String ddateStr) {
		try {
			this.ddate = asd.parse(ddateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	public String getDarea() {
		return darea;
	}

	public void setDarea(String darea) {
		this.darea = darea;
	}

	public String getCarea() {
		return carea;
	}

	public void setCarea(String carea) {
		this.carea = carea;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAir_code() {
		return air_code;
	}

	public void setAir_code(String air_code) {
		this.air_code = air_code;
	}

	public String getAp_code() {
		return ap_code;
	}

	public void setAp_code(String ap_code) {
		this.ap_code = ap_code;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}



	public String getFlightclass() {
		return flightclass;
	}

	public void setFlightclass(String flightclass) {
		this.flightclass = flightclass;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getSeatcnt() {
		return seatcnt;
	}

	public void setSeatcnt(int seatcnt) {
		this.seatcnt = seatcnt;
	}
	
	SimpleDateFormat asd = new SimpleDateFormat("yyyy-MM-dd");
	
}
