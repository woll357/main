package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasketDTO {
	int cNum, psn, no, totalPrice, pno;
	String basketID, id, cType, cName, itemName, location1, location2, code;
	Date ddate, fdate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getBasketID() {
		return basketID;
	}


	public void setBasketID(String basketID) {
		this.basketID = basketID;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getLocation1() {
		return location1;
	}


	public void setLocation1(String location1) {
		this.location1 = location1;
	}


	public String getLocation2() {
		return location2;
	}


	public void setLocation2(String location2) {
		this.location2 = location2;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getDdateStr() {
		return sdf.format(ddate);
	}
	
	public void setDdateStr(String ddateStr) {
		try {
			this.ddate = sdf.parse(ddateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}
	

	public String getFdateStr() {
		return sdf.format(fdate);
	}

	public void setFdateStr(String fdateStr) {
		try {
			this.fdate = sdf.parse(fdateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public int getPsn() {
		return psn;
	}
	public void setPsn(int psn) {
		this.psn = psn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		this.cType = cType;
	}
	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	
}
