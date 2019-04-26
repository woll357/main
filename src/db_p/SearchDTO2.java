package db_p;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchDTO2 {
	String bstatus, rcode, rkind, rimg, hcode, hname, country, city, hinfo, startDay, endDay;
	Date ddate, noresdate;
	Integer norescnt, rcnt, pcnt, money;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRkind() {
		return rkind;
	}

	public void setRkind(String rkind) {
		this.rkind = rkind;
	}

	public String getRimg() {
		return rimg;
	}

	public void setRimg(String rimg) {
		this.rimg = rimg;
	}

	public String getHcode() {
		return hcode;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
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

	public String getHinfo() {
		return hinfo;
	}

	public void setHinfo(String hinfo) {
		this.hinfo = hinfo;
	}

	public Integer getNorescnt() {
		return norescnt;
	}

	public void setNorescnt(Integer norescnt) {
		this.norescnt = norescnt;
	}

	public Integer getRcnt() {
		return rcnt;
	}

	public void setRcnt(Integer rcnt) {
		this.rcnt = rcnt;
	}

	public Integer getPcnt() {
		return pcnt;
	}

	public void setPcnt(Integer pcnt) {
		this.pcnt = pcnt;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
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

	public Date getDdate() {
		return ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	public Date getNoresdate() {
		return noresdate;
	}

	
	
	
}
