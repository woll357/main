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
				mem.setAir_code(new SignUpDAO().chkCode(dto));
			}else if(mem.getGrade().equals("H")) {
				mem.setHcode(new SignUpDAO().chkCode(dto));
			}
			
			
			session.setAttribute("mem", mem);

			
			
			request.setAttribute("msg", request.getParameter("id")+"님 환영합니다.");
			request.setAttribute("mainUrl", "greensc/alert.jsp");
			request.setAttribute("goUrl", "Home");

		}else {
			request.setAttribute("msg", "ID 와 PW 확인 부탁드립니다.");
			request.setAttribute("mainUrl", "greensc/alert.jsp");
			request.setAttribute("goUrl", "Login");
		}
		

		
		return null;
	}

}
