package salesAjax_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;
import di.MvcForward;

public class RefundCompanyList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String comcode = request.getParameter("comcode");
		
		System.out.println(comcode);
		
		request.setAttribute("comcode", comcode);
		
		return null;
	}

}
