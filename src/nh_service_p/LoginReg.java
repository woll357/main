package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class LoginReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("로그인하세요");
		
		SignUpDTO dto = new SignUpDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		SignUpDTO mem =new SignUpDAO().chklogin(dto);
		
		if(mem!=null) {
			
			
			HttpSession session = request.getSession();
			
			if(mem.getGrade().equals("A")) {
				dto.setGrade(mem.getGrade());
				mem.setAir_code(new SignUpDAO().chkCode(dto));
				
				
				request.setAttribute("msg", mem.getPname()+"님 환영합니다.");
				request.setAttribute("mainUrl", "greensc/alert.jsp");
				request.setAttribute("goUrl", "../airgreen/AirHomeMain");
			}else if(mem.getGrade().equals("H")) {
				dto.setGrade(mem.getGrade());
				mem.setHcode(new SignUpDAO().chkCode(dto));
				request.setAttribute("msg", mem.getPname()+"님 환영합니다.");
				request.setAttribute("mainUrl", "greensc/alert.jsp");
				request.setAttribute("goUrl", "../hmain/Hdetail?hotcont=in");
			}else if(mem.getGrade().equals("M"))  {
				request.setAttribute("msg", mem.getPname()+"님 환영합니다.");
				request.setAttribute("mainUrl", "greensc/alert.jsp");
				request.setAttribute("goUrl", "NoticeList?center=in");
			}else{
				request.setAttribute("msg", mem.getPname()+"님 환영합니다.");
				request.setAttribute("mainUrl", "greensc/alert.jsp");
				request.setAttribute("goUrl", "Home");
			}
			
			
			session.setAttribute("mem", mem);
			
			
			
			

		}else {
			request.setAttribute("msg", "ID 와 PW 확인 부탁드립니다.");
			request.setAttribute("mainUrl", "greensc/alert.jsp");
			request.setAttribute("goUrl", "Login");
		}
		

		
		return null;
	}

}
