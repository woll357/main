package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasketpaidDTO {
	int pno, cNum, totalPrice, psn;
	String basketID, cType, cName, itemName, location1, location2, bcode, id, bstatus, code;
	Date ddate, fdate, bdate;
	double salesPercent;
	double managerSales;// 관리자가 먹는 량
	double comSales; //협력업체가 먹는 양
	
	public double getSalesPercent() {
		return salesPercent;
	}

	public void setSalesPercent(double salesPercent) {
		this.salesPercent = salesPercent;
		System.out.println("이익률"+salesPercent);
		System.out.println("가격"+this.totalPrice);
		this.managerSales = (this.totalPrice*(100-salesPercent*100))/100;
		System.out.println("회사가 갖는 돈"+this.managerSales);
		this.comSales = (double)(this.totalPrice)*salesPercent;
	}

	public double getManagerSales() {
		return managerSales;
	}
	
	public void setManagerSales(double managerSales) {
		this.managerSales = managerSales;
	}

	public void setComSales(double comSales) {
		this.comSales = comSales;
	}

	public double getComSales() {
		return comSales;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String getBdateStr() {
		return sdf.format(bdate);
	}
	
	public void setBdateStr(String bdateStr) {
		try {
			this.bdate = sdf.parse(bdateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
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
	
	
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getPsn() {
		return psn;
	}
	public void setPsn(int psn) {
		this.psn = psn;
	}
	public String getBasketID() {
		return basketID;
	}
	public void setBasketID(String basketID) {
		this.basketID = basketID;
	}
	public String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		this.cType = cType;
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
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
