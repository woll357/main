package nh_service_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class UpupReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();		
		SignUpDTO dto = new SignUpDTO();
		
		if(request.getParameter("grade").equals("M")) {
			dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
			dto.setBnum(Integer.parseInt(request.getParameter("bnum")));
			dto.setGrade(request.getParameter("grade"));
		}else if(request.getParameter("grade").equals("A")) {
			dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
			dto.setCrn(request.getParameter("crn"));
			dto.setGrade(request.getParameter("grade"));
			dto.setAir_name(request.getParameter("air_name"));
		}else{
			dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
			dto.setCrn(request.getParameter("crn"));
			dto.setGrade(request.getParameter("grade"));
			dto.setHname(request.getParameter("hname"));
			dto.setHinfo(request.getParameter("hinfo"));
		}
		
		new SignUpDAO().upupGrade(dto);
		request.setAttribute("msg", "신청이 완료되었습니다.");
		request.setAttribute("mainUrl", "greensc/alert.jsp");
		request.setAttribute("goUrl", "Appbss");
		
		return null;
	}

}