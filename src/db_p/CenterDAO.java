package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CenterDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public CenterDAO() {
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
	
	public int total(String table) {
		int res = 0;
		
		try {
			
			sql = "select count(*) from "+table; 
			//limit : a번부터 b번까지
			
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			rs.next();
			
			res = rs.getInt(1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	public int bbtotal(SignUpDTO dto) {
		int res = 0;
		
		try {
			
			sql = "select count(*) from member where preason=?"; 
			//limit : a번부터 b번까지
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.preason);
			rs = ptmt.executeQuery();
			
			rs.next();
			
			res = rs.getInt(1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public ArrayList<Integer> qnaCnt(CenterDTO dto) {
		ArrayList<Integer> res = null;
		
		try {
			
			sql="select count(*) from qna where id=?";
			
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.id);
			rs = ptmt.executeQuery();
			
			rs.next();
			res=new ArrayList<Integer>();
			res.add(rs.getInt(1));

			if(dto.grade.equals("M")) {
			sql="select count(*) from qna where answer='완료'";
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			}else {
				sql="select count(*) from qna where answer='완료' and id =?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.id);
				rs = ptmt.executeQuery();
			}
			
			
			
			
			rs.next();
			
			res.add(rs.getInt(1));

			if(dto.grade.equals("M")) {
				sql="select count(*) from qna where answer='대기'";
				ptmt = con.prepareStatement(sql);
				
				rs = ptmt.executeQuery();
				}else {
					sql="select count(*) from qna where answer='대기' and id =?";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, dto.id);
					rs = ptmt.executeQuery();
				}
			
			
			
			
			
			rs.next();
			res.add(rs.getInt(1));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public Object noticeList(int page, int limit) {
		
		ArrayList<CenterDTO> res = new ArrayList<CenterDTO>();
		try {
			
			sql = "select * from notice order by time desc limit ?, ?"; 
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, page);
			ptmt.setInt(2, limit);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				CenterDTO dto = new CenterDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setId("운영자");
				dto.setTime(rs.getTimestamp("time"));
				dto.setView(rs.getInt("view"));
				
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
	
	public Integer noticeWrite(CenterDTO dto) {
		int res = 0;
		
		try {
			
			sql = "insert into notice "
			+ "(title, id, content, time, view ,img) values "
			+ "(? ,  ? , ? ,sysdate(), -1,? )";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getId());
			ptmt.setString(3, dto.getContent());
			ptmt.setString(4, dto.getImg());
			ptmt.executeUpdate();
			
			sql = "select max(num) from notice";
			
			ptmt = con.prepareStatement(sql);
			
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
	
	public void noticeAddCount(CenterDTO dto) {
		
		sql = "update notice set view = view + 1 where num = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.num);
			ptmt.executeUpdate();
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public CenterDTO noticeDetail(CenterDTO dto) {
		CenterDTO res = new CenterDTO();;
		
		sql = "select * from notice where num = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res.setNum(dto.num);
				res.setTitle(rs.getString("title"));
				res.setId(rs.getString("id"));
				res.setContent(rs.getString("content"));
				res.setTime(rs.getTimestamp("time"));
				res.setView(rs.getInt("view"));
				res.setImg(rs.getString("img"));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		return res;
	}
	
	public Object fnqList(int page, int limit) {
		
		ArrayList<CenterDTO> res = new ArrayList<CenterDTO>();
		try {
			
			sql = "select * from fnq order by time desc limit ?, ?"; 
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, page);
			ptmt.setInt(2, limit);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				CenterDTO dto = new CenterDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setId("운영자");
				dto.setTime(rs.getTimestamp("time"));
				dto.setView(rs.getInt("view"));
				
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
	
	public Integer fnqWrite(CenterDTO dto) {
		int res = 0;
		
		try {
			
			sql = "insert into fnq "
			+ "(title, id, content, time, view ,img) values "
			+ "(? ,  ? , ? ,sysdate(), -1 ,?)";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getId());
			ptmt.setString(3, dto.getContent());
			ptmt.setString(4, dto.getImg());
			ptmt.executeUpdate();
			
			sql = "select max(num) from fnq";
			
			ptmt = con.prepareStatement(sql);
			
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
	
	public void fnqAddCount(CenterDTO dto) {
		
		sql = "update fnq set view = view + 1 where num = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.num);
			ptmt.executeUpdate();
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public CenterDTO fnqDetail(CenterDTO dto) {
		CenterDTO res = new CenterDTO();;
		
		sql = "select * from fnq where num = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res.setNum(dto.num);
				res.setTitle(rs.getString("title"));
				res.setId(rs.getString("id"));
				res.setContent(rs.getString("content"));
				res.setTime(rs.getTimestamp("time"));
				res.setView(rs.getInt("view"));
				res.setImg(rs.getString("img"));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		return res;
	}
	
	
	public Object qnaList(CenterDTO dto, int page, int limit) {
		
		ArrayList<CenterDTO> res = new ArrayList<CenterDTO>();
		CenterDTO dto2 =null;
		try {
			if(dto.grade.equals("M")) {
				sql = "select * from qna order by  answer asc, time desc limit ?, ?";
				ptmt = con.prepareStatement(sql);
				ptmt.setInt(1, page);
				ptmt.setInt(2, limit);
				rs = ptmt.executeQuery();
			}else {
				sql = "select * from qna where id=? order by time desc limit ?, ?";
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, dto.id);
				ptmt.setInt(2, page);
				ptmt.setInt(3, limit);
				rs = ptmt.executeQuery();
			}

			
			while(rs.next()) {
				dto2 = new CenterDTO();
				dto2.setNum(rs.getInt("num"));
				dto2.setTitle(rs.getString("title"));
				dto2.setId(rs.getString("id"));
				dto2.setTime(rs.getTimestamp("time"));
				dto2.setAnswer(rs.getString("answer"));
				res.add(dto2);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			close();
		}
		
		
		return res;
		
		
	}
	

	public CenterDTO qnaDetail(CenterDTO dto) {
		CenterDTO res = new CenterDTO();
		
		try {
			if(dto.answer.equals("완료")) {
				sql = "select * from qna where qnum = ?";
			}else {
				sql = "select * from qna where num = ?";
			}
			System.out.println(sql);
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res.setNum(dto.num);
				res.setTitle(rs.getString("title"));
				res.setId(rs.getString("id"));
				res.setContent(rs.getString("content"));
				res.setTime(rs.getTimestamp("time"));
				res.setAnswer(rs.getString("answer"));
				res.setImg(rs.getString("img"));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		return res;
	}
	
	
	public Integer qnaWrite(CenterDTO dto) {
		int res = 0;
		
		try {
			
			sql = "insert into qna "
			+ "(title, id, content, time, answer, img ) values "
			+ "(? ,  ? , ? ,sysdate(), '대기' ,?)";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getId());
			ptmt.setString(3, dto.getContent());
			ptmt.setString(4, dto.getImg());
			ptmt.executeUpdate();
			
			sql = "select max(num) from qna";
			
			ptmt = con.prepareStatement(sql);
			
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
	
	
	public Integer qnaReplyWrite(CenterDTO dto) {
		int res = 0;
		
		try {
			
			sql = "insert into qna "
			+ "(title, id, content, time, answer, qnum ,img) values "
			+ "(? ,  ? , ? ,sysdate(), '완료', ? ,?)";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getId());
			ptmt.setString(3, dto.getContent());
			ptmt.setInt(4, dto.getQnum());
			ptmt.setString(5, dto.getImg());
			ptmt.executeUpdate();
			
			sql = "update qna set answer = '완료' where num = ?";
			
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.num);
			ptmt.executeUpdate();
				
			res=dto.num;
			
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
