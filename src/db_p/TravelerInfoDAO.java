package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			+ "(pname, passport, mainEngLastName, mainEngFirstName, cEngLastName, cEngFirstName, cKorName, birthDate, cph1, cph2, cph3, cemail1, cemail2, id, basketID) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			ptmt.setString(9,dto.getCph1());
			ptmt.setString(10,dto.getCph2());
			ptmt.setString(11,dto.getCph3());
			ptmt.setString(12,dto.getCemail1());
			ptmt.setString(13,dto.getCemail2());
			ptmt.setString(14,dto.getId());
			ptmt.setString(15,dto.getBasketID());
			
			
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public ArrayList<TravelerInfoDTO> TravelerInfoListByBasketID(TravelerInfoDTO dt){ //예약내역 찾기
		ArrayList<TravelerInfoDTO> res = new ArrayList<TravelerInfoDTO>();
		try {
			sql = "select * from travelerInfo where basketID = ? ";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dt.getBasketID());
	
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				TravelerInfoDTO dto = new TravelerInfoDTO();
				dto.setPassport(rs.getString("passport"));
				dto.setId(rs.getString("id"));
				dto.setMainEngLastName(rs.getString("mainEngLastName"));
				dto.setMainEngFirstName(rs.getString("mainEngFirstName"));
				dto.setPname(rs.getString("pname"));
				dto.setBirthDate(rs.getString("birthDate"));
				dto.setcEngLastName(rs.getString("cEngLastName"));
				dto.setcEngFirstName(rs.getString("cEngFirstName"));
				dto.setcKorName(rs.getString("cKorName"));
				dto.setCph1(rs.getString("cph1"));
				dto.setCph2(rs.getString("cph2"));
				dto.setCph3(rs.getString("cph3"));
				dto.setCemail1(rs.getString("cemail1"));
				dto.setCemail1(rs.getString("cemail2"));
				dto.setBasketID(rs.getString("basketID"));
								
				res.add(dto);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		return res;
		
	}
	
	public void delete(TravelerInfoDTO dto) {
		
		sql = "delete from travelerInfo where basketID = ?";
				System.out.println(sql);
		try {
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getBasketID());
			ptmt.executeUpdate();//여기까지 실행
			
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
