package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Air_tempDAO {
	
		Connection con;
		PreparedStatement ptmt;
		ResultSet rs;
		String sql;
		
		
		
		
		public Air_tempDAO() {
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
		
		
		
		public void write(Air_tempDTO dto) {
			
			
			try {
				
				sql = "insert into air_temp "
				+ "(id, crn, img, air_name, grade, time ) values "
				+ "(? ,  ?  , ? ,      ? ,   ? ,  sysdate() )";
				
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				ptmt.setString(2, dto.getCrn());
				ptmt.setString(3, dto.getImg());
				ptmt.setString(4, dto.getAir_name());
				ptmt.setString(5, dto.getGrade());
				
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
