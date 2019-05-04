package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PaymentDAO {
	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public PaymentDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insert(PaymentDTO dto) {
		
		sql = "insert into payment "
			+ "(cComName, cNum1, cNum2, cNum3, cNum4, cvc, cPw, exDateMonth, exDateYear, id, bcode) "
			+ "values(?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
		System.out.println(sql);
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getcComName());
			ptmt.setString(2, dto.getcNum1());
			ptmt.setString(3, dto.getcNum2());
			ptmt.setString(4, dto.getcNum3());
			ptmt.setString(5, dto.getcNum4());
			ptmt.setString(6, dto.getCvc());
			ptmt.setString(7, dto.getcPw());
			ptmt.setString(8, dto.getExDateMonth());
			ptmt.setString(9, dto.getExDateYear());
			ptmt.setString(10, dto.getId());
			ptmt.setString(11, dto.getBcode());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
//	public void modify(PaymentDTO dto) {
//		
//		sql = "update payment set cComName = ?, cNum1 = ?, cNum2 = ?, cNum3 = ?, cNum4= ? exDateMonth = ?, exDateYear=?"
//				+ " cPw = ?, cvc = ?"
//				+ " where id = ?";
//				
//	System.out.println(sql);
//	
//	try {
//		ptmt = con.prepareStatement(sql);
//		
//		ptmt.setString(1, dto.getcComName());
//		ptmt.setString(2, dto.getcNum1());
//		ptmt.setString(3, dto.getcNum2());
//		ptmt.setString(4, dto.getcNum3());
//		ptmt.setString(5, dto.getcNum4());
//		ptmt.setString(6, dto.getExDateMonth());
//		ptmt.setString(7, dto.getExDateYear());
//		ptmt.setString(8, dto.getcPw());
//		ptmt.setString(9, dto.getCvc());
//		ptmt.setString(10, dto.getId());
//		
//		int i = ptmt.executeUpdate();
//		
//		System.out.println(i);
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}finally {
//		close();
//	}
//
//	}
	
	public PaymentDTO detail(PaymentDTO dto) {
		PaymentDTO res = null;
		
		sql = "select * from payment where pCode = (select max(pCode) from payment where id = ?)";
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new PaymentDTO();
				
				res.setpCode(rs.getInt("pCode"));
				res.setcComName(rs.getString("cComName"));
				res.setcNum1(rs.getString("cNum1"));
				res.setcNum2(rs.getString("cNum2"));
				res.setcNum3(rs.getString("cNum3"));
				res.setcNum4(rs.getString("cNum4"));
				res.setCvc(rs.getString("cvc"));
				res.setcPw(rs.getString("cPw"));
				res.setExDateMonth(rs.getString("exDateMonth"));
				res.setExDateYear(rs.getString("exDateYear"));
				res.setId(rs.getString("id"));
				
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
}
