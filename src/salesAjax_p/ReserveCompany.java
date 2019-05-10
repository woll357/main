package salesAjax_p;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class ReserveCompany implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HashMap<String, String> clists = new HashMap<String, String>();
		
		ArrayList<BasketpaidDTO> comlists =	new BasketpaidDAO().findComNameComcode();
		
		for (BasketpaidDTO bdto : comlists) {
			clists.put(bdto.getComcode(), bdto.getcName());
		
		}
		
		request.setAttribute("clists", clists);
		
		return null;
	}

}
