package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuyDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public BuyDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insert(BuyDTO dto) {		//값을 넣준다.
		
		try {

			sql = "insert into buy "
					+ "(bnum, bdate, id, totalPrice, pCode) "
					+ "values(?, ?, ?, ?, ?)";
			System.out.println(sql);
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getBnum());
			ptmt.setString(2, dto.getBdateStr());
			ptmt.setString(3, dto.getId());
			ptmt.setInt(4, dto.getTotalPrice());
			ptmt.setString(5, dto.getpCode());
			
			ptmt.executeUpdate();
			
			
			sql = "update basket set bcode = concat(bstatus,pno) where id = ? and bdate = ?";
			
			System.out.println("나오니?"+sql);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getBdateStr());
			
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
