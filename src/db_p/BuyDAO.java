package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuyDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public BuyDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
//	public ArrayList<BuyDTO> itemCNT(BuyDTO dt) {					//장바구니에 몇개있니?
//		ArrayList<BuyDTO> res = new ArrayList<BuyDTO>();
//		
//		try {
//			
//			sql = "select * from basket where id = ?";
//			ptmt = con.prepareStatement(sql);
//			
//			ptmt.setString(1, dt.getId());
//	
//			rs = ptmt.executeQuery();
//			
//			while(rs.next()) {
//				BasketDTO dto = new BasketDTO();
//				dto.setBasketID(rs.getString("basketID"));
//				dto.setcType(rs.getString("cType"));
//				dto.setcNum(rs.getInt("cNum"));
//				dto.setcName(rs.getString("cName"));
//				dto.setItemName(rs.getString("itemName"));
//				dto.setDdate(rs.getTimestamp("ddate"));
//				dto.setFdate(rs.getTimestamp("fdate"));
//				dto.setLocation1(rs.getString("location1"));
//				dto.setLocation2(rs.getString("location2"));
//				dto.setTotalPrice(rs.getInt("totalPrice"));
//				dto.setPsn(rs.getInt("psn"));
//				dto.setNo(rs.getInt("no"));
//				dto.setId(rs.getString("id"));
//
//				res.add(dto);
//			}
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
	
	public void insert(BuyDTO dto) {		//값을 넣준다.
		
		try {

			sql = "insert into buy "
					+ "(bnum, bdate, id, totalPrice, pCode) "
					+ "values(?, ?, ?, ?, ?)";
			System.out.println(sql);
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getBnum());
			ptmt.setString(2, dto.getBdateStr());
			ptmt.setString(3, dto.getId());
			ptmt.setInt(4, dto.getTotalPrice());
			ptmt.setString(5, dto.getpCode());
			
			ptmt.executeUpdate();
			
			
			sql = "update buy set bcode = concat('p',pno) where id = ? and bdate = ?";
			
			System.out.println("나오니?"+sql);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getBdateStr());
			
			ptmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public BuyDTO detail(BuyDTO dto) {	//basketID찾기
			
			BuyDTO res = new BuyDTO();
			
			sql = "select * from buy where id = ? and bdate = ? ";
			
			System.out.println(sql);
			
			try {
				System.out.println("detail 진입하니??11");
				
				
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getId());
				ptmt.setString(2, dto.getBdateStr());
	
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
				
				res.setPno(rs.getInt("pno"));
				res.setBcode(rs.getString("bcode"));
				res.setBnum(rs.getInt("bnum"));
				res.setBdate(rs.getTimestamp("bdate"));
				res.setId(rs.getString("id"));
				res.setTotalPrice(rs.getInt("totalPrice"));
				res.setBstatus(rs.getString("bstatus"));
				res.setpCode(rs.getString("pCode"));
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				close();
			}
			
			return res;
		}
	
	public void modifyBstatus(BuyDTO dto) {
		
		sql = "update buy set bstatus = ? where bcode = ?";
				
	System.out.println(sql);
	
	try {
		ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, dto.getBstatus());
		ptmt.setString(2, dto.getBcode());
		
		ptmt.executeUpdate();
		
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
