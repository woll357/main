package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class AirCom_Detail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		
//		System.out.println("항공사 수정 페이지");
//		
//		Air_comDTO dto = new Air_comDTO();
//		
//
//		dto.setId(request.getParameter("id"));
//	
//		
//		Air_comDAO dao = new Air_comDAO() ;
//		
//		request.setAttribute("dto", dao.comdetail(dto));
		
		
		
		
		System.out.println("항공편 목록 진입");
		
		System.out.println((request.getParameter("air_p")));
		
		Air_itemDTO dto = new Air_itemDTO();
		dto.setAp_code(request.getParameter("air_p"));
		
		Air_comDAO dao = new Air_comDAO();
		
		request.setAttribute("dto", dao.air_pdetaill(request.getParameter("air_p")));
		
		return null;
	}

}
