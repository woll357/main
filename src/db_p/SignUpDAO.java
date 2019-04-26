package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SignUpDAO {
	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public SignUpDAO() {
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
	
	
	public void signUp(SignUpDTO dto) {
		
		sql="insert into member "
				+ "(grade, id, pw, pname, birth, email, phone, country, city, addDetail, gender) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getGrade());
			ptmt.setString(2, dto.getId());
			ptmt.setString(3, dto.getPw());
			ptmt.setString(4, dto.getPname());
			ptmt.setString(5, dto.getBirth());
			ptmt.setString(6, dto.getEmail());
			ptmt.setString(7, dto.getPhone());
			ptmt.setString(8, dto.getCountry());
			ptmt.setString(9, dto.getCity());
			ptmt.setString(10, dto.getAddDetail());
			ptmt.setString(11, dto.getGender());
			ptmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public SignUpDTO chklogin(SignUpDTO dto) {
		SignUpDTO res=null;
		
		try {
			sql="select * from member where id=? and pw=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
			res = new SignUpDTO();
			res.setId(rs.getString("id"));
			res.setGrade(rs.getString("grade"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return res;
	}
	
	
	
	public String chkCode(SignUpDTO dto) {
		String res=null;
		
		try {
			
			if(dto.getGrade().equals("A")) {
				sql="select * from air_com where id=?";
				
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
				res=rs.getString("air_code");
				}
				
				
			}else{
				sql="select * from hot_com where id=?";
				
				
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();
				
				if(rs.next()) {
					res=rs.getString("hcode");
				}
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return res;
	}
	
	
	
	public void modifyMem(SignUpDTO dto) {
		
		sql = "update member set pw=?, phone=?, email=?, country=?, city=?, addDetail=? where id=?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getPw());
			ptmt.setString(2, dto.getPhone());
			ptmt.setString(3, dto.getEmail());
			ptmt.setString(4, dto.getCountry());
			ptmt.setString(5, dto.getCity());
			ptmt.setString(6, dto.getAddDetail());
			ptmt.setString(7, dto.getId());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void modifyMem(SignUpDTO dto, String bb) {
		
		sql = "update member set pw=?, phone=?, email=?, country=?, city=?, "
				+ "addDetail=?, black=?, preason=? where id=?";
		System.out.println(dto.getBlack());
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getPw());
			ptmt.setString(2, dto.getPhone());
			ptmt.setString(3, dto.getEmail());
			ptmt.setString(4, dto.getCountry());
			ptmt.setString(5, dto.getCity());
			ptmt.setString(6, dto.getAddDetail());
			ptmt.setString(7, dto.getBlack());
			ptmt.setString(8, dto.getPreason());
			ptmt.setString(9, dto.getId());
			
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public SignUpDTO detailMem(SignUpDTO dto) {
		
		sql = "select * from member where id = ?";
		SignUpDTO res = new SignUpDTO();
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			rs = ptmt.executeQuery();
			
			rs.next();

			
			res.setId(rs.getString("id"));
			res.setPw(rs.getString("pw"));
			res.setEmail(rs.getString("email"));
			res.setPhone(rs.getString("phone"));
			res.setCountry(rs.getString("country"));
			res.setCity(rs.getString("city"));
			res.setAddDetail(rs.getString("addDetail"));
			res.setBlack(rs.getString("black"));
			res.setPreason(rs.getString("preason"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	public Object gradeUpMgList() {
		
		sql = "select * from manager_temp order by time desc";
		ArrayList<SignUpDTO> res = new ArrayList<SignUpDTO>();
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
			SignUpDTO dto = new SignUpDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setBnum(rs.getInt("bnum"));
			dto.setGrade(rs.getString("grade"));
			dto.setTime(rs.getDate("time"));
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
	
	
	public Object gradeUpAirList() {
		
		sql = "select * from air_temp order by time desc";
		ArrayList<SignUpDTO> res = new ArrayList<SignUpDTO>();
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {

			SignUpDTO dto = new SignUpDTO();
			dto.setNo(rs.getInt("no"));
			dto.setId(rs.getString("id"));
			dto.setCrn(rs.getString("crn"));
			dto.setImg(rs.getString("img"));
			dto.setAir_name(rs.getString("air_name"));
			dto.setGrade(rs.getString("grade"));
			dto.setTime(rs.getDate("time"));
			
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
	public Object gradeUpHotList() {
		
		sql = "select * from hot_temp order by time desc";
		ArrayList<SignUpDTO> res = new ArrayList<SignUpDTO>();
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {

			SignUpDTO dto = new SignUpDTO();
			dto.setNo(rs.getInt("no"));
			dto.setId(rs.getString("id"));
			dto.setCrn(rs.getString("crn"));
			dto.setHimg(rs.getString("himg"));
			dto.setCountry(rs.getString("country"));
			dto.setCity(rs.getString("city"));
			dto.setHinfo(rs.getString("hinfo"));
			dto.setGrade(rs.getString("grade"));
			dto.setTime(rs.getDate("time"));
			
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
	
	
	
	
	
	
	
	
	
	public SignUpDTO gradeUpMgDetail(SignUpDTO dto) {
		
		sql = "select * from manager_temp where num=?";
		SignUpDTO res = null;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				
				res = new SignUpDTO();
				res.setNum(rs.getInt("num"));
				res.setId(rs.getString("id"));
				res.setBnum(rs.getInt("bnum"));
				res.setGrade(rs.getString("grade"));
				res.setTime(rs.getDate("time"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	
	
	public SignUpDTO gradeUpAirDetail(SignUpDTO dto) {
		
		sql = "select * from air_temp where no=?";
		SignUpDTO res = null;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.no);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
			res = new SignUpDTO();
			res.setNo(rs.getInt("no"));
			res.setId(rs.getString("id"));
			res.setCrn(rs.getString("crn"));
			res.setImg(rs.getString("img"));
			res.setAir_name(rs.getString("air_name"));
			res.setGrade(rs.getString("grade"));
			res.setTime(rs.getDate("time"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}	
	public SignUpDTO gradeUpHotDetail(SignUpDTO dto) {
		
		sql = "select * from hot_temp where no=?";
		SignUpDTO res = null;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.no);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
			res = new SignUpDTO();
			res.setNo(rs.getInt("no"));
			res.setId(rs.getString("id"));
			res.setCrn(rs.getString("crn"));
			res.setHimg(rs.getString("himg"));
			res.setCountry(rs.getString("country"));
			res.setCity(rs.getString("city"));
			res.setHinfo(rs.getString("hinfo"));
			res.setGrade(rs.getString("grade"));
			res.setTime(rs.getDate("time"));
			res.setHname(rs.getString("hname"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
public void gradeMgUpup(SignUpDTO dto) {
		
	sql = "insert into manager " 
	          + " (id, bnum, grade) values "
	          + " (?, ?, ?, ?)";
		
		try {
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.id);
			ptmt.setInt(2, dto.getBnum());
			ptmt.setString(3, dto.getGrade());
			
			ptmt.executeUpdate();
			
			 sql = "DELETE FROM manager_temp WHERE id=?";
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
	
	
	
	public void gradeAirUpup(SignUpDTO dto) {
		
		sql = "insert into air_com " 
	          + " (no, air_code, id, crn, air_name) values "
	          + " (?, ?, ?, ?, ?)";
		
		try {
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.no);
			ptmt.setString(2, dto.air_code);
			ptmt.setString(3, dto.id);
			ptmt.setString(4, dto.crn);
			ptmt.setString(5, dto.air_name);
			
			ptmt.executeUpdate();
			
			 sql = "DELETE FROM air_temp WHERE id=?";
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
		public void gradeHotUpup(SignUpDTO dto) {
		
		   try {
		         sql = "insert into hot_com " 
		               + " (id, crn, hname, hinfo, grade, country, city, hcode) values "
		               + " (?, ?, ?, ?, ? ,? ,?, ?)";
		         
		         ptmt = con.prepareStatement(sql);
		         ptmt.setString(1, dto.getId());
		         ptmt.setString(2, dto.getCrn());
		         ptmt.setString(3, dto.getHname());
		         ptmt.setString(4, dto.getHinfo());
		         ptmt.setString(5, dto.getGrade());
		         ptmt.setString(6, dto.getCountry());
		         ptmt.setString(7, dto.getCity());
		         ptmt.setString(8, dto.getHcode());
		         ptmt.executeUpdate();
		         
		         
		         sql = "DELETE FROM hot_temp WHERE id=?";
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
	
	
	
	
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
}
