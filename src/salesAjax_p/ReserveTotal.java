package salesAjax_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class ReserveTotal implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		ArrayList<BasketpaidDTO> reserveTotalList = new ArrayList<BasketpaidDTO>();
		
		
		reserveTotalList = new BasketpaidDAO().reserveTotalList();
		
		
		request.setAttribute("reserveTotalList",reserveTotalList);
		
		return null;
	}

}
