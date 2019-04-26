package hmain_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.DereDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class HdeletereqReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DereDTO dto = new DereDTO();
		dto.setCode(request.getParameter("Code"));
		dto.setId(request.getParameter("id"));
		dto.setKind(request.getParameter("kind"));
		dto.setRequest(request.getParameter("request"));
		
		new Hot_tempDAO().delewrite(dto);
		
		String goUrl ="Hdetail";
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "hmain/alert.jsp");
		
		return null;
	}

}
