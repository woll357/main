package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Air_comDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	
	
	public Air_comDAO() {
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
	
	public ArrayList<Air_comDTO> air_comList() {
		
		ArrayList<Air_comDTO> res = new ArrayList<Air_comDTO>();
		
		sql = "select * from air_com";
		
		try {
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				Air_comDTO dto = new Air_comDTO();
				dto.setAir_code(rs.getString("air_code"));
				dto.setId(rs.getString("id"));
				dto.setCrn(rs.getString("crn"));
				dto.setImg(rs.getString("img"));
				dto.setAir_name(rs.getString("air_name"));
				dto.setSalesPercent(rs.getDouble("salesPercent"));
				
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
	
	
	
public Object comdetail(Air_comDTO dto) {
		
		Air_comDTO res = null;
		
		sql = "select * from air_com where id =? ";
		
		try {
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.id);
			
			rs = ptmt.executeQuery();
			
			
			if(rs.next()) {
				
				res = new Air_comDTO();
				res.setAir_code(rs.getString("air_code"));
				res.setId(rs.getString("id"));
				res.setCrn(rs.getString("crn"));
				res.setImg(rs.getString("img"));
				res.setAir_name(rs.getString("air_name"));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}

public Air_comDTO fileDelete(Air_comDTO dto) {
	Air_comDTO res = null;

	
	sql = "select * from air_com where  air_code = ? ";
	
	try {
		ptmt = con.prepareStatement(sql);
		ptmt.setString(1, dto.getAir_code());
		rs = ptmt.executeQuery();
		
		if(rs.next()) {
			
		
			res = new Air_comDTO();
		
			res.setImg(rs.getString("img"));
		
			
			sql = "update air_com set img = null where air_code = ?" ;  //이 부분은 파일이 삭제 되었을때 파일 삭제된것이 DB에 업데이트해야하기때문에 .
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getAir_code());
			
			ptmt.executeUpdate(); 
			
			
			
			sql = "update air_item set img = null where air_code = ?" ;  //이 부분은 파일이 삭제 되었을때 파일 삭제된것이 DB에 업데이트해야하기때문에 .
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getAir_code());
			
			ptmt.executeUpdate(); 
		}
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
		close();
	}

	return res;
}


	public boolean aircommodify(Air_comDTO dto) {
		
		boolean res = false;
		
		try {
			
			sql = "update air_com set " + 			
					"img = ? " + 
					"where id = ? ";
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getImg());
			ptmt.setString(2, dto.getId());
				
			res = ptmt.executeUpdate() > 0; //익스큐트 없데이트가 1건 이상이여야 하기때문에 0이상이 되야 삭제됨 초기값은  false
			
			
			sql = "update air_item set " + 			
					"img = ? " + 
					"where air_code = ? ";
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getImg());
			ptmt.setString(2, dto.getAir_code());
				
			res = ptmt.executeUpdate() > 0;
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		return res;
	}
	
	
	

public Object air_pdetaill(String a) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			//air_itemDTO res = null;
			
			sql = "select distinct darea , carea from air_item where air_p = ? " ;
			
			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, a);
	
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					
					Air_itemDTO dto = new Air_itemDTO();
					
					dto.setDdate(rs.getTimestamp("ddate"));
					dto.setDarea(rs.getString("darea"));
					dto.setCarea(rs.getString("carea"));
					dto.setAp_code(rs.getString("ap_code"));
					dto.setCcode(rs.getString("ccode"));
					dto.setMoney(rs.getInt("money"));
					dto.setA_time(rs.getTimestamp("a_time"));
					dto.setSeatcnt(rs.getInt("seatcnt"));
					dto.setFlightclass(rs.getString("flightclass"));	
					dto.setTotseatcnt(rs.getInt("totseatcnt"));
				
					
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
	
	
	
		
	
	
	
		
		//-------------------------------------------------------
		
	
		public Object airlinelist() {
				
				ArrayList<Air_comDTO> res = new ArrayList<Air_comDTO>();
				
				
				sql = "SELECT * FROM green_sc.air_com ";
				
				try {
					ptmt = con.prepareStatement(sql);
					rs = ptmt.executeQuery();
					
					
					while(rs.next()) {
						Air_comDTO dto = new Air_comDTO();
						
						dto.setImg(rs.getString("img"));
						dto.setAir_code(rs.getString("air_code"));
						dto.setId(rs.getString("id"));
						dto.setCrn(rs.getString("crn"));
						dto.setAir_name(rs.getString("air_name"));
						
						res.add(dto);
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				return res;
				
			}
		
		
		public void airlinedelete(Air_comDTO dto) {
					
				try {
					 
					sql = "delete from air_com where id = ? " ;			
					ptmt = con.prepareStatement(sql);					
					ptmt.setString(1, dto.getId());
					
					ptmt.executeUpdate() ;
					
					sql = "DELETE from member where id= ?";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, dto.getId());
					ptmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					
					close();
				}
				
				
			}
	
		public Air_comDTO serarchByAirCode(Air_comDTO dto) {
			Air_comDTO res = null;
			
			sql = "select * from air_com where air_code = ? " ;
			
			try {
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getAir_code());
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
					
					res = new Air_comDTO();
					res.setAir_code(rs.getString("air_code"));
					res.setId(rs.getString("id"));
					res.setCrn(rs.getString("crn"));
					res.setImg(rs.getString("img"));
					res.setAir_name(rs.getString("air_name"));
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			
			  finally {
			  
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
