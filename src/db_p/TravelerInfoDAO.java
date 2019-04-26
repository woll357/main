package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TravelerInfoDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public TravelerInfoDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
public void insert(TravelerInfoDTO dto) {
		
		sql = "insert into travelerInfo "
			+ "(pname, passport, mainEngLastName, mainEngFirstName, cEngLastName, cEngFirstName, cKorName, birthDate, cph, cemail, id, basketID) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);
		try {
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1,dto.getPname());
			ptmt.setString(2,dto.getPassport());
			ptmt.setString(3,dto.getMainEngLastName());
			ptmt.setString(4,dto.getMainEngFirstName());
			ptmt.setString(5,dto.getcEngLastName());
			ptmt.setString(6,dto.getcEngFirstName());
			ptmt.setString(7,dto.getcKorName());
			ptmt.setString(8,dto.getBirthDate());
			ptmt.setString(9,dto.getCph());
			ptmt.setString(10,dto.getCemail());
			ptmt.setString(11,dto.getId());
			ptmt.setString(12,dto.getBasketID());
			
			
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}

}
