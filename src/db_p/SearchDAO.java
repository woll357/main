package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SearchDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public SearchDAO() {
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
	
	public Object searchAir(SearchDTO dto) {
		
		ArrayList<SearchDTO> res = new ArrayList<SearchDTO>();

		try {
			
			sql="select air_com.img, air_item.ddate, air_item.darea, air_item.carea, air_item.seatcnt, air_item.flightclass, money, air_item.a_time, air_com.air_name,air_item.ap_Code,air_item.cCode from air_item, air_com " + 
				"where date(air_item.ddate)=date(?) and air_item.darea=? and air_item.carea =? and (air_item.totseatcnt-air_item.seatcnt)>=? and air_item.flightclass=? and air_item.air_code=air_com.air_code order by money;";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getDdate());
			ptmt.setString(2, dto.getDarea());
			ptmt.setString(3, dto.getCarea());
			ptmt.setInt(4, dto.getSeatcnt());
			ptmt.setString(5, dto.getFlightclass());
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				dto = new SearchDTO();
				dto.setDdate(rs.getString("ddate"));
				dto.setDarea(rs.getString("darea"));
				dto.setCarea(rs.getString("carea"));
				dto.setAp_Code(rs.getString("ap_Code"));
				dto.setMoney(rs.getInt("money"));
				dto.setA_time(rs.getString("a_time"));
				dto.setAir_name(rs.getString("air_name"));
				dto.setSeatcnt(rs.getInt("seatcnt"));
				dto.setcCode(rs.getString("cCode"));
				dto.setImg(rs.getString("img"));
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
	
	
	public Object searchHot(SearchDTO2 dto) {
		
		sql = "select distinct hcode from (" + 
				"select tt.*,ifnull(maxCnt, 0) as mCnt  from " + 
				"(select rt.*, ifnull(maxNo, 0) as mNo from " + 
				"(select * from room_item  where rkind = ? and pcnt >= ? and hcode in(" + 
				"select hcode from hot_com where city = ?)) rt " + 
				"LEFT OUTER JOIN " + 
				"(select rcode, max(norescnt) as maxNo from hold_table where noresdate >= ? and  noresdate < ? group by rcode) ht " + 
				"on ht.rcode = rt.rcode) tt " + 
				"LEFT OUTER JOIN " + 
				"(select rcode , max(dfCnt) as maxCnt from " + 
				"(select rcode, df,count(*) as dfCnt from " + 
				"(select rcode, date_format(ddate,'%Y-%m-%d') as df  from basketitem where ddate >= ? and  ddate < ? and bstatus = 'm') aa group by rcode, df) bb " + 
				" group by rcode) bt ON " + 
				"tt.rcode = bt.rcode) abc " + 
				"where rcnt > mNo + mCnt;";
		//등급, 인원, 지역, 시작날, 끝날, 시작날, 끝날
		
		ArrayList<SearchDTO2> res = new ArrayList<SearchDTO2>();
		ArrayList<SearchDTO2> res2 = new ArrayList<SearchDTO2>();
		String rkind = dto.getRkind();
		try {
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getRkind());
			ptmt.setInt(2, dto.getPcnt());
			ptmt.setString(3, dto.getCity());
			ptmt.setString(4, dto.getStartDay());
			ptmt.setString(5, dto.getEndDay());
			ptmt.setString(6, dto.getStartDay());
			ptmt.setString(7, dto.getEndDay());
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				dto = new SearchDTO2();
				dto.setHcode(rs.getString("hcode"));
				res.add(dto);
			}
			
			for (SearchDTO2 dd : res) {
				
				sql="select * from hot_com where hcode=?";
				
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dd.getHcode());
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					dto = new SearchDTO2();
					dto.setHcode(rs.getString("hcode"));
					dto.setCountry(rs.getString("country"));
					dto.setRkind(rkind);
					dto.setCity(rs.getString("city"));
					dto.setHname(rs.getString("hname"));
					dto.setHinfo(rs.getString("hinfo"));
					dto.setHimg(rs.getString("himg"));
					res2.add(dto);
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
		return res2;
	}
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
}
