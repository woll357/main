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
			
			sql="select air_item.ddate, air_item.darea, air_item.carea, air_item.seatcnt, air_item.flightclass, money, air_item.a_time, air_com.air_name,air_item.ap_Code,air_item.cCode from air_item, air_com " + 
				"where date(air_item.ddate)=date(?) and air_item.darea=? and air_item.carea =? and air_item.seatcnt>=? and air_item.flightclass=? and air_item.air_code=air_com.air_code order by money;";
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
	
	
	public Object searchHot(SearchDTO dto, int day) {
		
		ArrayList<SearchDTO> res = new ArrayList<SearchDTO>();
		ArrayList<SearchDTO> res2 = new ArrayList<SearchDTO>();
		LinkedHashMap<String, Integer> chk = new LinkedHashMap<String, Integer>();
		
		try {
			
			sql = "select room_item.rcode,room_item.rkind, room_item.rescnt, room_item.pcnt, "
					+ "room_item.cCode, room_item.money, hot_com.hinfo, hot_com.hname, hot_com.city, hot_com.country from room_item, hot_com " + 
					"where hot_com.city=? and room_item.pcnt>=? and room_item.rdate between ?  and ?  and room_item.hcode=hot_com.hcode and room_item.rescnt>0 and room_item.rkind=?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getCity());
			ptmt.setInt(2, dto.getPcnt());
			ptmt.setString(3, dto.getStartDay());
			ptmt.setString(4, dto.getEndDay());
			ptmt.setString(5, dto.getRkind());
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				dto = new SearchDTO();
				dto.setRkind(rs.getString("rkind"));
				dto.setRescnt(rs.getInt("rescnt"));
				dto.setPcnt(rs.getInt("pcnt"));
				dto.setcCode(rs.getString("cCode"));
				dto.setMoney(rs.getInt("money"));
				dto.setHname(rs.getString("hname"));
				dto.setCity(rs.getString("city"));
				dto.setCountry(rs.getString("country"));
				dto.setRcode(rs.getString("rcode"));
				dto.setHinfo(rs.getString("hinfo"));
				res.add(dto);
			}
			
			for (SearchDTO arr : res) {
				if(chk.size()==0 || !chk.containsKey(arr.getRcode())) {
					chk.put(arr.getRcode(), 1);
				}else {
					int a = chk.get(arr.getRcode())+1;
					chk.replace(arr.getRcode(), a);
				}
			}
			
			for (Entry<String, Integer> en : chk.entrySet()) {
				if(en.getValue()-1==day) {
					for (SearchDTO rr : res) {
						if(rr.getRcode().equals(en.getKey())) {
							res2.add(rr);
							break;
						}
					}
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
