package dk_service_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_ModifyReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+request.getParameter("ap_code"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+request.getParameter("ccode"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+request.getParameter("ddate"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+request.getParameter("carea"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+request.getParameter("money"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+Integer.parseInt(request.getParameter("money")));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+Integer.parseInt(request.getParameter("money")));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>c코드라구 ㅜ"+Integer.parseInt(request.getParameter("money")));
		
		Air_itemDTO dto = new Air_itemDTO();
		
		dto.setAp_code(request.getParameter("ap_code"));
		dto.setDdateStr(request.getParameter("ddate"));
		dto.setDarea(request.getParameter("darea"));
		dto.setCarea(request.getParameter("carea"));
		dto.setMoney(Integer.parseInt(request.getParameter("money")));
		dto.setTotseatcnt(Integer.parseInt(request.getParameter("totseatcnt")));
		dto.setFlightclass(request.getParameter("flightclass"));
		dto.setCcode(request.getParameter("ccode"));
		
		Air_itemDAO dao = new Air_itemDAO();
		
		//dao.modify( dto , request.getParameter("ccode"));
		dao.modify(dto);
	//	dto.setCcode(request.getParameter("ccode"));
		
		
		
		
		request.setAttribute("msg", "작성되었습니다");
		request.setAttribute("goUrl", "AirItem_Detail?ccode="+request.getParameter("ccode"));
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		return null;
	}

}
