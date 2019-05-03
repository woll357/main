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

	//select air_name, air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code;
	
	//관리자
	
	
	
	
	//협력업체 비행기 삭제
	//select distinct seatcnt from air_plane , air_item where air_plane.ap_code = air_item.ap_code and air_item.ap_code = "a106" and air_item.air_code = 'A1000';
	public boolean airplaneseatcnt(Air_itemDTO dto ) {
		
		boolean res = true;
		
		sql = "select seatcnt from air_plane , air_item where air_plane.ap_code = air_item.ap_code and air_item.ap_code = ? ";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getAp_code());
			
		
			rs = ptmt.executeQuery();
			
			res = rs.next();
			//뭐라도 있으면 false
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		return res;
	}
	
	
	
	
	
	
	public void insert(Air_itemDTO dto) {
			
			
		
		try {
			sql = "insert into air_item (ap_code, ddate, darea, img , air_code , carea , money,  a_time ,  air_p)" 
			                + " values (    ?   ,   ?  ,   ? ,   ? ,     ?,       ? ,       ? ,     ? ,      ?  )";
				//                        비행기코드
				
				
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getAp_code());
				ptmt.setString(2, dto.getDdateStr());
				ptmt.setString(3, dto.getDarea());
				ptmt.setString(4, dto.getImg());
				ptmt.setString(5, dto.getAir_code());
				ptmt.setString(6, dto.getCarea());
				ptmt.setInt(7, dto.getMoney());
				ptmt.setString(8, dto.getA_timeStr());
				ptmt.setString(9, dto.getAir_p());
//				ptmt.setInt(8, dto.getTotseatcnt());
				//	ptmt.setString(9, dto.getFlightclass());

				
				ptmt.executeUpdate();
				
				
				
				
				sql = "update air_item set ccode =  concat( ?  , '-' , ? ,'-' , no )  where no = " + 
						"(select asd from ( select Max(no) as asd from air_item ) tt);";
				
				ptmt = con.prepareStatement(sql);
				
				
				ptmt.setString(1, dto.getAir_code());
				ptmt.setString(2, dto.getAp_code());
				
				ptmt.executeUpdate();
			
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				close();
			}
	
		}
	
	//도착시간 DAO	
	public LocationinfoDTO makea_time(LocationinfoDTO dto) {
		
		LocationinfoDTO res = null;
		

		try {
			sql = "select leadtime from locationinfo where darea = ? and carea = ? " ;	
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getDarea());
			ptmt.setString(2, dto.getCarea());
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new LocationinfoDTO();
				res.setLeadtime(rs.getInt("leadtime"));
				
				
			}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		return res;
	}

	//도착시간 UPDATE
	public void update_Atime(Air_itemDTO dto) {
		
		
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
		
			
			 ptmt.executeUpdate();
			 
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
	
	}
	

	
	//항공편코드 DAO	
		public LocationinfoDTO makeair_p(LocationinfoDTO dto) {
			
			LocationinfoDTO res = null;
			

			try {
				sql = "select air_p from locationinfo where darea = ? and carea = ? " ;	
				
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getDarea());
				ptmt.setString(2, dto.getCarea());
				
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
					res = new LocationinfoDTO();
					res.setAir_p(rs.getString("air_p"));					
				}
				
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
			   close();
		  }
			       
			return res;
		}
	
		
		//이미지 DAO		
		public Air_itemDTO makeimg(Air_itemDTO dto) {
			
			Air_itemDTO res = null;
			

			try {
				sql = "select img from air_com where air_code = ? " ;	
				
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getAir_code());

				
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
					res = new Air_itemDTO();
					res.setImg(rs.getString("img"));					
				}
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
			   close();
		  }
			       
			return res;
		}
		
		
		
		
		
		
		public void updatair_p(Air_itemDTO dto) {
			
			
			try {
				
				sql = "update air_item set air_p = ?  " + 
						"where ccode =  ? ";
				
				
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getAir_p());
				ptmt.setString(2, dto.getCcode());
			
				
				 ptmt.executeUpdate();
				 
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				close();
			}
			
		
		}
		//비행기 지난상품 리스트
		//select * from air_item where date(ddate)<=date(sysdate())  and air_code = 'A1000'; 
		public Object yitemdetail(String air_code ) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			sql = "select * from air_item where date(ddate)<=date(sysdate())  and air_code = ? order by ddate ";
			
			try {
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
				res.setA_time(rs.getTimestamp("a_time"));
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

	//예약 상품 확인
	public boolean airseatcntdetail(Air_itemDTO dto ) {
		
		boolean res = false;
		
		sql = "select * from air_item where  ccode= ? and seatcnt>0 ";
		
		try {
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getCcode());
		
			rs = ptmt.executeQuery();
			
			res = rs.next();

		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		return res;
	}

	
		//항공 상품 삭제
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
	
	
	
		
	//상품 수정 DAO select no from air_item where ccode = 'A1000-a103-1041' ;
		public void modify(Air_itemDTO dto) {
		
			
			
		try {
			
			sql = "update air_item set ap_code = ? , " + 
					"ddate = ? , " + 
					"darea = ? , " + 
					"carea = ? , " + 
					"money = ? , " + 
					"a_time = ?  " + 
					"where ccode =  ? ";
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getAp_code());
			ptmt.setString(2, dto.getDdateStr());
			ptmt.setString(3, dto.getDarea());
			ptmt.setString(4, dto.getCarea());
			ptmt.setInt(5, dto.getMoney());
			ptmt.setString(6, dto.getA_timeStr());
			ptmt.setString(7, dto.getCcode());
			
	
			 ptmt.executeUpdate();
			 
			 
		
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
	
	}
		
		//상품 수정 후 업데이트
		public void modifyupdate(Air_itemDTO dto) {
			
			
			
			try {
				
			
				sql = "update air_item set ccode =  concat( ? , '-' , ? ,'-' , no )  where  ccode =  ? ";
					// select no from air_item where ccode = 'A1000-a103-1041'
				//update air_item set ccode =  concat( 'A1000' , '-' , 'a104' ,'-' , no )  where  ccode = 'A1000-a103-1041';
				ptmt = con.prepareStatement(sql);
					
					
				ptmt.setString(1, dto.getAir_code());
				ptmt.setString(2, dto.getAp_code());
				ptmt.setString(3, dto.getCcode());	
				
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
				sql = "select * from air_item where date(ddate)>=date(sysdate())  and air_code  = ? order by ddate ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.
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
		
		//관리자

		public Object itemlistm() {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			
			
			try {
				sql = "select * from air_item ";         
				
				ptmt = con.prepareStatement(sql);
				
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					
					Air_itemDTO dto = new Air_itemDTO();
					
					dto.setAir_code(rs.getString("air_code"));
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
				sql = "	select air_name, air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.
				//limit 0, 3  - > 3개만 가져옴
				ptmt = con.prepareStatement(sql);
				
				
				
				rs = ptmt.executeQuery();
				
				
				
				while(rs.next()) {
					
				Air_itemDTO dto = new Air_itemDTO();
				
				dto.setAir_name(rs.getString("air_name"));	
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
	
	
	public Object air_pitemlistsarch(String air_p , String air_code) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
		
		
		
		try {
			sql = "	select air_name, air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code and air_item.air_p = ? and air_item.air_code = ? ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.
			//limit 0, 3  - > 3개만 가져옴
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, air_p);
			ptmt.setString(2, air_code);
			
			rs = ptmt.executeQuery();
			
			
			
			while(rs.next()) {
				
			Air_itemDTO dto = new Air_itemDTO();
			
			dto.setAir_name(rs.getString("air_name"));	
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
	
	
	public Object air_pitemlistt(String a) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
		
		
		
		try {
			sql = "	select distinct air_name, air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code and air_item.air_code = ? ";        
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, a);
			
			rs = ptmt.executeQuery();
			
			
			
			while(rs.next()) {
				
			Air_itemDTO dto = new Air_itemDTO();
			
			dto.setAir_name(rs.getString("air_name"));	
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
		
public Object air_pitemlist3(String air_p , String air_code) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
	
			try {
				sql = "select * from air_item where air_p = ? and air_code = ? ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.

				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, air_p);
				ptmt.setString(2, air_code);
				
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

//관리자 비행기 모든 상품 열람 select * from air_item where ap_code = 'a105';
public Object mair_planeitemlist(String ap_code ) {
	
	ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();

	try {
		
		sql = " select * from air_item where ap_code = ? ";        
		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, ap_code);
	
		
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







	public Object mair_pitemlist(String air_p ) {
	
	ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();

	try {
		
		sql = "select * from air_item where air_p = ? ";        
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
				res.setAir_code(rs.getString("air_code"));
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
	
	
	//관리자 비행기 리스트
	public Object airplanlistm() {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
		
		sql = "select distinct air_name , air_plane.ap_code  from air_com, air_item , air_plane where air_com.air_code=air_item.air_code and air_item.air_code = air_plane.air_code order by air_name  ";
		
		try {
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				Air_itemDTO dto = new Air_itemDTO();
				
				dto.setAir_name(rs.getString("air_name"));
				dto.setAp_code(rs.getString("ap_code"));
				
				res.add(dto) ;
				}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		return res;
	}
	
	//관리자 비행기 찾기
	public Object airplanedetailm(String air_name) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
		
		sql = "select distinct air_name , air_plane.ap_code  from air_com, air_item ,air_plane where air_com.air_code = air_item.air_code and  air_item.air_code = air_plane.air_code and air_name = ? order by air_name  ";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, air_name);
		
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				Air_itemDTO dto = new Air_itemDTO();
			
				dto.setAir_name(rs.getString("air_name"));
				dto.setAp_code(rs.getString("ap_code"));
				
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
	
	//협력업체 비행기 상품 찾기
	
	public ArrayList itemlistByAir_Code(Air_itemDTO dt) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();

		
		try {
			sql = "select * from air_item where air_code = ? ";       
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dt.getAir_code());

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
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
	
	
}
