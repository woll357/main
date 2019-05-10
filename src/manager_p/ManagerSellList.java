package manager_p;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class ManagerSellList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
//		String bstatus = "p";
//
//		ArrayList<BasketpaidDTO> managerSellList = new ArrayList<BasketpaidDTO>();
//		
//		BasketItemDTO bidto = new BasketItemDTO();
//		bidto.setBstatus(bstatus);
//		ArrayList<BasketItemDTO> bidtos = new ArrayList<BasketItemDTO>();
//		
//		bidtos = new BasketItemDAO().basketIDListByBstatus(bidto);
//		
//		for (BasketItemDTO basketItemDTO : bidtos) {	
//			BasketpaidDTO bpdto = new BasketpaidDTO();
//			bpdto.setBasketID(basketItemDTO.getBasketID());
//			managerSellList.add(new BasketpaidDAO().detail(bpdto));
//		}
//		
//		request.setAttribute("managerSellList",managerSellList);
		
		//연도설정
		int yearLimit = 10;
		
		Date today = new Date();
		int startYear = today.getYear()-yearLimit+1900;
		int todayYear = today.getYear()+1900;
		ArrayList<String> years = new ArrayList<String>();
		
		for (int i = startYear; i <= todayYear; i++) {
			years.add(""+i);
		}
		
		request.setAttribute("years", years);
		request.setAttribute("mainUrl", "manager/ManagerSellList.jsp");
		
		//회사명설정
		HashMap<String, String> clists = new HashMap<String, String>();
		
		ArrayList<BasketpaidDTO> comlists =	new BasketpaidDAO().findComNameComcode();
		
		for (BasketpaidDTO bdto : comlists) {
			clists.put(bdto.getComcode(), bdto.getcName());
		
		}
		
		request.setAttribute("clists", clists);
		
		return null;
	}

}
