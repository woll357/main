package db_p;

public class PaymentDTO {
	
	int pCode;
	String cComName, cNum1,cNum2,cNum3,cNum4, exDateMonth, exDateYear, cPw, cvc, id, bcode;


	public String getcNum1() {
		return cNum1;
	}

	public void setcNum1(String cNum1) {
		this.cNum1 = cNum1;
	}

	public String getcNum2() {
		return cNum2;
	}

	public void setcNum2(String cNum2) {
		this.cNum2 = cNum2;
	}

	public String getcNum3() {
		return cNum3;
	}

	public void setcNum3(String cNum3) {
		this.cNum3 = cNum3;
	}

	public String getcNum4() {
		return cNum4;
	}

	public void setcNum4(String cNum4) {
		this.cNum4 = cNum4;
	}

	public String getExDateMonth() {
		return exDateMonth;
	}

	public void setExDateMonth(String exDateMonth) {
		this.exDateMonth = exDateMonth;
	}

	public String getExDateYear() {
		return exDateYear;
	}

	public void setExDateYear(String exDateYear) {
		this.exDateYear = exDateYear;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getcComName() {
		return cComName;
	}

	public void setcComName(String cComName) {
		this.cComName = cComName;
	}

	public String getcPw() {
		return cPw;
	}

	public void setcPw(String cPw) {
		this.cPw = cPw;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
