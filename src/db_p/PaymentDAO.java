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
			+ "(cComName, cNum, cvc, cPw, exDate, id, bcode) "
			+ "values(?, ?, ?, ?, ?,?, ?)";
		System.out.println(sql);
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getcComName());
			ptmt.setString(2, dto.getcNum());
			ptmt.setString(3, dto.getCvc());
			ptmt.setString(4, dto.getcPw());
			ptmt.setString(5, dto.getExDate());
			ptmt.setString(6, dto.getId());
			ptmt.setString(7, dto.getBcode());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void modify(PaymentDTO dto) {
		
		sql = "update payment set cComName = ?, cNum = ?, exDate = ?,"
				+ " cPw = ?, cvc = ?"
				+ " where id = ?";
				
	System.out.println(sql);
	
	try {
		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, dto.getcComName());
		ptmt.setString(2, dto.getcNum());
		ptmt.setString(3, dto.getExDate());
		ptmt.setString(4, dto.getcPw());
		ptmt.setString(5, dto.getCvc());
		ptmt.setString(6, dto.getId());
		
		int i = ptmt.executeUpdate();
		
		System.out.println(i);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}

	}
	
	public PaymentDTO detail(PaymentDTO dto) {
		PaymentDTO res = null;
		
		sql = "select * from payment where id = ? and bcode = ? ";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getBcode());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new PaymentDTO();
				
				res.setpCode(rs.getInt("pCode"));
				res.setcComName(rs.getString("cComName"));
				res.setcNum(rs.getString("cNum"));
				res.setCvc(rs.getString("cvc"));
				res.setcPw(rs.getString("cPw"));
				res.setExDate(rs.getString("exDate"));
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
