package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class Hlist implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("data", new Hot_tempDAO().list());
		return null;
	}

}
