package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class GradeDetail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		

		SignUpDAO dao = new SignUpDAO();
		SignUpDTO dto = new SignUpDTO();
		if(request.getParameter("rq").equals("mg")) {
		
			dto.setNum(Integer.parseInt(request.getParameter("no")));
			
			request.setAttribute("dto", dao.gradeUpMgDetail(dto));
			
		}else if(request.getParameter("rq").equals("air")) {
		
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			
			request.setAttribute("dto", dao.gradeUpAirDetail(dto));
			
		}else {
		
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			
			request.setAttribute("dto", dao.gradeUpHotDetail(dto));
			
		}
		
		
		
		
		return null;
	}

}
