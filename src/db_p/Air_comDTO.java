package db_p;

public class Air_comDTO { //항공사 테이블
	
	String air_code , id , crn , img , air_name;
	double salesPercent;

	
	public double getSalesPercent() {
		return salesPercent;
	}

	public void setSalesPercent(double salesPercent) {
		this.salesPercent = salesPercent;
	}

	public String getAir_code() {
		return air_code;
	}

	public void setAir_code(String air_code) {
		this.air_code = air_code;
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
	
	public String getImg() {
	
		if(img==null ) {
			
			img="";
		}
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
	
	

}
