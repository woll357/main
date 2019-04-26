package nh_service_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.CenterDTO;
import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class ModifyMemReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		SignUpDTO dto = new SignUpDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		dto.setCountry(request.getParameter("country"));
		dto.setCity(request.getParameter("city"));
		dto.setAddDetail(request.getParameter("addDetail"));
		

		if(!((SignUpDTO) session.getAttribute("mem")).getId().equals(request.getParameter("id"))) {
			
			dto.setBlack(request.getParameter("black"));
			dto.setPreason(request.getParameter("preason"));
			new SignUpDAO().modifyMem(dto, "블랙");
			request.setAttribute("goUrl", "MgPage?mgpage=in");
			request.setAttribute("msg", "관리자님 수정되었습니다.");
			
		}else {
			
			
			request.setAttribute("goUrl", "ModifyMem");
			new SignUpDAO().modifyMem(dto);
			request.setAttribute("msg", "수정되었습니다.");
			
		}

        request.setAttribute("mainUrl", "greensc/alert.jsp");
        
		
		return null;
	}

}
