package nh_service_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class GradeDetailReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SignUpDTO dto = new SignUpDTO();
		SignUpDAO dao = new SignUpDAO();
		String rqGrade = request.getParameter("grade");
		
		
		if(rqGrade.equals("M")) {
			
			dto.setId(request.getParameter("id"));
			dto.setBnum(Integer.parseInt(request.getParameter("bnum")));
			dto.setGrade(request.getParameter("grade"));
			dao.gradeMgUpup(dto);
			
		}else if(rqGrade.equals("A")) {
			
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			dto.setAir_code("A"+request.getParameter("no"));
			dto.setId(request.getParameter("id"));
			dto.setCrn(request.getParameter("crn"));
			dto.setAir_name(request.getParameter("air_name"));
			dao.gradeAirUpup(dto);
			
			
		}else {
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			dto.setId(request.getParameter("id"));
			dto.setCrn(request.getParameter("crn"));
			dto.setHname(request.getParameter("hname"));
			dto.setCountry(request.getParameter("country"));
			dto.setCity(request.getParameter("city"));
			dto.setHinfo(request.getParameter("hinfo"));
			dto.setGrade(request.getParameter("grade"));
			dto.setHcode("H"+request.getParameter("no"));
			dao.gradeHotUpup(dto);
		}
		
		
		request.setAttribute("msg", "작성되었습니다.");
        request.setAttribute("goUrl", "MgPage?mgpage=in");
        request.setAttribute("mainUrl", "greensc/alert.jsp");
		
		
		return null;
	}

}
