package purchase_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class BuyList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = ((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		
		BasketpaidDTO bpdto = new BasketpaidDTO();
		
		bpdto.setId(id);
		
		ArrayList<BasketpaidDTO> blists =  new BasketpaidDAO().myList(bpdto);
		
		System.out.println("myList진입하니?"+blists.size()+"널일까?");
		
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
		request.setAttribute("mainUrl", "purchase/BuyList.jsp");
		
		
		return null;
	}

}
