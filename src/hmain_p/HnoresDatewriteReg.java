package hmain_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
		Hold_tableDTO dto = new Hold_tableDTO();
		
		//dto.setTitle(request.getParameter("title"));
		
		
		dto.setNorescnt(Integer.parseInt(request.getParameter("norescnt")));
		dto.setReason(request.getParameter("reason"));
		dto.setNoresdateStr((request.getParameter("noresdate")));
		dto.setRcode(request.getParameter("rcode"));
		
		new Hot_tempDAO().noreswrite(dto);
		

		String goUrl ="Hdetail";
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "hmain/alert.jsp");
		
		return null;
	}

}
