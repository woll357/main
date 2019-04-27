package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Air_dereDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public Air_dereDAO() {
		// TODO Auto-generated constructor stub
	
		DataSource ds;
		
		try {
			
			ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void insert(Air_dereDTO dto) {
		
		sql = "insert into dere(code , request , id , requestdate ,kind ) values"
				+ "( ? , ? , ? , sysdate() , ? )";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getCode());
			ptmt.setString(2, dto.getRequest());
			ptmt.setString(3, dto.getId());
			ptmt.setString(4, dto.getKind());
			
			
			ptmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
			
	}
	
	
	
	public void delete(String a) {
		
		
		try {
			
			sql = "delete from air_com where air_code = ? ";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, a);	
			
			ptmt.executeUpdate() ;
			
			
			sql = "delete from air_item where air_code = ? ";
			ptmt = con.prepareStatement(sql);		
			ptmt.setString(1, a);
			ptmt.executeUpdate() ;
			
			sql = "delete from dere where code = ? " ;
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, a);	
			ptmt.executeUpdate() ;
			
			sql = "delete from air_plane where air_code = ? ";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, a);	
			ptmt.executeUpdate() ;
			
			sql = "delete from hot_com where hcode = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, a);
			ptmt.executeUpdate() ;
			
			sql = "delete from room_item where hcode = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, a);
			ptmt.executeUpdate() ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
	}
	
	public ArrayList<Air_dereDTO> requestlist() {
		
		ArrayList<Air_dereDTO> res = new ArrayList<Air_dereDTO>();
		
		
		try {
			sql = "SELECT * FROM dere  ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.

			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				Air_dereDTO dto = new Air_dereDTO();
				
				
				dto.setCode(rs.getString("code"));
				dto.setRequest(rs.getString("request"));
				dto.setId(rs.getString("id"));
				dto.setRequsetdate(rs.getTimestamp("requestdate"));
				dto.setKind(rs.getString("kind"));

				
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
	
	
	
	
	
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
	
	
	
	
	
}
