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
		String bstatus = "m";

		
		ArrayList<BasketpaidDTO> reserveTotalList = new ArrayList<BasketpaidDTO>();
		
		BasketItemDTO bidto = new BasketItemDTO();
		bidto.setBstatus(bstatus);
		ArrayList<BasketItemDTO> bidtos = new ArrayList<BasketItemDTO>();
		
		bidtos = new BasketItemDAO().basketIDListByBstatus(bidto);
		
		for (BasketItemDTO basketItemDTO : bidtos) {	
			BasketpaidDTO bpdto = new BasketpaidDTO();
			bpdto.setBasketID(basketItemDTO.getBasketID());
			reserveTotalList.add(new BasketpaidDAO().detail(bpdto));
		}
		
		request.setAttribute("reserveTotalList",reserveTotalList);
		
		return null;
	}

}
