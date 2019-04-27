package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BasketItemDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public BasketItemDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void insert(BasketItemDTO dto) {
		
		sql = "insert into basketItem "
			+ "(cCode, basketID, ddate, price, rcode) values(?, ?, ?, ?, ?)";
		System.out.println(sql);
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1,dto.getcCode());
			ptmt.setString(2,dto.getBasketID());
			ptmt.setString(3, dto.getDdateStr());
			ptmt.setInt(4, dto.getPrice());
			ptmt.setString(5, dto.getRcode());
						
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void modifyBstatus(BasketItemDTO dto) {
		
		sql = "update basketItem set bstatus = ? "
				+ " where basketID = ?";
				
	System.out.println(sql);
	
	try {
		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, dto.getBstatus());
		ptmt.setString(2, dto.getBasketID());
		
		ptmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}

	}
	
	public boolean delete(BasketItemDTO dto) { //장바구니에 해당하는 아이템들 삭제
		
		System.out.println("BasketItem Delete진입");
		
		boolean res = false;
		
		try {
			
			sql = "delete from basketitem where basketID = ? ";
			System.out.println(sql);
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getBasketID());
			
			res = ptmt.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}

		return res;
		
	}
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
	
}
