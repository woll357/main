package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Air_itemDAO {
	
	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public Air_itemDAO() {
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


	
	public void insert(Air_itemDTO dto) {
			
			
		try {
			sql = "insert into air_item (ap_code, ddate, darea, img , air_code , carea , money, totseatcnt, flightclass , air_p ,ccode )" 
			+ " values (                   ?   ,    ?  ,   ? ,'asiano.jpg', 'A1000', ? ,    ? ,       ? ,       ? ,      'jd100' ,'상품코드' )";
				//                        비행기코드
				
				
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getAp_code());
				ptmt.setString(2, dto.getDdateStr());
				ptmt.setString(3, dto.getDarea());
				ptmt.setString(4, dto.getCarea());
				ptmt.setInt(5, dto.getMoney());
				ptmt.setInt(6, dto.getTotseatcnt());
				ptmt.setString(7, dto.getFlightclass());
			//	ptmt.setString(8, dto.getAir_p());
//				ptmt.setString(9, dto.getCcode());
				
				ptmt.executeUpdate();
				
			
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				close();
			}
	
		}
	
	
	
	
	
	
	
	public Air_itemDTO detail(String day , String darea , String carea , String ap_code ) {
		
		Air_itemDTO res = null;
		
		sql = "select * from air_item where date(ddate)>=date(?) and darea = ? and carea = ? and ap_code = ? ";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, day);
			ptmt.setString(2, darea);
			ptmt.setString(3, carea);
			ptmt.setString(4, ap_code);
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new Air_itemDTO();
				res.setDdate(rs.getTimestamp("ddate"));
				res.setDarea(rs.getString("darea"));
				res.setCarea(rs.getString("carea"));
				res.setImg(rs.getString("img"));
				res.setAp_code(rs.getString("ap_code"));
				res.setCcode(rs.getString("ccode"));
				res.setMoney(rs.getInt("money"));
				res.setA_time(rs.getTimestamp("money"));
				res.setSeatcnt(rs.getInt("seatcnt"));
				res.setFlightclass(rs.getString("flightclass"));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		return res;
	}

	
	
		public void delete(Air_itemDTO dto) {
				
			
			try {
				 
				sql = "delete from air_item where ccode = ?" ;
				
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getCcode());
				
				ptmt.executeUpdate() ;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				close();
			}
			
			
		}
	
	
	
	
	public Object detail(String a) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			//air_itemDTO res = null;
			
			sql = "select * from air_item where ccode = ? " ;
			
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
	
	
	
		
	
		public void modify(Air_itemDTO dto) {
		
			
			
		try {
			
			sql = "update air_item set ap_code = ? , " + 
					"ddate = ? , " + 
					"darea = ? , " + 
					"carea = ? , " + 
					"money = ? , " + 
					"totseatcnt = ? , " + 
					"flightclass = ? " + 
					"where ccode =  ? ";
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getAp_code());
			ptmt.setString(2, dto.getDdateStr());
			ptmt.setString(3, dto.getDarea());
			ptmt.setString(4, dto.getCarea());
			ptmt.setInt(5, dto.getMoney());
			ptmt.setInt(6, dto.getTotseatcnt());
			ptmt.setString(7, dto.getFlightclass());
			ptmt.setString(8, dto.getCcode());
			
	
			
			//res = ptmt.executeUpdate() > 0; //익스큐트 없데이트가 1건 이상이여야 하기때문에 0이상이 되야 삭제됨 초기값은  false
			
			 ptmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
	
	}
		
		
		public Object itemlist(String air_code) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			
			
			try {
				sql = "select * from air_item where air_code = ? ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.
				//limit 0, 3  - > 3개만 가져옴
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, air_code);
		
				
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
		
		
		
		public Object air_pitemlist() {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			
			
			try {
				sql = "select distinct air_p , darea , carea from air_item ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.
				//limit 0, 3  - > 3개만 가져옴
				ptmt = con.prepareStatement(sql);
				
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					
				Air_itemDTO dto = new Air_itemDTO();
				dto.setAir_p(rs.getString("air_p"));	
				dto.setDarea(rs.getString("darea"));
				dto.setCarea(rs.getString("carea"));		
					
					
							
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
		
		
		public Object air_pitemlist2(String air_p) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
	
			try {
				sql = "select * from air_item where air_p = ? ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.

				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, air_p);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					
					Air_itemDTO dto = new Air_itemDTO();
								
					
					dto.setCcode(rs.getString("ccode"));
					dto.setDdate(rs.getTimestamp("ddate"));
					dto.setDarea(rs.getString("darea"));
					dto.setCarea(rs.getString("carea"));
					dto.setAp_code(rs.getString("ap_code"));
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
		
		
	
	
	
	public Air_itemDTO itemdetail(Air_itemDTO dto) {
		Air_itemDTO res = null;
		
		sql = "select * from air_item where ccode = ? " ;
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.ccode);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new Air_itemDTO();
				res.setDdate(rs.getTimestamp("ddate"));
				res.setDarea(rs.getString("darea"));
				res.setCarea(rs.getString("carea"));
				res.setImg(rs.getString("img"));
				res.setAp_code(rs.getString("ap_code"));
				res.setCcode(rs.getString("ccode"));
				res.setMoney(rs.getInt("money"));
				res.setA_time(rs.getTimestamp("a_time"));
				res.setSeatcnt(rs.getInt("seatcnt"));
				res.setFlightclass(rs.getString("flightclass"));
				res.setTotseatcnt(rs.getInt("totseatcnt"));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		  finally {
		  
		  close();
		  }
		        //디테일을 쓰는 애들은 직접 다 close 해줘야함.

			return res;
	}
	
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
	
	
}
