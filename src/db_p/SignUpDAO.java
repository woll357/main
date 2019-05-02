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
			ds = (DataSource) new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void signUp(SignUpDTO dto) {

		sql = "insert into member "
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
		} finally {
			close();
		}

	}

	public SignUpDTO chklogin(SignUpDTO dto) {
		SignUpDTO res = null;

		try {
			sql = "select * from member where id=? and pw=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			rs = ptmt.executeQuery();

			if (rs.next()) {
				res = new SignUpDTO();
				res.setId(rs.getString("id"));
				res.setGrade(rs.getString("grade"));
				res.setPname(rs.getString("pname"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}

	public boolean chkempty(SignUpDTO dto) {
		boolean res = false;

		try {
			if (dto.getGrade().equals("C")) {
				sql = "select * from basketpaid where id=? and bstatus='m'";

				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				res = rs.next();

			} else if (dto.getGrade().equals("A")) {
				sql = "select * from air_com where id=?";

				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				res = rs.next();

			} else if (dto.getGrade().equals("H")) {
				sql = "select * from hot_com where id=?";

				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				res = rs.next();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}

	public boolean chkApply(SignUpDTO dto) {
		boolean res = false;
		try {

			
				sql = "select * from air_temp,air_com,hot_com,hot_temp,manager,manager_temp where " + 
						"air_temp.id=? or air_com.id=? or hot_com.id=? or hot_temp.id=? or manager.id=? or manager_temp.id=? " + 
						"or air_temp.crn=? or air_com.crn=? or hot_com.crn=? or hot_temp.crn=? or " + 
						"manager.bnum=? or manager_temp.bnum=?";

				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, dto.getId());
				ptmt.setString(2, dto.getId());
				ptmt.setString(3, dto.getId());
				ptmt.setString(4, dto.getId());
				ptmt.setString(5, dto.getId());
				ptmt.setString(6, dto.getId());
				ptmt.setString(7, dto.getCrn());
				ptmt.setString(8, dto.getCrn());				
				ptmt.setString(9, dto.getCrn());
				ptmt.setString(10, dto.getCrn());
				ptmt.setString(11, dto.getBnum());
				ptmt.setString(12, dto.getBnum());
				
				rs = ptmt.executeQuery();

				res = rs.next();
				

			
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}

	public void upupGrade(SignUpDTO dto) {
		if (dto.getGrade().equals("M")) {

			sql = "insert into manager_temp " + "(id, bnum, grade, time) values " + "(?,?,?,sysdate())";

			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				ptmt.setString(2, dto.getBnum());
				ptmt.setString(3, dto.getGrade());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (dto.getGrade().equals("A")) {

			sql = "insert into air_temp " + "(id, crn, air_name, grade, time, air_codecom, img, salesPercent) values "
					+ "(?,?,?,?,sysdate(),?,?,?)";

			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				ptmt.setString(2, dto.getCrn());
				ptmt.setString(3, dto.getAir_name());
				ptmt.setString(4, dto.getGrade());
				ptmt.setString(5, dto.getAir_codecom());
				ptmt.setString(6, dto.getImg());
				ptmt.setString(7, dto.getSalesPercent());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			sql = "insert into hot_temp(id, crn, country, city, hname, hinfo, grade, time, himg, salesPercent) values "
					+ "(?, ?, (select country from member where id = ?), "
					+ "(select city from member where id = ?), ?, ?, ?, sysdate(),?,?)";

			try {
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				ptmt.setString(2, dto.getCrn());
				ptmt.setString(3, dto.getId());
				ptmt.setString(4, dto.getId());
				ptmt.setString(5, dto.getHname());
				ptmt.setString(6, dto.getHinfo());
				ptmt.setString(7, dto.getGrade());
				ptmt.setString(8, dto.getHimg());
				ptmt.setString(9, dto.getSalesPercent());
				ptmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void deleteId(SignUpDTO dto) {

		try {
			sql = "DELETE from member where id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();
			sql = "DELETE from air_temp where id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();
			sql = "DELETE from hot_temp where id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();
			sql = "DELETE from manager_temp where id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

			if (dto.getGrade().equals("M")) {
				sql = "DELETE from manager where id=?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				ptmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	
	
	public void rejectUp(SignUpDTO dto) {

		try {
			sql = "DELETE from air_temp where id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();
			sql = "DELETE from hot_temp where id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();
			sql = "DELETE from manager_temp where id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	
	
	

	public String chkCode(SignUpDTO dto) {
		String res = null;

		try {

			if (dto.getGrade().equals("A")) {
				sql = "select * from air_com where id=?";

				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				if (rs.next()) {
					res = rs.getString("air_code");
				}

			} else {
				sql = "select * from hot_com where id=?";

				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				if (rs.next()) {
					res = rs.getString("hcode");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		} finally {
			close();
		}
	}

	public void modifyMem(SignUpDTO dto, String bb) {

		System.out.println(dto.getBlack());
		try {

			if (dto.getGrade() == "H" || dto.getGrade() == "A") {
				sql = "update member set pw=?, phone=?, email=? where id=?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getPw());
				ptmt.setString(2, dto.getPhone());
				ptmt.setString(3, dto.getEmail());
				ptmt.setString(4, dto.getId());

				ptmt.executeUpdate();
			} else {

				sql = "update member set pw=?, phone=?, email=?, country=?, city=?, "
						+ "addDetail=?, black=?, preason=? where id=?";
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

				sql = "select * from hot_temp where id = ?";

				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				if (rs.next()) {
					sql = "update hot_temp set country=?, city=? where id=?";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, dto.getCountry());
					ptmt.setString(2, dto.getCity());
					ptmt.setString(3, dto.getId());
					ptmt.executeUpdate();
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
			res.setGender(rs.getString("gender"));
			res.setAddDetail(rs.getString("addDetail"));
			res.setPname(rs.getString("pname"));
			res.setBirth(rs.getString("birth"));
			
			String pp[]=rs.getString("phone").split("-");
			res.setPhone1(pp[0]);
			res.setPhone2(pp[1]);
			res.setPhone3(pp[2]);
			String ee[]=rs.getString("email").split("@");
			res.setEmail1(ee[0]);
			res.setEmail2(ee[1]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public int memNum(SignUpDTO dto) {
		
		
		
		int res = 0;
		try {
			
			
			if(dto.getBlack()==null) {
			sql = "select count(*) from member";
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (rs.next()) {
				res=rs.getInt(1);
			}
			}else{
				sql = "select count(*) from member where black = '블랙리스트'";
				ptmt = con.prepareStatement(sql);
				rs = ptmt.executeQuery();

				if (rs.next()) {
					res=rs.getInt(1);
				}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public ArrayList<SignUpDTO> memList(SignUpDTO dto) {
		
		
		ArrayList<SignUpDTO> res = new ArrayList<SignUpDTO>();
		SignUpDTO dto2 = null;
		try {
			
			if(dto.getBlack()==null) {
			if(dto.getId()!=null) {
				
				sql = "select * from member where id =?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				while(rs.next()) {
					dto2 = new SignUpDTO();
				dto2.setId(rs.getString("id"));
				dto2.setPw(rs.getString("pw"));
				dto2.setEmail(rs.getString("email"));
				dto2.setPhone(rs.getString("phone"));
				dto2.setCountry(rs.getString("country"));
				dto2.setCity(rs.getString("city"));
				dto2.setAddDetail(rs.getString("addDetail"));
				dto2.setBlack(rs.getString("black"));
				dto2.setPreason(rs.getString("preason"));
				dto2.setGender(rs.getString("gender"));
				dto2.setAddDetail(rs.getString("addDetail"));
				dto2.setPname(rs.getString("pname"));
				dto2.setBirth(rs.getString("birth"));
				
				String pp[]=rs.getString("phone").split("-");
				dto2.setPhone1(pp[0]);
				dto2.setPhone2(pp[1]);
				dto2.setPhone3(pp[2]);
				String ee[]=rs.getString("email").split("@");
				dto2.setEmail1(ee[0]);
				dto2.setEmail2(ee[1]);
				
				res.add(dto2);
				}

			}else if(dto.getPname()!=null) {
				
				sql = "select * from member where pname =?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getPname());
				rs = ptmt.executeQuery();

				while(rs.next()) {
					dto2 = new SignUpDTO();
				dto2.setId(rs.getString("id"));
				dto2.setPw(rs.getString("pw"));
				dto2.setEmail(rs.getString("email"));
				dto2.setPhone(rs.getString("phone"));
				dto2.setCountry(rs.getString("country"));
				dto2.setCity(rs.getString("city"));
				dto2.setAddDetail(rs.getString("addDetail"));
				dto2.setBlack(rs.getString("black"));
				dto2.setPreason(rs.getString("preason"));
				dto2.setGender(rs.getString("gender"));
				dto2.setAddDetail(rs.getString("addDetail"));
				dto2.setPname(rs.getString("pname"));
				dto2.setBirth(rs.getString("birth"));
				
				String pp[]=rs.getString("phone").split("-");
				dto2.setPhone1(pp[0]);
				dto2.setPhone2(pp[1]);
				dto2.setPhone3(pp[2]);
				String ee[]=rs.getString("email").split("@");
				dto2.setEmail1(ee[0]);
				dto2.setEmail2(ee[1]);
				
				res.add(dto2);
				}
			}else if(dto.getPhone()!=null) {
				
				sql = "select * from member where phone like ?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, "%-"+dto.getPhone());
				rs = ptmt.executeQuery();

				while(rs.next()) {
					dto2 = new SignUpDTO();
				dto2.setId(rs.getString("id"));
				dto2.setPw(rs.getString("pw"));
				dto2.setEmail(rs.getString("email"));
				dto2.setPhone(rs.getString("phone"));
				dto2.setCountry(rs.getString("country"));
				dto2.setCity(rs.getString("city"));
				dto2.setAddDetail(rs.getString("addDetail"));
				dto2.setBlack(rs.getString("black"));
				dto2.setPreason(rs.getString("preason"));
				dto2.setGender(rs.getString("gender"));
				dto2.setAddDetail(rs.getString("addDetail"));
				dto2.setPname(rs.getString("pname"));
				dto2.setBirth(rs.getString("birth"));
				
				String pp[]=rs.getString("phone").split("-");
				dto2.setPhone1(pp[0]);
				dto2.setPhone2(pp[1]);
				dto2.setPhone3(pp[2]);
				String ee[]=rs.getString("email").split("@");
				dto2.setEmail1(ee[0]);
				dto2.setEmail2(ee[1]);
				
				res.add(dto2);
				}
			}
			}else {
				if(dto.getId()!=null) {
					
					sql = "select * from member where id =? and black='블랙리스트'";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, dto.getId());
					rs = ptmt.executeQuery();

					while(rs.next()) {
						dto2 = new SignUpDTO();
					dto2.setId(rs.getString("id"));
					dto2.setPw(rs.getString("pw"));
					dto2.setEmail(rs.getString("email"));
					dto2.setPhone(rs.getString("phone"));
					dto2.setCountry(rs.getString("country"));
					dto2.setCity(rs.getString("city"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setBlack(rs.getString("black"));
					dto2.setPreason(rs.getString("preason"));
					dto2.setGender(rs.getString("gender"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setPname(rs.getString("pname"));
					dto2.setBirth(rs.getString("birth"));
					
					String pp[]=rs.getString("phone").split("-");
					dto2.setPhone1(pp[0]);
					dto2.setPhone2(pp[1]);
					dto2.setPhone3(pp[2]);
					String ee[]=rs.getString("email").split("@");
					dto2.setEmail1(ee[0]);
					dto2.setEmail2(ee[1]);
					
					res.add(dto2);
					}

				}else if(dto.getPname()!=null) {
					
					sql = "select * from member where pname =? and black='블랙리스트'";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, dto.getPname());
					rs = ptmt.executeQuery();

					while(rs.next()) {
						dto2 = new SignUpDTO();
					dto2.setId(rs.getString("id"));
					dto2.setPw(rs.getString("pw"));
					dto2.setEmail(rs.getString("email"));
					dto2.setPhone(rs.getString("phone"));
					dto2.setCountry(rs.getString("country"));
					dto2.setCity(rs.getString("city"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setBlack(rs.getString("black"));
					dto2.setPreason(rs.getString("preason"));
					dto2.setGender(rs.getString("gender"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setPname(rs.getString("pname"));
					dto2.setBirth(rs.getString("birth"));
					
					String pp[]=rs.getString("phone").split("-");
					dto2.setPhone1(pp[0]);
					dto2.setPhone2(pp[1]);
					dto2.setPhone3(pp[2]);
					String ee[]=rs.getString("email").split("@");
					dto2.setEmail1(ee[0]);
					dto2.setEmail2(ee[1]);
					
					res.add(dto2);
					}
				}else if(dto.getPhone()!=null) {
					
					sql = "select * from member where phone like ? and black='블랙리스트'";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, "%-"+dto.getPhone());
					rs = ptmt.executeQuery();

					while(rs.next()) {
						dto2 = new SignUpDTO();
					dto2.setId(rs.getString("id"));
					dto2.setPw(rs.getString("pw"));
					dto2.setEmail(rs.getString("email"));
					dto2.setPhone(rs.getString("phone"));
					dto2.setCountry(rs.getString("country"));
					dto2.setCity(rs.getString("city"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setBlack(rs.getString("black"));
					dto2.setPreason(rs.getString("preason"));
					dto2.setGender(rs.getString("gender"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setPname(rs.getString("pname"));
					dto2.setBirth(rs.getString("birth"));
					
					String pp[]=rs.getString("phone").split("-");
					dto2.setPhone1(pp[0]);
					dto2.setPhone2(pp[1]);
					dto2.setPhone3(pp[2]);
					String ee[]=rs.getString("email").split("@");
					dto2.setEmail1(ee[0]);
					dto2.setEmail2(ee[1]);
					
					res.add(dto2);
					}
				}else if(dto.getPreason()!=null) {
					
					sql = "select * from member where preason= ? and black='블랙리스트'";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, dto.getPreason());
					rs = ptmt.executeQuery();

					while(rs.next()) {
						dto2 = new SignUpDTO();
					dto2.setId(rs.getString("id"));
					dto2.setPw(rs.getString("pw"));
					dto2.setEmail(rs.getString("email"));
					dto2.setPhone(rs.getString("phone"));
					dto2.setCountry(rs.getString("country"));
					dto2.setCity(rs.getString("city"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setBlack(rs.getString("black"));
					dto2.setPreason(rs.getString("preason"));
					dto2.setGender(rs.getString("gender"));
					dto2.setAddDetail(rs.getString("addDetail"));
					dto2.setPname(rs.getString("pname"));
					dto2.setBirth(rs.getString("birth"));
					
					String pp[]=rs.getString("phone").split("-");
					dto2.setPhone1(pp[0]);
					dto2.setPhone2(pp[1]);
					dto2.setPhone3(pp[2]);
					String ee[]=rs.getString("email").split("@");
					dto2.setEmail1(ee[0]);
					dto2.setEmail2(ee[1]);
					
					res.add(dto2);
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	

	public boolean chkMem(SignUpDTO dto) {
		

		boolean res = false;
		try {
			
			
			if(dto.getId()!=null) {
				
				sql = "select * from member where id =?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getId());
				rs = ptmt.executeQuery();

				res=rs.next();
			}else if(dto.getPname()!=null) {
				
				sql = "select * from member where pname =?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.getPname());
				rs = ptmt.executeQuery();

				res=rs.next();
			}else if(dto.getPhone()!=null) {
				
				sql = "select * from member where phone like ?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, "%-"+dto.getPhone());
				rs = ptmt.executeQuery();

				res=rs.next();
			}
			
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public boolean chkPhone(SignUpDTO dto) {
		
		sql = "select * from member where phone = ?";
		boolean res = false;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getPhone());
			rs = ptmt.executeQuery();

			res=rs.next();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public boolean chkBlack(SignUpDTO dto) {
		
		sql = "select * from member where id = ?";
		boolean res = true;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			rs = ptmt.executeQuery();

			rs.next();
			System.out.println("블랙 먹음?"+rs.getString("black"));
			if(rs.getString("black")==null) {
				res = true;
			}else if(rs.getString("black").equals("블랙리스트")) {
				res=false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

			while (rs.next()) {
				SignUpDTO dto = new SignUpDTO();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setBnum(rs.getString("bnum"));
				dto.setGrade(rs.getString("grade"));
				dto.setTime(rs.getDate("time"));
				res.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

			while (rs.next()) {

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
		} finally {
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

			while (rs.next()) {

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
		} finally {
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

			if (rs.next()) {

				res = new SignUpDTO();
				res.setNum(rs.getInt("num"));
				res.setId(rs.getString("id"));
				res.setBnum(rs.getString("bnum"));
				res.setGrade(rs.getString("grade"));
				res.setTime(rs.getDate("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

			if (rs.next()) {
				res = new SignUpDTO();
				res.setNo(rs.getInt("no"));
				res.setId(rs.getString("id"));
				res.setCrn(rs.getString("crn"));
				res.setImg(rs.getString("img"));
				res.setAir_name(rs.getString("air_name"));
				res.setGrade(rs.getString("grade"));
				res.setTime(rs.getDate("time"));
				res.setAir_codecom(rs.getString("air_codecom"));
				res.setSalesPercent(rs.getString("salesPercent"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

			if (rs.next()) {
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
				res.setSalesPercent(rs.getString("salesPercent"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	public void gradeMgUpup(SignUpDTO dto) {

		sql = "insert into manager " + " (id, bnum, grade) values " + " (?, ?, ?, ?)";

		try {

			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.id);
			ptmt.setString(2, dto.getBnum());
			ptmt.setString(3, dto.getGrade());

			ptmt.executeUpdate();

			sql = "DELETE FROM manager_temp WHERE id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

			sql = "update member set grade = 'M' where id = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void gradeAirUpup(SignUpDTO dto) {

		sql = "insert into air_com " + " (no, air_code, id, crn, air_name, img, salesPercent) values " + " (?, ?, ?, ?, ?, ?,?)";

		try {

			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.no);
			ptmt.setString(2, dto.air_code);
			ptmt.setString(3, dto.id);
			ptmt.setString(4, dto.crn);
			ptmt.setString(5, dto.air_name);
			ptmt.setString(6, dto.img);
			ptmt.setString(7, dto.salesPercent);
			ptmt.executeUpdate();

			sql = "DELETE FROM air_temp WHERE id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

			sql = "update member set grade = 'A' where id = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void gradeHotUpup(SignUpDTO dto) {

		try {
			sql = "insert into hot_com "
					+ " (id, crn, hname, hinfo, grade, country, city, hcode, addDetail, himg, salesPercent) values "
					+ " (?, ?, ?, ?, ? ,? ,?, ?, (select addDetail from member where id = ?), ?,?)";

			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.setString(2, dto.getCrn());
			ptmt.setString(3, dto.getHname());
			ptmt.setString(4, dto.getHinfo());
			ptmt.setString(5, dto.getGrade());
			ptmt.setString(6, dto.getCountry());
			ptmt.setString(7, dto.getCity());
			ptmt.setString(8, dto.getHcode());
			ptmt.setString(9, dto.getId());
			ptmt.setString(10, dto.getHimg());
			ptmt.setString(11, dto.salesPercent);
			ptmt.executeUpdate();

			sql = "DELETE FROM hot_temp WHERE id=?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

			sql = "update member set grade = 'H' where id = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getId());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close();
		}

	}

	public String findPw(SignUpDTO dto) {

		sql = "select * from member where phone=? and id=?";
		String res = null;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getPhone());
			ptmt.setString(2, dto.getId());

			rs = ptmt.executeQuery();
			if (rs.next()) {
				res = rs.getString("pw");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	public String findId(SignUpDTO dto) {

		sql = "select * from member where phone=?";
		String res = null;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getPhone());
			rs = ptmt.executeQuery();
			if (rs.next()) {
				res = rs.getString("id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	
	
	
	

	public void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (ptmt != null)
			try {
				ptmt.close();
			} catch (SQLException e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}
	}
}
