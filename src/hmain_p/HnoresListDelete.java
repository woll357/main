package hmain_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class HnoresListDelete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Room_itemDTO dto = new Room_itemDTO();
		
		dto.setRcode(request.getParameter("rcode"));
		System.out.println("넌 어떻게나오니"+request.getParameter("rcode"));
		String goUrl = "";
		new Hot_tempDAO().holddelete(dto);
		goUrl = "Hdetail?hotcont=in";
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "hmain/alert.jsp");
		
		return null;
	}

}
