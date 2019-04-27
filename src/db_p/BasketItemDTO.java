package db_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasketItemDTO {
	String cCode, rcode, basketID, bstatus;
	int basketItemCode, price;
	Date ddate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getBasketID() {
		return basketID;
	}
	public void setBasketID(String basketID) {
		this.basketID = basketID;
	}
	public int getBasketItemCode() {
		return basketItemCode;
	}
	public void setBasketItemCode(int basketItemCode) {
		this.basketItemCode = basketItemCode;
	}

}
