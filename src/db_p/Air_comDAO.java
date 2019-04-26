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
	
	
//	public Object Air_comlist(int a) {
//		ArrayList<Air_comDTO> res = new ArrayList<Air_comDTO>();
//		
//		
//		
//		try {
//			sql = "select * from board order by gid desc , seq limit ? , ?";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.
//			//limit 0, 3  - > 3개만 가져옴
//			ptmt = con.prepareStatement(sql);
//			
//			ptmt.setInt(1, page);
//			ptmt.setInt(2, limit);
//			
//			rs = ptmt.executeQuery();
//			
//			while(rs.next()) {
//				Air_comDTO dto = new Air_comDTO();
//				dto.setBid(rs.getInt("bid"));
//				dto.setGid(rs.getInt("gid"));
//				dto.setSeq(rs.getInt("seq"));
//				dto.setLevel(rs.getInt("level"));
//				dto.setNo(rs.getInt("no"));
//				dto.setTitle(rs.getString("title"));
//				dto.setPname(rs.getString("pname"));
//				dto.setRegdate(rs.getTimestamp("regdate"));
//				
//				res.add(dto);
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			
//			close();
//		}
//		
//		
//		return res;
//	}
	
	
	
	
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


	public boolean aircommodify(Air_comDTO dto) {
		
		boolean res = false;
		
		try {
			
			sql = "update air_com set crn = ? ," + 
					"air_name = ? ," + 
					"img = ? " + 
					"where id = ? ";
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getCrn());
			ptmt.setString(2, dto.getAir_name());
			ptmt.setString(3, dto.getImg());
			ptmt.setString(4, dto.getId());
				
			res = ptmt.executeUpdate() > 0; //익스큐트 없데이트가 1건 이상이여야 하기때문에 0이상이 되야 삭제됨 초기값은  false
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		return res;
	}
	
	
	
//	public Object air_pdetail(String a) {
//		
//		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
//			//air_itemDTO res = null;
//			
//			sql = "select * from air_item where air_p = ? " ;
//			
//			try {
//				ptmt = con.prepareStatement(sql);
//				ptmt.setString(1, a);
//	
//				rs = ptmt.executeQuery();
//				
//				while(rs.next()) {
//					
//					Air_itemDTO dto = new Air_itemDTO();
//					
//					dto.setDdate(rs.getTimestamp("ddate"));
//					dto.setDarea(rs.getString("darea"));
//					dto.setCarea(rs.getString("carea"));
//					dto.setAp_code(rs.getString("ap_code"));
//					dto.setCcode(rs.getString("ccode"));
//					dto.setMoney(rs.getInt("money"));
//					dto.setA_time(rs.getTimestamp("a_time"));
//					dto.setSeatcnt(rs.getInt("seatcnt"));
//					dto.setFlightclass(rs.getString("flightclass"));	
//					dto.setTotseatcnt(rs.getInt("totseatcnt"));
//				
//					
//					res.add(dto);
//					
//					
//				}
//						
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			
//			}finally {
//			   close();
//		  }
//			       
//			return res;
//		}
	
	
	
	
	
		public Object air_pdetail(String a ,String b) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
				//air_itemDTO res = null;
				
				sql = "select * from air_item where air_p = ? and date(ddate)=date( ? )" ;
				
				try {
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, a);
					ptmt.setString(2, b);
		
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
