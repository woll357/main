package hmain_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDTO;
import db_p.Hold_tableDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class HnoresDatewriteReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		BasketItemDTO bdto = new BasketItemDTO();
		
		int rcnt = Integer.parseInt(request.getParameter("rcnt"));
		bdto.setRcode(request.getParameter("rcode"));
		int nonorcnt = new Hot_tempDAO().norescnt(bdto, request.getParameter("noresdate"));
		new Hot_tempDAO().norescnt(bdto, request.getParameter("noresdate"));
/*		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+new Hot_tempDAO().norescnt(bdto ,request.getParameter("noresdate") ));
				
		System.out.println("총 방갯수야!!!!!!!!!!!!!"+rcnt);
		System.out.println("예약된 방갯수야!!!!!!!!!!!!!!!"+nonorcnt);
		System.out.println("내가 선택한 예약불가 방갯수야!!!!!!!!!!!!"+request.getParameter("norescnt"));*/
		
		if(rcnt<Integer.parseInt(request.getParameter("norescnt"))+new Hot_tempDAO().norescnt(bdto, request.getParameter("noresdate"))) {
			
			System.out.println("실패했습니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			String goUrl ="Hdetail?hotcont=in";
			String msg = "예약목록을 확인해주세요";
			
			
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "hmain/alert2.jsp");
			
		}
		
		else {
		Hold_tableDTO dto = new Hold_tableDTO();
		
		//dto.setTitle(request.getParameter("title"));
		
		dto.setNorescnt(Integer.parseInt(request.getParameter("norescnt")));
		dto.setReason(request.getParameter("reason"));
		dto.setNoresdateStr((request.getParameter("noresdate")));
		dto.setRcode(request.getParameter("rcode"));
		
		new Hot_tempDAO().noreswrite(dto);
		
					   
		String goUrl ="Hdetail?hotcont=in";
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "hmain/alert.jsp");
		}
		return null;
	}

}
