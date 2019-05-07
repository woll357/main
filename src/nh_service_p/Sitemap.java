package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SearchDTO2;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Sitemap implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	    HttpSession session = request.getSession();
	    
	    if(session.getAttribute("mem")==null){
	    	SearchDTO2 dto = new SearchDTO2();
	    }
	    else {
			SignUpDTO chk = new SignUpDTO();

			chk.setId(((SignUpDTO) session.getAttribute("mem")).getId());
	    }
		return null;
	}

}
