package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class FindMySignReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		SignUpDTO dto = new SignUpDTO();
		dto.setId(request.getParameter("id"));
		dto.setPhone(request.getParameter("phone"));
		String me = null;
		if(request.getParameter("id")!=null) {
			me="PW : "+(String)new SignUpDAO().findPw(dto)+" 입니다.";
		}else {
			
			me="ID : "+(String)new SignUpDAO().findId(dto)+" 입니다.";
		}
		
		
		request.setAttribute("msg", me);
        request.setAttribute("goUrl", "FindMySign");
        request.setAttribute("mainUrl", "greensc/alert.jsp");
		
		return null;
	}

}
