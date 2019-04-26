package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Air_planeDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public Air_planeDAO() {
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
	
	
	public Object airplanelist(String air_code) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			
			sql = "select * from air_plane where air_code = ? ";
			
			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, air_code);
				rs = ptmt.executeQuery();
				
				
				while(rs.next()) {
					Air_itemDTO dto = new Air_itemDTO();
					
					dto.setAp_code(rs.getString("ap_code"));
					
					res.add(dto);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return res;
			
		}
	
	public void airplaneinsert(Air_planeDTO dto) {
		
		sql = "insert into air_plane (air_code , ap_code ) values"
				+ "(? , ?)";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.air_code);
			ptmt.setString(2, dto.ap_code);
			
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void airplanedelete(Air_planeDTO dto) {
		
		
		try {
			 
			sql = "delete from air_plane where ap_code = ? " ;
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getAp_code());
			
			ptmt.executeUpdate() ;
			
			sql = "delete from air_item where ap_code = ? " ;
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getAp_code());
			
			ptmt.executeUpdate() ;
			
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
