package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BasketDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public BasketDAO() {
		// TODO Auto-generated constructor stub
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public ArrayList<BasketDTO> itemCNT(BasketDTO dt) {					//장바구니에 몇개있니?
		ArrayList<BasketDTO> res = new ArrayList<BasketDTO>();
		
		try {
			
			sql = "select * from basket where id = ?";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dt.getId());
	
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				BasketDTO dto = new BasketDTO();
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
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));

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
	
	public void insert(BasketDTO dto) {		//값을 넣준다.

	
		try {

			sql = "insert into basket "
					+ "(cNum, id, psn, ddate, fdate, cType, no, totalPrice, location1, location2, cName, itemName) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getcNum());
			ptmt.setString(2, dto.getId());
			ptmt.setInt(3, dto.getPsn());
			ptmt.setString(4, dto.getDdateStr());
			ptmt.setString(5, dto.getFdateStr());
			ptmt.setString(6, dto.getcType());
			ptmt.setInt(7, dto.getNo());
			ptmt.setInt(8, dto.getTotalPrice());
			ptmt.setString(9, dto.getLocation1());
			ptmt.setString(10, dto.getLocation2());
			ptmt.setString(11, dto.getcName());
			ptmt.setString(12, dto.getItemName());
			
			ptmt.executeUpdate();
			
			
			sql = "update basket set basketID = concat(pno,'b') where id = ? and no = ?";
			
			System.out.println("나오니?"+sql);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setInt(2, dto.getNo());
			
			ptmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
	public BasketDTO detail(BasketDTO dto) {	
		
		BasketDTO res = new BasketDTO();
		
		sql = "select * from basket where basketID = ? ";
		try {
			
			
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
			res.setNo(rs.getInt("no"));
			res.setId(rs.getString("id"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	public ArrayList<BasketDTO> myList(BasketDTO dto) {	
		
		ArrayList<BasketDTO> res = new ArrayList<BasketDTO>();
		
		sql = "select * from basket where id = ? and cType = ?";
		try {
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getcType());

			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
			
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
			dto.setNo(rs.getInt("no"));
			dto.setId(rs.getString("id"));
			
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
	
	
//	basketID
	public BasketDTO findBasketID(BasketDTO dto) {	//basketID찾기
		
		BasketDTO res = new BasketDTO();
		
		sql = "select * from basket where id = ? and no = ? ";
		
		System.out.println(sql);
		
		try {
			System.out.println("진입하니??11");
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getId());
			ptmt.setInt(2, dto.getNo());
			
			System.out.println(dto.getId());
			System.out.println(dto.getNo());
			
			rs = ptmt.executeQuery();
			
			System.out.println(rs);
			
			if(rs.next()) {
				System.out.println(rs.getString("basketID"));
				
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
				res.setNo(rs.getInt("no"));
				res.setId(rs.getString("id"));

				}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	public void modifyTotalPrice(BasketDTO dto) {		//값을 넣준다.
		
		sql = "update basket set totalPrice = ? where basketID = ?";
		System.out.println(sql);
		try {
			
			System.out.println("총액 들어오니?"+dto.getTotalPrice());
			System.out.println("BasketID뭐야?"+ dto.getBasketID());
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getTotalPrice());
			ptmt.setString(2, dto.getBasketID());
			int a = ptmt.executeUpdate();
			
			System.out.println(a);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public boolean delete(BasketDTO dto) { //장바구니 삭제
		
		System.out.println("Basket Delete진입");
		
		boolean res = false;
		
		try {

			sql = "delete from basket where basketID = ? ";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getBasketID());
			
			ptmt.executeUpdate();//여기까지 실행
			
			sql = "update basket set no = no-1 where id = ? and no > ? ";
			
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getId());
			ptmt.setInt(2, dto.getNo());
			
			ptmt.executeUpdate();
			
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