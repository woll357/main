package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.directory.InitialDirContext;
import javax.sql.DataSource;

public class Hot_tempDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public Hot_tempDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialDirContext().lookup("java:comp/env/scanner");
			con =  ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void roomdelete(Room_itemDTO dto) {
		

		try {
			sql = "delete from room_item where rcode = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getRcode());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			close();
		}
		
	}
public void holddelete(Hold_tableDTO dto) {
	sql = "delete from hold_table where no = ?";
	try {
		ptmt = con.prepareStatement(sql);
		ptmt.setInt(1, dto.getNo());
		ptmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		close();
	}	
}
public SignUpDTO phonefind(Hot_comDTO dto) {
	SignUpDTO res = null;
		sql = "select phone from member where id=(select id from hot_com where hcode=?)";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.hcode);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				res = new SignUpDTO();
				res.setPhone(rs.getString("phone"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	
	return res;
}


	public Hot_comDTO detail2(Hot_comDTO dto) {
		Hot_comDTO res = null;
		
		sql = "select * from hot_com where hcode = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.hcode);
			rs=ptmt.executeQuery();
			if(rs.next()) {
				res = new Hot_comDTO();
				res.setId(rs.getString("id"));
				res.setHname(rs.getString("hname"));
				res.setCrn(rs.getString("crn"));
				res.setHimg(rs.getString("himg"));
				res.setCountry(rs.getString("country"));
				res.setCity(rs.getString("city"));
				res.setGrade(rs.getString("grade"));
				res.setHcode(rs.getString("hcode"));
				res.setHinfo(rs.getString("hinfo"));
				res.setAddDetail(rs.getString("adddetail"));
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
	
	public Hot_comDTO serarchByHotName(Hot_comDTO dto) {
		Hot_comDTO res = null;
		
		sql = "select * from hot_com where hname = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getHname());
			rs=ptmt.executeQuery();
			if(rs.next()) {
				res = new Hot_comDTO();
				res.setId(rs.getString("id"));
				res.setHname(rs.getString("hname"));
				res.setCrn(rs.getString("crn"));
				res.setHimg(rs.getString("himg"));
				res.setCountry(rs.getString("country"));
				res.setCity(rs.getString("city"));
				res.setGrade(rs.getString("grade"));
				res.setHcode(rs.getString("hcode"));
				res.setHinfo(rs.getString("hinfo"));
				res.setAddDetail(rs.getString("adddetail"));
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
	
	
	public ArrayList<Hot_comDTO> countrysearch(Hot_comDTO rr, int page, int limit) {
		ArrayList<Hot_comDTO> res = new ArrayList<Hot_comDTO>();
		
		sql = "select * from hot_com where country = ? order by no limit ?, ?";	
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, rr.country);
			ptmt.setInt(2, page);
			ptmt.setInt(3, limit);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				Hot_comDTO dto = new Hot_comDTO();
				dto.setId(rs.getString("id"));
				dto.setHname(rs.getString("hname"));
				dto.setCrn(rs.getString("crn"));
				dto.setHimg(rs.getString("himg"));
				dto.setCountry(rs.getString("country"));
				dto.setCity(rs.getString("city"));
				dto.setGrade(rs.getString("grade"));
				dto.setHinfo(rs.getString("hinfo"));
				dto.setAddDetail(rs.getString("adddetail"));
				dto.setHcode(rs.getString("hcode"));
				res.add(dto);			
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

	
	
	
	public Object hotelsearch(Hot_comDTO rr) {
		ArrayList<Hot_comDTO> res = new ArrayList<Hot_comDTO>();
		
		sql = "select * from hot_com where hcode = ?";	
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, rr.hcode);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				Hot_comDTO dto = new Hot_comDTO();
				dto.setId(rs.getString("id"));
				dto.setHname(rs.getString("hname"));
				dto.setCrn(rs.getString("crn"));
				dto.setHimg(rs.getString("himg"));
				dto.setCountry(rs.getString("country"));
				dto.setCity(rs.getString("city"));
				dto.setGrade(rs.getString("grade"));
				dto.setHinfo(rs.getString("hinfo"));
				dto.setAddDetail(rs.getString("adddetail"));
				dto.setHcode(rs.getString("hcode"));
				res.add(dto);			
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
	
	public void delewrite(DereDTO dto) {
		

		
		try {
			
			sql = "insert into dere "
					+ " (id,kind,Code,request,requestdate) values "
					+ " (? ,? ,? ,? ,sysdate());";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getKind());
			ptmt.setString(3, dto.getCode());
			ptmt.setString(4, dto.getRequest());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
	}
	
	public void roomwrite(Room_itemDTO dto) {

		try {
			sql = "insert into room_item" 
					+ " (rkind, rcnt, pcnt, rimg, hcode,  money, wifi, morning,wmoney) values"
				    + " (?, ? , ? ,? , ?, ?, ?, ?,?)";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getRkind());
			ptmt.setInt(2, dto.getRcnt());
			ptmt.setInt(3, dto.getPcnt());
			ptmt.setString(4, dto.getRimg());
			ptmt.setString(5, dto.getHcode());
			ptmt.setInt(6, dto.getMoney());
			ptmt.setString(7, dto.getWifi());
			ptmt.setString(8, dto.getMorning());
			ptmt.setInt(9, dto.getWmoney());
			ptmt.executeUpdate();
			
			sql = "update room_item set rcode = concat(hcode , '-' , rkind,no) where hcode = ?";
			 ptmt = con.prepareStatement(sql);
			 ptmt.setString(1, dto.getHcode());
			 ptmt.executeUpdate();
			 
			 
			 System.out.println("ER,MGPRJPROEGJ여기여기여기");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
	}
	
	public void write(Hot_tempDTO dto) {
		
/*		sql = "insert into board "
				+ "(seq, level, no, title, pname, pw, content, upfile, regdate ) values "
				+ "(0    ,  0  ,-1,  ? ,  ? ,   ? ,  ? , ? ,  sysdate() )";*/
		
		
		try {
			sql = "insert into hot_temp " 
					+ " (id, crn, himg, hname, hinfo, grade, time, country, city) values "
					+ " (?, ?, ?, ?, ?, ?, sysdate(),? ,? )";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getCrn());
			ptmt.setString(3, dto.getHimg());
			ptmt.setString(4, dto.getHname());
			ptmt.setString(5, dto.getHinfo());
			ptmt.setString(6, dto.getGrade());
			ptmt.setString(7, dto.getCountry());
			ptmt.setString(8, dto.getCity());
			ptmt.executeUpdate();
			
			sql = "insert into hot_com " 
					+ " (id, crn, himg, hname, hinfo, grade, country, city) values "
					+ " (?, ?, ?, ?, ?, ? ,? ,?)";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getCrn());
			ptmt.setString(3, dto.getHimg());
			ptmt.setString(4, dto.getHname());
			ptmt.setString(5, dto.getHinfo());
			ptmt.setString(6, dto.getGrade());
			ptmt.setString(7, dto.getCountry());
			ptmt.setString(8, dto.getCity());
			ptmt.executeUpdate();
			
			
			 sql = "update hot_com set hcode = concat(grade,no) where id = ?";
			  
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
	
	public void noreswrite(Hold_tableDTO dto) {
		
		try {
			sql = "insert into hold_table "
					+ "(rcode, noresdate, norescnt, reason) values"
					+ " (?,?,?,?)";		
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1,dto.getRcode());
			ptmt.setString(2, dto.getNoresdateStr());
			ptmt.setInt(3, dto.getNorescnt());
			ptmt.setString(4, dto.getReason());
			
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			close();
		}

	}
	
	public Object noreslist(Hold_tableDTO rr) {
		ArrayList<Hold_tableDTO> res = new ArrayList<Hold_tableDTO>();
		
		sql = "select * from hold_table where rcode = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, rr.rcode);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				Hold_tableDTO dto = new Hold_tableDTO();
				dto.setNo(rs.getInt("no"));
				dto.setNorescnt(rs.getInt("norescnt"));
				dto.setNoresdate(rs.getDate("noresdate"));
				dto.setReason(rs.getString("reason"));
				dto.setRcode(rs.getString("rcode")); 
				res.add(dto);
				
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
	
	public Object roomlist(Room_itemDTO rr) {
		ArrayList<Room_itemDTO> res = new ArrayList<Room_itemDTO>();
		
		sql = "select * from room_item where hcode = ? ";
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, rr.hcode);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				Room_itemDTO dto = new Room_itemDTO();
				dto.setRkind(rs.getString("rkind"));
				dto.setRcnt(rs.getInt("rcnt"));
				dto.setPcnt(rs.getInt("pcnt"));
				dto.setRimg(rs.getString("rimg"));
				dto.setHcode(rs.getString("hcode"));
				dto.setRcode(rs.getString("rcode"));
				dto.setMoney(rs.getInt("money"));
				dto.setWifi(rs.getString("wifi"));
				dto.setMorning(rs.getString("morning"));
				dto.setWmoney(rs.getInt("wmoney"));
				res.add(dto);
				System.out.println(rs.getString("rkind"));
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
	
	public Object list(int page, int limit) {
		ArrayList<Hot_comDTO> res = new ArrayList<Hot_comDTO>();
		
		sql = "select * from hot_com order by no limit ?, ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, page);
			ptmt.setInt(2, limit);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				Hot_comDTO dto = new Hot_comDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setHname(rs.getString("hname"));
				dto.setCrn(rs.getString("crn"));
				dto.setHimg(rs.getString("himg"));
				dto.setCountry(rs.getString("country"));
				dto.setCity(rs.getString("city"));
				dto.setGrade(rs.getString("grade"));
				dto.setHinfo(rs.getString("hinfo"));
				dto.setAddDetail(rs.getString("adddetail"));
				dto.setHcode(rs.getString("hcode"));
				res.add(dto);
				
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
	
	public int total() {  //전체 글수 가져오기
		int res = 0;
				
		try {
			sql = "select count(*) from hot_com";
			
			ptmt = con.prepareStatement(sql);

			rs = ptmt.executeQuery();
			rs.next();
			res = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			close();
		}	
		return res;
	}
	public int total2(Hot_comDTO dto) {
		int res = 0;
		
		sql = "select count(*) from hot_com where country=?";
			try {
				ptmt=con.prepareStatement(sql);
				ptmt.setString(1, dto.country);
				rs = ptmt.executeQuery();
				rs.next();
				res = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			finally {
				close();
			}	
		return res;
	}
	
	public int norescnt(BasketItemDTO dto, String date) {
		int res = 0;
		
		sql = "select count(*) from basketitem where rcode = ? and date(ddate) = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getRcode());
			ptmt.setString(2, date);
			rs = ptmt.executeQuery();
			rs.next();
			res = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}	
		
		
		return res;
	}
	
	public int rescnt(BasketItemDTO dto) {
		int res = 0;
		
		sql = "select count(*) from basketitem where rcode = ? and bstatus = 'm'";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getRcode());
			rs = ptmt.executeQuery();
			rs.next();
			res = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
		
		
		return res;
	}
	
	public Hot_comDTO detail(Hot_comDTO dto) {
		Hot_comDTO res = null;
		
		sql = "select * from hot_com where id = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.id);
			rs=ptmt.executeQuery();
			if(rs.next()) {
				res = new Hot_comDTO();
				res.setId(rs.getString("id"));
				res.setHname(rs.getString("hname"));
				res.setCrn(rs.getString("crn"));
				res.setHimg(rs.getString("himg"));
				res.setCountry(rs.getString("country"));
				res.setCity(rs.getString("city"));
				res.setGrade(rs.getString("grade"));
				res.setHcode(rs.getString("hcode"));
				res.setHinfo(rs.getString("hinfo"));
				res.setAddDetail(rs.getString("adddetail"));

				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		//System.out.println(res.getHnation()+res.getHarea());
		return res;
	}
	
	public void hotmodify(Hot_comDTO dto) {

		try {
			sql = "update hot_com set country = ?, city = ?, himg = ?, hinfo =?, hname=? "
					+ "where id = ?";
			ptmt = con.prepareStatement(sql);

			ptmt.setString(1, dto.getCountry());
			ptmt.setString(2, dto.getCity());
			ptmt.setString(3, dto.getHimg());
			ptmt.setString(4, dto.getHinfo());
			ptmt.setString(5, dto.getHname());
			ptmt.setString(6, dto.getId());
			ptmt.executeUpdate();
			System.out.println(dto.getHname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}	
	}
	
	public void roommodify(Room_itemDTO dto) {
		
		try {
			sql = "update room_item set rkind = ?, rcnt = ?, pcnt = ?, rimg = ?, money = ?, wmoney = ?, wifi = ?, morning = ?" 
					+ " where rcode = ?";
					
		
			ptmt=con.prepareStatement(sql);
			ptmt.setString(1, dto.getRkind());
			ptmt.setInt(2,dto.getRcnt());
			ptmt.setInt(3, dto.getPcnt());
			ptmt.setString(4, dto.getRimg());
			ptmt.setInt(5, dto.getMoney());
			ptmt.setInt(6, dto.getWmoney());
			ptmt.setString(7, dto.getWifi());
			ptmt.setString(8, dto.getMorning());
			ptmt.setString(9, dto.getRcode());
			ptmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {		
			close();
		}	
		
	}
	
	public Hot_comDTO fileDelete(Hot_comDTO dto) {
		Hot_comDTO res = null;
		
		sql = "select * from hot_com where  id = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.id);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				res = new Hot_comDTO();
				res.setId(rs.getString("id"));
				res.setHname(rs.getString("hname"));
				res.setCrn(rs.getString("crn"));
				res.setHimg(rs.getString("himg"));
				res.setCountry(rs.getString("country"));
				res.setCity(rs.getString("city"));
				res.setGrade(rs.getString("grade"));
				res.setHinfo(rs.getString("hinfo"));
				res.setAddDetail(rs.getString("adddetail"));
				
				sql = "update hot_com set himg = null where id = ?";
				
				ptmt = con.prepareStatement(sql);
				

				ptmt.setString(1, dto.getId());

				
				ptmt.executeUpdate();
				

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
	
	public Hot_comDTO fileDelete22(Hot_comDTO dto) {
		Hot_comDTO res = null;
		
		sql = "select * from hot_com where  hcode = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.hcode);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				res = new Hot_comDTO();
				res.setId(rs.getString("id"));
				res.setHname(rs.getString("hname"));
				res.setCrn(rs.getString("crn"));
				res.setHimg(rs.getString("himg"));
				res.setCountry(rs.getString("country"));
				res.setCity(rs.getString("city"));
				res.setGrade(rs.getString("grade"));
				res.setHinfo(rs.getString("hinfo"));
				res.setAddDetail(rs.getString("adddetail"));
				
				sql = "update hot_com set himg = null where hcode = ?";
				
				ptmt = con.prepareStatement(sql);
				

				ptmt.setString(1, dto.getId());

				
				ptmt.executeUpdate();
				

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
	
	
	public Room_itemDTO filedelete2(Room_itemDTO dto) {
		Room_itemDTO res = null;
		
		sql = "select * from Room_item where rcode = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.rcode);	
			rs=ptmt.executeQuery();
			if(rs.next()) {
				res = new Room_itemDTO();
				res.setRkind(rs.getString("rkind"));
				res.setRcnt(rs.getInt("rcnt"));
				res.setPcnt(rs.getInt("pcnt"));
				res.setRimg(rs.getString("rimg"));
				res.setHcode(rs.getString("hcode"));
				res.setMoney(rs.getInt("money"));
				res.setWmoney(rs.getInt("wmoney"));
				res.setWifi(rs.getString("wifi"));
				res.setMorning(rs.getString("morning"));
				
				sql = "update room_item set rimg = null where rcode = ?";
				
				ptmt = con.prepareStatement(sql);
				

				ptmt.setString(1, dto.getRcode());
				ptmt.executeUpdate();
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
	
	
	public Room_itemDTO roomdetail(Room_itemDTO dto) {
		Room_itemDTO res = null;
		
		sql = "select * from room_item where rcode = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.rcode);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				res = new Room_itemDTO();
				res.setRkind(rs.getString("rkind"));
				res.setRcnt(rs.getInt("rcnt"));
				res.setPcnt(rs.getInt("pcnt"));
				res.setRimg(rs.getString("rimg"));
				res.setHcode(rs.getString("hcode"));
				res.setRcode(rs.getString("rcode"));
				res.setMoney(rs.getInt("money"));
				res.setWmoney(rs.getInt("wmoney"));
				res.setWifi(rs.getString("wifi"));
				res.setMorning(rs.getString("morning"));
				
				
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
	
	
	
	public Room_itemDTO roomDetailByrcode(Room_itemDTO dto) {
		Room_itemDTO res = new Room_itemDTO();
		sql = "select * from room_item where rcode = ? ";
		try {
			
			System.out.println("진입했니 룸디테일?");
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getRcode());
			rs = ptmt.executeQuery();
			if(rs.next()) {
				res.setRkind(rs.getString("rkind"));
				res.setRcnt(rs.getInt("rcnt"));
				res.setPcnt(rs.getInt("pcnt"));
				res.setRimg(rs.getString("rimg"));
				res.setHcode(rs.getString("hcode"));
				res.setRcode(rs.getString("rcode"));
				res.setMoney(rs.getInt("money"));
				res.setWmoney(rs.getInt("wmoney"));
				res.setWifi(rs.getString("wifi"));
				res.setMorning(rs.getString("morning"));
				
				System.out.println(rs.getString("hcode"));
				
				
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
		
		public Hot_comDTO hotelDetailByhcode(Hot_comDTO dto) {
			Hot_comDTO res = null;
			
			System.out.println("호텔상세 진입했니?");
			System.out.println(dto.getHcode());
			
			sql = "select * from hot_com where hcode = ?";
			
			System.out.println("sql실행하니?"+sql);
			
			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getHcode());
				rs=ptmt.executeQuery();
				if(rs.next()) {
					res = new Hot_comDTO();
					res.setId(rs.getString("id"));
					res.setCrn(rs.getString("crn"));
					res.setHimg(rs.getString("himg"));
					res.setHname(rs.getString("hname"));
					res.setCountry(rs.getString("country"));
					res.setCity(rs.getString("city"));
					res.setHinfo(rs.getString("hinfo"));
					res.setHcode(rs.getString("hcode"));
					res.setAddDetail(rs.getString("addDetail"));
					res.setGrade(rs.getString("grade")); //이름
					
					System.out.println("호텔이름 뭐니?"+rs.getString("hname"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				close();
			}
			
			//System.out.println(res.getHnation()+res.getHarea());
			return res;
		}
		
		public Hold_tableDTO detailHoldByDdateRcode(Hold_tableDTO dto) {	
			
			Hold_tableDTO res = new Hold_tableDTO();
			
				sql = "select * from hold_table where rcode = ? and noresdate = date(?) ";
				try {
					
					ptmt = con.prepareStatement(sql);
					
					ptmt.setString(1, dto.getRcode());
					ptmt.setString(2, dto.getNoresdateStr());
		
					rs = ptmt.executeQuery();
					
					if(rs.next()) {				
					res.setRcode(rs.getString("rcode"));
					res.setNorescnt(rs.getInt("norescnt"));
					res.setNoresdateStr(rs.getString("noresdate"));
					res.setReason(rs.getString("reason"));
					res.setNo(rs.getInt("no"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					close();
				}
				return res;
			}
	
		public ArrayList<Hot_comDTO> hotelList() {
			ArrayList<Hot_comDTO> res = new ArrayList<Hot_comDTO>();
			
			sql = "select * from hot_com";	
			try {
				ptmt = con.prepareStatement(sql);
				rs = ptmt.executeQuery();
				while(rs.next()) {
					Hot_comDTO dto = new Hot_comDTO();
					dto.setId(rs.getString("id"));
					dto.setHname(rs.getString("hname"));
					dto.setCrn(rs.getString("crn"));
					dto.setHimg(rs.getString("himg"));
					dto.setCountry(rs.getString("country"));
					dto.setCity(rs.getString("city"));
					dto.setGrade(rs.getString("grade"));
					dto.setHinfo(rs.getString("hinfo"));
					dto.setAddDetail(rs.getString("adddetail"));
					dto.setHcode(rs.getString("hcode"));
					dto.setSalesPercent(rs.getDouble("salesPercent"));
					res.add(dto);			
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
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(ptmt!=null)
			try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	
}
