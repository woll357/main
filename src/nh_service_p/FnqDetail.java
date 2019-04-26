package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.CenterDAO;
import db_p.CenterDTO;
import di.MvcAction;
import di.MvcForward;

public class FnqDetail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		CenterDTO dto = new CenterDTO();
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		
		CenterDAO dao = new CenterDAO();
		
		dao.fnqAddCount(dto);
		
		request.setAttribute("dto", dao.fnqDetail(dto));
		
		dao.close();
		
		System.out.println("디테일 서비스 진입");
		
		return null;
	}

}
