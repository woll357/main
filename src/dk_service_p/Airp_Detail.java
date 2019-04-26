//package dk_service_p;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import db_p.Air_comDAO;
//import db_p.Air_itemDTO;
//import di.MvcAction;
//import di.MvcForward;
//
//public class Airp_Detail implements MvcAction {
//
//	@Override
//	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("항공편 찾기");
//		System.out.println(request.getParameter("ddate"));
//		
//		Air_itemDTO dto = new Air_itemDTO();
//		dto.setAp_code(request.getParameter("air_p"));
//		dto.setDdateStr(request.getParameter("ddate"));
//		
//		Air_comDAO dao = new Air_comDAO();
//		
//		request.setAttribute("dto", dao.air_pdetail(request.getParameter("air_p") , request.getParameter("ddate")));
//		
//		return null;
//		
//	}
//
//}



