package purchase_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class BuyList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = "1112";
		String bstatus = "p";
		
		BasketpaidDTO bpdto = new BasketpaidDTO();
		
		bpdto.setId(id);
		bpdto.setBstatus(bstatus);
		
		ArrayList<BasketpaidDTO> blists =  new BasketpaidDAO().myList(bpdto);
		ArrayList<BasketpaidDTO> adtos =  new ArrayList<BasketpaidDTO>();
		ArrayList<BasketpaidDTO> hdtos =  new ArrayList<BasketpaidDTO>();
		
		for (BasketpaidDTO blist : blists) {
			if(blist.getcType().equals("A")) {
				adtos.add(blist);
			}
			else if(blist.getcType().equals("H")){
				hdtos.add(blist);
			}
		}

		request.setAttribute("adtos",adtos);
		request.setAttribute("hdtos",hdtos);
		request.setAttribute("mainUrl", "purchase/DetailReserveInfo.jsp");
		request.setAttribute("topUrl", "purchase/DetailReserveInfoTop.jsp");
		
		
		return null;
	}

}
