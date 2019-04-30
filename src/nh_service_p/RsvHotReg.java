package nh_service_p;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SearchDAO;
import db_p.SearchDTO;
import db_p.SearchDTO2;
import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class RsvHotReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String start = request.getParameter("startDay");
	    String end = request.getParameter("endDay");
	    long diffDays = 0;
	    try {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date beginDate = formatter.parse(start);
	        Date endDate = formatter.parse(end);
	         
	        long diff = endDate.getTime() - beginDate.getTime();
	        diffDays = diff / (24 * 60 * 60 * 1000);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		
	    HttpSession session = request.getSession();
		
	    if(session.getAttribute("mem")==null){
	    	SearchDTO2 dto = new SearchDTO2();
			dto.setCity(request.getParameter("city"));
			dto.setPcnt(Integer.parseInt(request.getParameter("pcnt")));
			dto.setStartDay(request.getParameter("startDay"));
			dto.setEndDay(request.getParameter("endDay"));
			dto.setRkind(request.getParameter("rkind"));
		
			request.setAttribute("dto", new SearchDAO().searchHot(dto));
	    	
	    	
	    }else{
		SignUpDTO chk = new SignUpDTO();

		chk.setId(((SignUpDTO) session.getAttribute("mem")).getId());

		
		
		if(new SignUpDAO().chkBlack(chk)) {
	    
	    
		SearchDTO2 dto = new SearchDTO2();
		dto.setCity(request.getParameter("city"));
		dto.setPcnt(Integer.parseInt(request.getParameter("pcnt")));
		dto.setStartDay(request.getParameter("startDay"));
		dto.setEndDay(request.getParameter("endDay"));
		dto.setRkind(request.getParameter("rkind"));
	
		request.setAttribute("dto", new SearchDAO().searchHot(dto));
		}else {
			
			request.setAttribute("msg", "개인 정보상의 문제로 조회가 불가능합니다..");
	        request.setAttribute("goUrl", "../greensc/Home");
	        request.setAttribute("mainUrl", "greensc/alert.jsp");
			
		}
	    }

		return null;
	}

}
