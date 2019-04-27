package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirCom_Detail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
		
	
		HttpSession session = request.getSession();
		System.out.println(((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
		System.out.println("항공편 목록 진입");
		System.out.println("항공편 찾기 목록 ㅈㅂㅈㅂㅈㅂ시바;러마ㅣㄴ");
		
		System.out.println(request.getParameter("air_p"));
		//System.out.println(request.getParameter("air_code"));
		
		
		
		//System.out.println(request.getParameter("id"));
		
		Air_itemDTO dto = new Air_itemDTO();
		dto.setAp_code(request.getParameter("air_p"));
		
		Air_itemDAO dao = new Air_itemDAO();
		
	      request.setAttribute("data", dao.air_pitemlistsarch(request.getParameter("air_p"),((SignUpDTO) session.getAttribute("mem")).getAir_code()));
		
		//request.setAttribute("data", dao.air_pitemlistsarch(request.getParameter("air_p"), request.getParameter("air_code")));
		request.setAttribute("id", ((SignUpDTO) session.getAttribute("mem")).getId());
		return null;
	}

}
