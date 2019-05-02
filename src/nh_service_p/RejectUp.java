package nh_service_p;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aacommon_p.Common;
import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class RejectUp implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SignUpDTO dto = new SignUpDTO();
		dto.setGrade(request.getParameter("grade"));
		dto.setId(request.getParameter("id"));
		
		
		String path = request.getRealPath("/img");
		path = new Common().getPath();
		
		if(request.getParameter("img")!=null) {
		File ff = new File(path+"\\"+request.getParameter("img"));
		ff.delete();
		}else if(request.getParameter("himg")!=null) {
			File ff = new File(path+"\\"+request.getParameter("himg"));
			ff.delete();
		}
		
		new SignUpDAO().rejectUp(dto);
		
		 request.setAttribute("msg", "거절하였습니다.");
         request.setAttribute("goUrl", "../greensc/MgGradeUp?mgpage=in");
         request.setAttribute("mainUrl", "greensc/alert.jsp");
		
		return null;
	}

}
