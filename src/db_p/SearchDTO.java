package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchDTO {
		
	String darea, carea, img, air_code, cCode, flightclass, ap_Code, ddate, a_time, air_name;
	String hname, city, country, hinfo, startDay, endDay, rkind, rcode;
	Integer money, seatcnt, pcnt,rescnt;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public Integer getRescnt() {
		return rescnt;
	}
	public void setRescnt(Integer rescnt) {
		this.rescnt = rescnt;
	}
	public String getRkind() {
		return rkind;
	}
	public void setRkind(String rkind) {
		this.rkind = rkind;
	}
	public Integer getPcnt() {
		return pcnt;
	}
	public void setPcnt(Integer pcnt) {
		this.pcnt = pcnt;
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
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getFlightclass() {
		return flightclass;
	}
	public void setFlightclass(String flightclass) {
		this.flightclass = flightclass;
	}
	public String getAp_Code() {
		return ap_Code;
	}
	public void setAp_Code(String ap_Code) {
		this.ap_Code = ap_Code;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String a_time) {
		this.a_time = a_time;
	}
	public String getAir_name() {
		return air_name;
	}
	public void setAir_name(String air_name) {
		this.air_name = air_name;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHinfo() {
		return hinfo;
	}
	public void setHinfo(String hinfo) {
		this.hinfo = hinfo;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getSeatcnt() {
		return seatcnt;
	}
	public void setSeatcnt(Integer seatcnt) {
		this.seatcnt = seatcnt;
	}

	
	
	
	
}
