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
	
	
	//관리자
	public Object air_pdetailm(Air_itemDTO dto) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			//air_itemDTO res = null;
			
			sql = "select * from air_item where air_p = ? and date(ddate)=date(?) " ;
		        //select * from air_item where air_p = 'TPI-200' and date(ddate)=date('2019-12-27');
			System.out.println("select * from air_item where air_p = 'TPI-200' and date(ddate)=date('2019-12-27') and air_code = 'AAA1012'");
			
			try {
			System.out.println("진입1"+ dto.getAir_p() + dto.getDdateStr2());	
		
				ptmt = con.prepareStatement(sql);
			
				ptmt.setString(1, dto.getAir_p());
				ptmt.setString(2, dto.getDdateStr2());


				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					
					System.out.println("진입2");
					
					dto = new Air_itemDTO();
					
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
	//총 게시글 구하기
	public int total(String air_code) {
		
		int res = 0;
		
		
		try {
			sql = "select count(*) from air_item where date(ddate) >= date( sysdate() ) and air_code = ?";        //총 게시물이 몇개냐
			
			ptmt = con.prepareStatement(sql);		
			ptmt.setString(1, air_code);
			rs = ptmt.executeQuery();
			
			rs.next() ;
				
			res = rs.getInt(1);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public int totalap(String ap_code) {
		
		int res = 0;
		
		
		try {
			sql = "select count(*) from air_item where date(ddate) >= date( sysdate() ) and ap_code = ?";        //총 게시물이 몇개냐
			
			ptmt = con.prepareStatement(sql);		
			ptmt.setString(1, ap_code);
			rs = ptmt.executeQuery();
			
			rs.next() ;
				
			res = rs.getInt(1);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	
	
	public int total() {
		
		int res = 0;
		
		
		try {
			sql = "select count(*) from air_item where date(ddate) >= date( sysdate() )";        //총 게시물이 몇개냐
			
			ptmt = con.prepareStatement(sql);		
	
			rs = ptmt.executeQuery();
			
			rs.next() ;
				
			res = rs.getInt(1);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	//총 게시글 구하기 지난상품
		public int total2(String air_code) {
			
			int res = 0;
			
			
			try {
				sql = "select count(*) from air_item where date(ddate) <= date( sysdate()) and air_code = ? ";        //총 게시물이 몇개냐
				
				ptmt = con.prepareStatement(sql);		
				ptmt.setString(1, air_code);
				rs = ptmt.executeQuery();
				
				rs.next() ;
					
				res = rs.getInt(1);
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
		}
		
	public int total2() {
			
			int res = 0;
			
			
			try {
				sql = "select count(*) from air_item where date(ddate) <= date( sysdate())  ";        //총 게시물이 몇개냐
				
				ptmt = con.prepareStatement(sql);		
			
				rs = ptmt.executeQuery();
				
				rs.next() ;
					
				res = rs.getInt(1);
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
		}
		
		
		//총 항공편 상품 개수 구하기 
		public int total3(String a) {
			
			int res = 0;
			
			
			try {
				System.out.println(a+"zzzzzzzzzzzzzzz");
				sql = "select count(*) from air_item where date(ddate) >= date( sysdate() ) and air_p = ? ";       
				
				ptmt = con.prepareStatement(sql);		
				
				ptmt.setString(1, a);
				rs = ptmt.executeQuery();
				
				rs.next() ;
					
				res = rs.getInt(1);
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
		}
//	

	//select air_name, air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code;
	
	//관리자
	
public Object air_pdetail(Air_itemDTO dto) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
				//air_itemDTO res = null;
				
				sql = "select * from air_item where air_p = ? and date(ddate)=date(?) and air_code = ? " ;
			        //select * from air_item where air_p = 'TPI-200' and date(ddate)=date('2019-12-27');
				System.out.println("select * from air_item where air_p = 'TPI-200' and date(ddate)=date('2019-12-27') and air_code = 'AAA1012'");
				
				try {
				System.out.println("진입1"+ dto.getAir_p() +  dto.getDdateStr2() + dto.getAir_code());	
			
					ptmt = con.prepareStatement(sql);
				
					ptmt.setString(1, dto.getAir_p());
					ptmt.setString(2, dto.getDdateStr2());
					ptmt.setString(3, dto.getAir_code());
		
					rs = ptmt.executeQuery();
					
					while(rs.next()) {
						
						System.out.println("진입2");
						
						dto = new Air_itemDTO();
						
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
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		return res;
	}
	
	
	
	//관리자 비행기 삭제
	//select * from air_item where air_code = 'AAA1012';
	public boolean airitemdelete(Air_itemDTO dto ) {
		
		boolean res = false;
		
		sql = "select * from air_item where air_code = ? ";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getAir_code());
			
		
			rs = ptmt.executeQuery();
			
			res = rs.next();
			//뭐라도 있으면 true
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		return res;
	}
	
	//관리자 비행기 삭제전  유효성
		public boolean airitemplanedelete(Air_itemDTO dto ) {
			
			boolean res = false;
			
			sql = "select * from air_item where ap_code = ? ";
			
			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getAp_code());
				
			
				rs = ptmt.executeQuery();
				
				res = rs.next();
				//뭐라도 있으면 true
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
			   close();
		  }
			       
			return res;
		}
	
	
	//상품등록 전 불린
	public boolean itemtimedetail(Air_itemDTO dto) {
		
		boolean res = false;
		
		sql = "select * from air_item where date(ddate)=date( ? ) and air_code = ? and ap_code = ? ";
		

			try {
				
				
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getDdateStr());
				ptmt.setString(2, dto.getAir_code());
				ptmt.setString(3, dto.getAp_code());
			
				System.out.println(dto.getDdateStr());
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

	
	
	//상품등록
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
		public Object yitemdetail(String air_code , int page , int limit) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			sql = "select * from air_item where date(ddate)<=date(sysdate())  and air_code = ? order by ddate and no limit ?, ?  ";
			
			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, air_code);
				ptmt.setInt(2, page);
				ptmt.setInt(3, limit);

				
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
		//비행기 지난상품 리스트
				//select * from air_item where date(ddate)<=date(sysdate())  and air_code = 'A1000'; 
				public Object yitemdetailm(int page , int limit) {
					
					ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
					
					sql = "select * from air_item where date(ddate)<=date(sysdate()) order by ddate and no limit ?, ?  ";
					
					try {
						ptmt = con.prepareStatement(sql);
					
						ptmt.setInt(1, page);
						ptmt.setInt(2, limit);

						
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
			
		
		
		
		public Object itemlist(String air_code , int page , int limit) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			
			
			try {
				sql = "select * from air_item where date(ddate)>=date(sysdate())  and air_code  = ? order by ddate , no limit ? , ? ";          //limit 를 이용해서 일부 글만 추출해오는것은 아무 문제가 없음.
				//limit 0, 3  - > 3개만 가져옴
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, air_code);
				ptmt.setInt(2, page);
				ptmt.setInt(3, limit);
				
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

		public Object itemlistm(int page , int limit) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
			
			
			
			try {
				sql = "select * from air_item where date(ddate)>=date(sysdate())  order by ddate , no limit ? , ?";         
				
				ptmt = con.prepareStatement(sql);
				ptmt.setInt(1, page);
				ptmt.setInt(2, limit);
				
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
				sql = "select distinct air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code  ";         
				
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
	
	
	
	
	   
	   public void update_seatcnt(Air_itemDTO dto) {
	      
	      try {
	         
	         sql = "update air_item set seatcnt = seatcnt + ? where ccode = ? ";
	         
	         ptmt = con.prepareStatement(sql);
	         
	         ptmt.setInt(1, dto.getSeatcnt());
	         ptmt.setString(2, dto.getCcode());
	   
	         ptmt.executeUpdate();
	   
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	   }
	
	
	
	
	public Object air_pitemlistsarch(String air_p , String air_code) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
		
		
		
		try {
			sql = "	select distinct air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code and air_item.air_p = ? and air_item.air_code = ? ";        
		
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, air_p);
			ptmt.setString(2, air_code);
			
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
	
	
	public Object air_pitemlistt(String a ) {
		
		ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
		
		
		
		try {
			sql = "	select distinct air_p , darea, carea from air_com, air_item where air_com.air_code=air_item.air_code and air_item.air_code = ? ";        
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, a);
	
			
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
		
public Object air_pitemlist3(String air_p , String air_code ,  int page , int limit) {
			
			ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
	
			try {
				sql = "select * from air_item where air_p = ? and date(ddate) >= date( sysdate() ) and air_code = ? and no limit ? , ? " ;          

				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, air_p);
				ptmt.setString(2, air_code);
				ptmt.setInt(3, page);
				ptmt.setInt(4, limit);
				
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


//비행기 날짜별 검색
public Object air_pdate(String ap_code , String air_code , String date) {
	
	ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
System.out.println("진입은 하니 .. ?!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	try {
		sql = "select * from air_item where ap_code = ? and date(ddate) = date( ? ) and air_code = ? " ;          

		System.out.println("아니 여기 안들어옴 ? ㅋㅋㅋㅋㅋㅋㅋ");
		System.out.println("에이피코드"+ap_code);
		System.out.println("데이트"+date);
		System.out.println("항공사코드"+air_code);
		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, ap_code);
		ptmt.setString(2, date);
		ptmt.setString(3, air_code);
		
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

//관리자
//비행기 날짜별 검색
public Object air_pdatem(String ap_code , String date) {
	
	ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();
System.out.println("진입은 하니 .. ?!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	try {
		sql = "select * from air_item where ap_code = ? and date(ddate) = date( ? ) " ;          


		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, ap_code);
		ptmt.setString(2, date);

		
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
public Object mair_planeitemlist(String ap_code , int page , int limit) {
	
	ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();

	try {
		
		sql = " select * from air_item where ap_code = ? and date(ddate) >= date( sysdate() ) and no limit ? , ? ;  ";        
		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, ap_code);
		ptmt.setInt(2, page);
		ptmt.setInt(3, limit);
		
		
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







	public Object mair_pitemlist(String air_p , int page , int limit ) {
	
	ArrayList<Air_itemDTO> res = new ArrayList<Air_itemDTO>();

	try {
		
		sql = "select * from air_item where air_p = ?  and date(ddate) >= date( sysdate() )  and no limit ?, ? ";   
		//select * from air_item where air_p = 'IPB-100';
		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, air_p);
		ptmt.setInt(2, page);
		ptmt.setInt(3, limit);
		
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
		
		sql = "select * from air_item where ccode = ? and date(ddate) >= date( sysdate() ) " ;
		
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
		
		ArrayList<Airp_detailsDTO> res = new ArrayList<Airp_detailsDTO>();
		
		sql = "select distinct air_com.air_name,  ap_code , air_com.air_code  , airp_details.air_ty , aircraft_type , linear_content , wings_width , numberof_sea , max_two , engine_type , tail_velocity , maximum_altitude , maximum_od ,flightclass from air_com, air_plane , airp_details where air_plane.air_ty =  airp_details.air_ty and air_plane.air_code = air_com.air_code order by air_name";
		
		try {
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				Airp_detailsDTO dto = new Airp_detailsDTO();
				
				 dto.setAir_name(rs.getString("air_name"));
				 dto.setAir_code(rs.getString("air_code"));
				 dto.setAp_code(rs.getString("ap_code"));
				 dto.setAir_ty(rs.getString("air_ty"));
				 dto.setAircraft_type(rs.getString("aircraft_type"));
				 dto.setLinear_content(rs.getString("linear_content"));
				 dto.setWings_width(rs.getString("wings_width"));
				 dto.setNumberof_sea(rs.getString("numberof_sea"));	 
				 dto.setMax_two(rs.getString("max_two"));
				 dto.setEngine_type(rs.getString("engine_type"));
				 dto.setTail_velocity(rs.getString("tail_velocity"));
				 dto.setMaximum_altitude(rs.getString("maximum_altitude"));
				 dto.setMaximum_od(rs.getString("maximum_od"));
				 dto.setFlightclass(rs.getString("flightclass"));
				 
				
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
	
	//관리자 비행기 코드로 상품 유효성
	//select * from air_item where air_code = "AAA101" ;
	public boolean aircomdelete(Air_itemDTO dto ) {
		
		boolean res = false;
		
		sql = "select * from air_item where air_code = ? ";
		
		try {
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getAir_code());
		
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
	
	
	
//관리자 ap 코드로 비행기 찾기
	public Object airplanedetailm(String ap_code) {
		
		ArrayList<Airp_detailsDTO> res = new ArrayList<Airp_detailsDTO>();
		
		sql = "select distinct air_com.air_name,  ap_code , air_com.air_code  , airp_details.air_ty , aircraft_type , linear_content , wings_width , numberof_sea , max_two , engine_type , tail_velocity , maximum_altitude , maximum_od ,flightclass from air_com, air_plane , airp_details where air_plane.air_ty =  airp_details.air_ty and air_plane.air_code = air_com.air_code and ap_code = ? ";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, ap_code);
		
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				Airp_detailsDTO dto = new Airp_detailsDTO();
			
				 dto.setAir_name(rs.getString("air_name"));
				 dto.setAir_code(rs.getString("air_code"));
				 dto.setAp_code(rs.getString("ap_code"));
				 dto.setAir_ty(rs.getString("air_ty"));
				 dto.setAircraft_type(rs.getString("aircraft_type"));
				 dto.setLinear_content(rs.getString("linear_content"));
				 dto.setWings_width(rs.getString("wings_width"));
				 dto.setNumberof_sea(rs.getString("numberof_sea"));	 
				 dto.setMax_two(rs.getString("max_two"));
				 dto.setEngine_type(rs.getString("engine_type"));
				 dto.setTail_velocity(rs.getString("tail_velocity"));
				 dto.setMaximum_altitude(rs.getString("maximum_altitude"));
				 dto.setMaximum_od(rs.getString("maximum_od"));
				 dto.setFlightclass(rs.getString("flightclass"));
				 
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
	
		public Air_itemDTO detail(Air_itemDTO dto) {
			
				//air_itemDTO res = null;
				
				sql = "select * from air_item where ccode = ? " ;
				
				try {
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, dto.getCcode());
		
					
					rs = ptmt.executeQuery();
					
					while(rs.next()) {
						
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
				
		
					}
							
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally {
				   close();
			  }
				       
				return dto;
			}
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
	
	
}
