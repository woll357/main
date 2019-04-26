package nh_service_p;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SearchDAO;
import db_p.SearchDTO;
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

		
		SearchDTO dto = new SearchDTO();
		//city, pcnt, startDay, endDay, rcode
		dto.setCity(request.getParameter("city"));
		dto.setPcnt(Integer.parseInt(request.getParameter("pcnt")));
		dto.setStartDay(request.getParameter("startDay"));
		dto.setEndDay(request.getParameter("endDay"));
		dto.setRkind(request.getParameter("rkind"));
	
		
		ArrayList<SearchDTO> arr = (ArrayList<SearchDTO>) new SearchDAO().searchHot(dto, (int)diffDays);
		request.setAttribute("dto", arr);


		return null;
	}

}
