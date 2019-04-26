package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {	}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
		if(con!=null) try {con.close();} catch (SQLException e) {	}
	}
}
