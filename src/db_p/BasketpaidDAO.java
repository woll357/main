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
			
			sql = "select * from basketpaid where id = ? and bstatus= 'p' or bstatus = 'n' ";
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
					+ "(cNum, id, psn, ddate, fdate, cType, bcode, totalPrice, location1, location2, cName, itemName, basketID) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
				
				
				sql = "select basketpaid.cName, basketpaid.itemName,basketpaid.ddate, basketpaid.fdate , buy.bdate, basketpaid.id from basketpaid, buy "
						+ "where basketpaid.bcode = buy.bcode and date(bdate) between '"+start+"' and '"+end+"' and "
								+ "basketpaid.bstatus = 'r'";
				ptmt = con.prepareStatement(sql);
		
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					BasketpaidDTO dto = new BasketpaidDTO();
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
		
		public ArrayList<BasketpaidDTO> comReserveList(BasketpaidDTO dto) {		//회사 환불 갯수?
			ArrayList<BasketpaidDTO> res = new ArrayList<BasketpaidDTO>();
			
			try {
				
				sql = "select basketpaid.cName, basketpaid.itemName, basketpaid.ddate, basketpaid.fdate , basketpaid.id, basketpaid.psn from basketpaid, buy "
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
