package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BasketpaidDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public BasketpaidDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public ArrayList<BasketpaidDTO> myList(BasketpaidDTO dto) {
		ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
		
		try {
			
			sql = "select * from basketpaid where id = ? and (bstatus= 'p' or bstatus = 'n') ";
			ptmt = con.prepareStatement(sql);
			System.out.println(sql);
			
			ptmt.setString(1, dto.getId());
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				dto = new BasketpaidDTO();
				dto.setPno(rs.getInt("pno"));
				dto.setBasketID(rs.getString("basketID"));
				dto.setcType(rs.getString("cType"));
				dto.setcNum(rs.getInt("cNum"));
				dto.setcName(rs.getString("cName"));
				dto.setItemName(rs.getString("itemName"));
				dto.setDdate(rs.getTimestamp("ddate"));
				dto.setFdate(rs.getTimestamp("fdate"));
				dto.setLocation1(rs.getString("location1"));
				dto.setLocation2(rs.getString("location2"));
				dto.setTotalPrice(rs.getInt("totalPrice"));
				dto.setPsn(rs.getInt("psn"));
				dto.setBcode(rs.getString("bcode"));
				dto.setId(rs.getString("id"));
				dto.setBstatus(rs.getString("bstatus"));
				
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
	
	public ArrayList<BasketpaidDTO> myReserveList(BasketpaidDTO dto) {
		ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
		
		try {
			
			sql = "select * from basketpaid where id = ? and bstatus= 'm'";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getId());
	
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				dto = new BasketpaidDTO();
				dto.setPno(rs.getInt("pno"));
				dto.setBasketID(rs.getString("basketID"));
				dto.setcType(rs.getString("cType"));
				dto.setcNum(rs.getInt("cNum"));
				dto.setcName(rs.getString("cName"));
				dto.setItemName(rs.getString("itemName"));
				dto.setDdate(rs.getTimestamp("ddate"));
				dto.setFdate(rs.getTimestamp("fdate"));
				dto.setLocation1(rs.getString("location1"));
				dto.setLocation2(rs.getString("location2"));
				dto.setTotalPrice(rs.getInt("totalPrice"));
				dto.setPsn(rs.getInt("psn"));
				dto.setBcode(rs.getString("bcode"));
				dto.setId(rs.getString("id"));
				dto.setBstatus(rs.getString("bstatus"));
				
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
	
	public ArrayList<BasketpaidDTO> myRefundList(BasketpaidDTO dto) {					//장바구니에 몇개있니?
		ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
		
		try {
			
			sql = "select * from basketpaid where id = ? and bstatus= 'r'";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getId());
	
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				dto = new BasketpaidDTO();
				dto.setPno(rs.getInt("pno"));
				dto.setBasketID(rs.getString("basketID"));
				dto.setcType(rs.getString("cType"));
				dto.setcNum(rs.getInt("cNum"));
				dto.setcName(rs.getString("cName"));
				dto.setItemName(rs.getString("itemName"));
				dto.setDdate(rs.getTimestamp("ddate"));
				dto.setFdate(rs.getTimestamp("fdate"));
				dto.setLocation1(rs.getString("location1"));
				dto.setLocation2(rs.getString("location2"));
				dto.setTotalPrice(rs.getInt("totalPrice"));
				dto.setPsn(rs.getInt("psn"));
				dto.setBcode(rs.getString("bcode"));
				dto.setId(rs.getString("id"));
				dto.setBstatus(rs.getString("bstatus"));
				
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
	
	public ArrayList<BasketpaidDTO> justBuyList(BasketpaidDTO dto) {					//장바구니에 몇개있니?
		
		ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
		
		try {
			
			sql = "select * from basketpaid where bcode = ?";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getBcode());
	
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				dto = new BasketpaidDTO();
				dto.setPno(rs.getInt("pno"));
				dto.setBasketID(rs.getString("basketID"));
				dto.setcType(rs.getString("cType"));
				dto.setcNum(rs.getInt("cNum"));
				dto.setcName(rs.getString("cName"));
				dto.setItemName(rs.getString("itemName"));
				dto.setDdate(rs.getTimestamp("ddate"));
				dto.setFdate(rs.getTimestamp("fdate"));
				dto.setLocation1(rs.getString("location1"));
				dto.setLocation2(rs.getString("location2"));
				dto.setTotalPrice(rs.getInt("totalPrice"));
				dto.setPsn(rs.getInt("psn"));
				dto.setBcode(rs.getString("bcode"));
				dto.setId(rs.getString("id"));
				dto.setBstatus(rs.getString("bstatus"));

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
	
	
	public void insert(BasketpaidDTO dto) {		//값을 넣준다.

		
		try {

			sql = "insert into basketpaid "
					+ "(cNum, id, psn, ddate, fdate, cType, bcode, totalPrice, location1, location2, cName, itemName, basketID, code) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);
			
			System.out.println(dto.getDdateStr());
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getcNum());
			ptmt.setString(2, dto.getId());
			ptmt.setInt(3, dto.getPsn());
			ptmt.setString(4, dto.getDdateStr());
			ptmt.setString(5, dto.getFdateStr());
			ptmt.setString(6, dto.getcType());
			ptmt.setString(7, dto.getBcode());
			ptmt.setInt(8, dto.getTotalPrice());
			ptmt.setString(9, dto.getLocation1());
			ptmt.setString(10, dto.getLocation2());
			ptmt.setString(11, dto.getcName());
			ptmt.setString(12, dto.getItemName());
			ptmt.setString(13, dto.getBasketID());
			ptmt.setString(14, dto.getCode());
			
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
		public BasketpaidDTO detail(BasketpaidDTO dto) {	
			
			BasketpaidDTO res = new BasketpaidDTO();
			
			sql = "select * from basketpaid where basketID = ? ";
			
			System.out.println(sql);
			
			try {
				System.out.println("BasketpaidDTO detail 진입하니??");
	
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getBasketID());
	
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
				
				res.setBasketID(rs.getString("basketID"));
				res.setcType(rs.getString("cType"));
				res.setcNum(rs.getInt("cNum"));
				res.setcName(rs.getString("cName"));
				res.setItemName(rs.getString("itemName"));
				res.setDdate(rs.getTimestamp("ddate"));
				res.setFdate(rs.getTimestamp("fdate"));
				res.setLocation1(rs.getString("location1"));
				res.setLocation2(rs.getString("location2"));
				res.setTotalPrice(rs.getInt("totalPrice"));
				res.setPsn(rs.getInt("psn"));
				res.setBcode(rs.getString("bcode"));
				res.setId(rs.getString("id"));
				res.setBstatus(rs.getString("bstatus"));
				res.setCode(rs.getString("code"));
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				close();
			}
			
			return res;
		}
	
		public void modifyBstatus(BasketpaidDTO dto) {
			
			sql = "update basketpaid set bstatus = ? "
					+ " where basketID = ?";
					
		System.out.println(sql);
		
		try {
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getBstatus());
			ptmt.setString(2, dto.getBasketID());
			
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		}
		
		public ArrayList<BasketpaidDTO> comRefundList(BasketpaidDTO dto) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.itemName, basketpaid.ddate, basketpaid.fdate , buy.bdate, basketpaid.id from basketpaid, buy "
						+ "where basketpaid.bcode = buy.bcode and basketpaid.cName = ? and basketpaid.bstatus = 'r'";
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getcName());
		
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					dto = new BasketpaidDTO();
					dto.setcName(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					dto.setFdateStr(rs.getString(4));
					dto.setBdateStr(rs.getString(5));
					dto.setId(rs.getString(6));
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
		
		public ArrayList<BasketpaidDTO> dateRefundList(String start, String end) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.itemName,basketpaid.ddate, basketpaid.fdate , buy.bdate, basketpaid.id, basketpaid.cType from basketpaid, buy "
						+ "where basketpaid.bcode = buy.bcode and date(bdate) between ? and ? and "
								+ "basketpaid.bstatus = 'r'";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, start);
				ptmt.setString(2, end);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					dto.setcName(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					dto.setFdateStr(rs.getString(4));
					dto.setBdateStr(rs.getString(5));
					dto.setId(rs.getString(6));
					dto.setcType(rs.getString(7));
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
		
		public ArrayList<BasketpaidDTO> comReserveList(BasketpaidDTO dto) {		//회사 예약 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.itemName, basketpaid.ddate, basketpaid.fdate , basketpaid.id, basketpaid.psn, basketpaid.cType from basketpaid, buy "
						+ "where basketpaid.bcode = buy.bcode and basketpaid.cName = ? and basketpaid.bstatus = 'm'";
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getcName());
		
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					dto = new BasketpaidDTO();
					dto.setcName(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					dto.setFdateStr(rs.getString(4));
					dto.setId(rs.getString(5));
					dto.setPsn(rs.getInt(6));
					dto.setcType(rs.getString(7));
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
		
		public ArrayList<BasketpaidDTO> dateReserveList(String startday, String endday) {		//날짜별 예약갯수
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			System.out.println("dateReserveList 실행되니?");
			try {
				
				sql = "select * from basketpaid where bstatus = 'm' and date(ddate) between ? and ? ";
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, startday);
				ptmt.setString(2, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					System.out.println("dateReserveList 결과는 있니?");
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setPno(rs.getInt("pno"));
					dto.setBasketID(rs.getString("basketID"));
					dto.setcType(rs.getString("cType"));
					dto.setcNum(rs.getInt("cNum"));
					dto.setcName(rs.getString("cName"));
					dto.setItemName(rs.getString("itemName"));
					dto.setDdate(rs.getTimestamp("ddate"));
					dto.setFdate(rs.getTimestamp("fdate"));
					dto.setLocation1(rs.getString("location1"));
					dto.setLocation2(rs.getString("location2"));
					dto.setTotalPrice(rs.getInt("totalPrice"));
					dto.setPsn(rs.getInt("psn"));
					dto.setBcode(rs.getString("bcode"));
					dto.setId(rs.getString("id"));
					dto.setBstatus(rs.getString("bstatus"));
					System.out.println(dto.getBasketID()+"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
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
		
		public ArrayList<BasketpaidDTO> dateReserveListDay(String startday) {		//날짜별 예약갯수
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			System.out.println("dateReserveList 실행되니?");
			try {
				
				sql = "select * from basketpaid where bstatus = 'm' and date(ddate) = ? ";
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, startday);

				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					System.out.println("dateReserveList 결과는 있니?");
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setPno(rs.getInt("pno"));
					dto.setBasketID(rs.getString("basketID"));
					dto.setcType(rs.getString("cType"));
					dto.setcNum(rs.getInt("cNum"));
					dto.setcName(rs.getString("cName"));
					dto.setItemName(rs.getString("itemName"));
					dto.setDdate(rs.getTimestamp("ddate"));
					dto.setFdate(rs.getTimestamp("fdate"));
					dto.setLocation1(rs.getString("location1"));
					dto.setLocation2(rs.getString("location2"));
					dto.setTotalPrice(rs.getInt("totalPrice"));
					dto.setPsn(rs.getInt("psn"));
					dto.setBcode(rs.getString("bcode"));
					dto.setId(rs.getString("id"));
					dto.setBstatus(rs.getString("bstatus"));
					System.out.println(dto.getBasketID()+"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
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
		
		public ArrayList<BasketpaidDTO> buyListByDate(String startday, String endday) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select * from basketpaid where date(ddate) between ? and ? and (bstatus = 'p' or bstatus = 'n') ";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, startday);
				ptmt.setString(2, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();

					dto.setPno(rs.getInt("pno"));
					dto.setBasketID(rs.getString("basketID"));
					dto.setcType(rs.getString("cType"));
					dto.setcNum(rs.getInt("cNum"));
					dto.setcName(rs.getString("cName"));
					dto.setItemName(rs.getString("itemName"));
					dto.setDdate(rs.getTimestamp("ddate"));
					dto.setFdate(rs.getTimestamp("fdate"));
					dto.setLocation1(rs.getString("location1"));
					dto.setLocation2(rs.getString("location2"));
					dto.setTotalPrice(rs.getInt("totalPrice"));
					dto.setPsn(rs.getInt("psn"));
					dto.setBcode(rs.getString("bcode"));
					dto.setId(rs.getString("id"));
					dto.setBstatus(rs.getString("bstatus"));
					
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
		
		public ArrayList<BasketpaidDTO> buyListByDateDay(String startday) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select * from basketpaid where bstatus = 'p' or basketpaid.bstatus = 'n' and date(ddate) = ? ";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();

					dto.setPno(rs.getInt("pno"));
					dto.setBasketID(rs.getString("basketID"));
					dto.setcType(rs.getString("cType"));
					dto.setcNum(rs.getInt("cNum"));
					dto.setcName(rs.getString("cName"));
					dto.setItemName(rs.getString("itemName"));
					dto.setDdate(rs.getTimestamp("ddate"));
					dto.setFdate(rs.getTimestamp("fdate"));
					dto.setLocation1(rs.getString("location1"));
					dto.setLocation2(rs.getString("location2"));
					dto.setTotalPrice(rs.getInt("totalPrice"));
					dto.setPsn(rs.getInt("psn"));
					dto.setBcode(rs.getString("bcode"));
					dto.setId(rs.getString("id"));
					dto.setBstatus(rs.getString("bstatus"));
					
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
		
		public BasketpaidDTO giveSalesPercentAir(BasketpaidDTO dto) {	
			
			
			sql = "select air_com.salesPercent "
					+ "from basketpaid, air_com where basketpaid.cName = air_com.air_name and basketpaid.basketID = ?";
			
			System.out.println(sql);
			
			try {

				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getBasketID());
	
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
				
					dto.setSalesPercent(rs.getDouble(1));
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				close();
			}
			
			return dto;
		}
		
		public BasketpaidDTO giveSalesPercentHot(BasketpaidDTO dto) {	
			
			sql =  "select hot_com.salesPercent "
					+ "from basketpaid, hot_com where basketpaid.cName = hot_com.hname and basketpaid.basketID = ?";
			
			System.out.println(sql);
			
			try {

				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getBasketID());
	
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
				
				dto.setSalesPercent(rs.getDouble(1));
				System.out.println("호텔에서 얼마나 가지고가?"+dto.getSalesPercent());
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				close();
			}
			
			return dto;
		}
		
		public ArrayList<BasketpaidDTO> buyListByAirComDate(String comcode, String startday, String endday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.cType, basketpaid.itemName, basketpaid.ddate, "
						+ "basketpaid.psn, basketpaid.totalPrice, air_com.salesPercent "
						+ "from basketpaid, air_com where basketpaid.cName = air_com.air_name and "
						+ "air_com.air_code = ? and date(basketpaid.ddate) between ? and ? "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') ";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, comcode);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();

					dto.setcName(rs.getString(1));
					dto.setcType(rs.getString(2));
					dto.setItemName(rs.getString(3));
					dto.setDdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setTotalPrice(rs.getInt(6));
					dto.setSalesPercent(rs.getDouble(7));
					
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
		
		public ArrayList<BasketpaidDTO> buyListByAirComDateDay(String comcode, String startday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.cType, basketpaid.itemName, basketpaid.ddate, "
						+ "basketpaid.psn, basketpaid.totalPrice, air_com.salesPercent "
						+ "from basketpaid, air_com where basketpaid.cName = air_com.air_name and "
						+ "air_com.air_code = ? and date(basketpaid.ddate) = ? "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n')";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, comcode);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();

					dto.setcName(rs.getString(1));
					dto.setcType(rs.getString(2));
					dto.setItemName(rs.getString(3));
					dto.setDdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setTotalPrice(rs.getInt(6));
					dto.setSalesPercent(rs.getDouble(7));
					
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
		
		public ArrayList<BasketpaidDTO> buyListByHotComDate(String comcode, String startday, String endday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.cType, basketpaid.itemName, basketpaid.ddate, "
						+ "basketpaid.psn, basketpaid.totalPrice, hot_com.salesPercent "
						+ "from basketpaid, hot_com where basketpaid.cName = hot_com.hname and "
						+ "hot_com.hcode = ? and date(basketpaid.ddate) between ? and ? "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') ";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, comcode);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();

					dto.setcName(rs.getString(1));
					dto.setcType(rs.getString(2));
					dto.setItemName(rs.getString(3));
					dto.setDdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setTotalPrice(rs.getInt(6));
					dto.setSalesPercent(rs.getDouble(7));
					
					System.out.println("호텔에서 얼마나 가지고가?"+dto.getSalesPercent());
					
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
		
		public ArrayList<BasketpaidDTO> buyListByHotComDateDay(String comcode, String startday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.cType, basketpaid.itemName, basketpaid.ddate, "
						+ "basketpaid.psn, basketpaid.totalPrice, hot_com.salesPercent "
						+ "from basketpaid, hot_com where basketpaid.cName = hot_com.hname and "
						+ "hot_com.hcode = ? and date(basketpaid.ddate) = ? "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') ";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, comcode);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();

					dto.setcName(rs.getString(1));
					dto.setcType(rs.getString(2));
					dto.setItemName(rs.getString(3));
					dto.setDdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setTotalPrice(rs.getInt(6));
					dto.setSalesPercent(rs.getDouble(7));
					
					System.out.println("호텔에서 얼마나 가지고가?"+dto.getSalesPercent());
					
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
		
		public ArrayList<BasketpaidDTO> reserveListByHotRcodeDate(String rcode, String startday, String endday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select distinct basketpaid.itemName, basketpaid.ddate, basketpaid.fdate, basketpaid.psn, basketpaid.id, basketpaid.basketID "
						+ "from basketpaid, basketitem "
						+ "where basketpaid.basketID = basketitem.basketID and basketitem.rcode = ? "
						+ "and basketpaid.bstatus='m' and date(basketpaid.ddate) between ? and ? ";
				
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, rcode);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setFdateStr(rs.getString(3));
					dto.setPsn(rs.getInt(4));
					dto.setId(rs.getString(5));
					dto.setBasketID(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> reserveListByHotRcodeDateDay(String rcode, String startday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select distinct basketpaid.itemName, basketpaid.ddate, basketpaid.fdate, basketpaid.psn, basketpaid.id, basketpaid.basketID "
						+ "from basketpaid, basketitem "
						+ "where basketpaid.basketID = basketitem.basketID and basketitem.rcode = ? "
						+ "and basketpaid.bstatus='m' and date(basketpaid.ddate) = ? ";
				
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, rcode);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setFdateStr(rs.getString(3));
					dto.setPsn(rs.getInt(4));
					dto.setId(rs.getString(5));
					dto.setBasketID(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> reserveListByHotDate(String cName, String startday, String endday) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select itemName, ddate, fdate, psn, id, basketID "
						+ "from basketpaid "
						+ "where cName= ? and bstatus='m' and date(basketpaid.ddate) between ? and ? ";
				
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, cName);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setFdateStr(rs.getString(3));
					dto.setPsn(rs.getInt(4));
					dto.setId(rs.getString(5));
					dto.setBasketID(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> reserveListByHotDateDay(String cName, String startday) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select itemName, ddate, fdate, psn, id, basketID "
						+ "from basketpaid "
						+ "where cName= ? and bstatus='m' and date(basketpaid.ddate) = ? ";
				
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, cName);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setFdateStr(rs.getString(3));
					dto.setPsn(rs.getInt(4));
					dto.setId(rs.getString(5));
					dto.setBasketID(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> buyListByRcodeDate(String rcode, String startday, String endday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.itemName, basketpaid.ddate, basketpaid.psn, basketpaid.totalPrice, hot_com.salesPercent, basketpaid.code "
						+ "from basketpaid, hot_com "
						+ "where basketpaid.cName = hot_com.hname and basketpaid.code= ? and basketpaid.cName = ? "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') and date(basketpaid.ddate) between ? and ?";
				
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, rcode);
				ptmt.setString(2, cname);
				ptmt.setString(3, startday);
				ptmt.setString(4, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setPsn(rs.getInt(3));
					dto.setTotalPrice(rs.getInt(4));
					dto.setSalesPercent(rs.getDouble(5));
					dto.setCode(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> buyListByRcodeDateDay(String rcode, String startday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.itemName, basketpaid.ddate, basketpaid.psn, basketpaid.totalPrice, hot_com.salesPercent, basketpaid.code "
						+ "from basketpaid, hot_com "
						+ "where basketpaid.cName = hot_com.hname and basketpaid.code= ? and basketpaid.cName = ?  "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') and date(basketpaid.ddate) = ?";
				
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, rcode);
				ptmt.setString(2, cname);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setPsn(rs.getInt(3));
					dto.setTotalPrice(rs.getInt(4));
					dto.setSalesPercent(rs.getDouble(5));
					dto.setCode(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> buyListHotDate(String startday, String endday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.itemName, basketpaid.ddate, basketpaid.psn, basketpaid.totalPrice, hot_com.salesPercent, basketpaid.code "
						+ "from basketpaid, hot_com "
						+ "where basketpaid.cName = hot_com.hname and basketpaid.cName = ? "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') and date(basketpaid.ddate) between ? and ?";
				
				ptmt = con.prepareStatement(sql);
		
			
				ptmt.setString(1, cname);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setPsn(rs.getInt(3));
					dto.setTotalPrice(rs.getInt(4));
					dto.setSalesPercent(rs.getDouble(5));
					dto.setCode(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> buyListHotDateDay(String startday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.itemName, basketpaid.ddate, basketpaid.psn, basketpaid.totalPrice, hot_com.salesPercent, basketpaid.code "
						+ "from basketpaid, hot_com "
						+ "where basketpaid.cName = hot_com.hname and basketpaid.cName = ? "
						+ "and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') and date(basketpaid.ddate) = ?";
				
				ptmt = con.prepareStatement(sql);
		
			
				ptmt.setString(1, cname);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setPsn(rs.getInt(3));
					dto.setTotalPrice(rs.getInt(4));
					dto.setSalesPercent(rs.getDouble(5));
					dto.setCode(rs.getString(6));
					
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
		
		public ArrayList<BasketpaidDTO> reserveListByAirCcodeDate(String code, String startday, String endday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				sql = "select code, itemName, ddate, fdate, psn, id, basketID "
						+ "from basketpaid where code= ? and bstatus = 'm' and date(basketpaid.ddate) between ? and ? ";

				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, code);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setCode(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					dto.setFdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setId(rs.getString(6));
					dto.setBasketID(rs.getString(7));
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
		
		public ArrayList<BasketpaidDTO> reserveListByAirCcodeDateDay(String code, String startday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				sql = "select code, itemName, ddate, fdate, psn, id, basketID "
						+ "from basketpaid where code= ? and bstatus = 'm' and date(basketpaid.ddate) = ? ";

				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, code);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setCode(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					dto.setFdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setId(rs.getString(6));
					dto.setBasketID(rs.getString(7));
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
		
		public ArrayList<BasketpaidDTO> reserveListByAirDate(String cName, String startday, String endday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				sql = "select code, itemName, ddate, fdate, psn, id, basketID from basketpaid "
						+ "where cName = ? and basketpaid.bstatus = 'm' and "
						+ "date(basketpaid.ddate) between ? and ? ;";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, cName);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setCode(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					
					dto.setFdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setId(rs.getString(6));
					dto.setBasketID(rs.getString(7));				
					
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
		
		public ArrayList<BasketpaidDTO> reserveListByAirDateDay(String cName, String startday) {
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				sql = "select code, itemName, ddate, fdate, psn, id, basketID from basketpaid "
						+ "where cName = ? and basketpaid.bstatus = 'm' and "
						+ "date(basketpaid.ddate) = ? ";
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, cName);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setCode(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					
					dto.setFdateStr(rs.getString(4));
					dto.setPsn(rs.getInt(5));
					dto.setId(rs.getString(6));
					dto.setBasketID(rs.getString(7));				
					
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
		
		public ArrayList<BasketpaidDTO> buyListByccodeDate(String ccode, String startday, String endday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				sql = "select basketpaid.code , basketpaid.itemName, basketpaid.ddate, "
						+ "basketpaid.location1, basketpaid.location2, basketpaid.psn, "
						+ "basketpaid.totalPrice, air_com.salesPercent "
						+ "from basketpaid, air_com where basketpaid.cName=air_com.air_name and basketpaid.cName= ? "
						+ "and basketpaid.code = ? "
						+ "and date(basketpaid.ddate) between ? and ? and (bstatus = 'p' or basketpaid.bstatus = 'n') ";
							
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, cname);
				ptmt.setString(2, ccode);
				ptmt.setString(3, startday);
				ptmt.setString(4, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setCode(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					dto.setLocation1(rs.getString(4));
					dto.setLocation2(rs.getString(5));					
					dto.setPsn(rs.getInt(6));
					dto.setTotalPrice(rs.getInt(7));
					dto.setSalesPercent(rs.getDouble(8));
					
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
		
		public ArrayList<BasketpaidDTO> buyListByccodeDateDay(String ccode, String startday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				sql = "select basketpaid.code , basketpaid.itemName, basketpaid.ddate, "
						+ "basketpaid.location1, basketpaid.location2, basketpaid.psn, "
						+ "basketpaid.totalPrice, air_com.salesPercent "
						+ "from basketpaid, air_com where basketpaid.cName=air_com.air_name and basketpaid.cName = ? "
						+ "and basketpaid.code = ? "
						+ "and date(basketpaid.ddate) = ? and (bstatus = 'p' or basketpaid.bstatus = 'n') ";
							
				ptmt = con.prepareStatement(sql);
		
				ptmt.setString(1, cname);
				ptmt.setString(2, ccode);
				ptmt.setString(3, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setCode(rs.getString(1));
					dto.setItemName(rs.getString(2));
					dto.setDdateStr(rs.getString(3));
					dto.setLocation1(rs.getString(4));
					dto.setLocation2(rs.getString(5));					
					dto.setPsn(rs.getInt(6));
					dto.setTotalPrice(rs.getInt(7));
					dto.setSalesPercent(rs.getDouble(8));
					
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
		
		public ArrayList<BasketpaidDTO> buyListAirDate(String startday, String endday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.itemName, basketpaid.ddate, basketpaid.psn, basketpaid.totalPrice, air_com.salesPercent, basketpaid.code, "
						+ "basketpaid.location1, basketpaid.location2 "
						+ "from basketpaid, air_com "
						+ "where basketpaid.cName = air_com.air_name and basketpaid.cName = ? "
						+ "and date(basketpaid.ddate) between ? and ? and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') ";
				
				ptmt = con.prepareStatement(sql);
		
			
				ptmt.setString(1, cname);
				ptmt.setString(2, startday);
				ptmt.setString(3, endday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setPsn(rs.getInt(3));
					dto.setTotalPrice(rs.getInt(4));
					dto.setSalesPercent(rs.getDouble(5));
					dto.setCode(rs.getString(6));
					dto.setLocation1(rs.getString(7));
					dto.setLocation2(rs.getString(8));	
					
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
		
		public ArrayList<BasketpaidDTO> buyListAirDateDay(String startday, String cname) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.itemName, basketpaid.ddate, basketpaid.psn, basketpaid.totalPrice, air_com.salesPercent, basketpaid.code, "
						+ "basketpaid.location1, basketpaid.location2 "
						+ "from basketpaid, air_com "
						+ "where basketpaid.cName = air_com.air_name and basketpaid.cName = ? "
						+ "and date(basketpaid.ddate) = ? and (basketpaid.bstatus = 'p' or basketpaid.bstatus = 'n') ";
				
				ptmt = con.prepareStatement(sql);
		
			
				ptmt.setString(1, cname);
				ptmt.setString(2, startday);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
					
					dto.setItemName(rs.getString(1));
					dto.setDdateStr(rs.getString(2));
					dto.setPsn(rs.getInt(3));
					dto.setTotalPrice(rs.getInt(4));
					dto.setSalesPercent(rs.getDouble(5));
					dto.setCode(rs.getString(6));
					dto.setLocation1(rs.getString(7));
					dto.setLocation2(rs.getString(8));	
					
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
		
		public ArrayList<BasketpaidDTO> reserveTotalList() {	
			
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			sql = "select distinct basketpaid.cName, basketpaid.cType, basketpaid.itemName,basketpaid.code, "
					+ "basketpaid.ddate, basketpaid.fdate, basketpaid.psn, basketpaid.id "
					+ "from basketpaid, basketitem where basketpaid.basketID = basketitem.basketID and basketpaid.bstatus='m' order by ddate";
			
			
			System.out.println(sql);
			
			try {
	
				ptmt = con.prepareStatement(sql);

	
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
				BasketpaidDTO dto = new BasketpaidDTO();
				dto.setcName(rs.getString(1));
				dto.setcType(rs.getString(2));
				dto.setItemName(rs.getString(3));
				dto.setCode(rs.getString(4));
				dto.setDdate(rs.getTimestamp(5));
				dto.setFdate(rs.getTimestamp(6));
				dto.setPsn(rs.getInt(7));
				dto.setId(rs.getString(8));
				res.add(dto);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
