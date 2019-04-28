package airsell_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;

public class ShowAirSalesList {

	public ShowAirSalesList(HttpServletRequest request, HttpServletResponse response, String air_code, String bstatus) {
		// TODO Auto-generated constructor stub
		ArrayList<BasketpaidDTO> salesList = new ArrayList<BasketpaidDTO>();
		
		Air_itemDTO dto = new Air_itemDTO();
		dto.setAir_code(air_code);
		ArrayList<Air_itemDTO> dtos = (ArrayList)new Air_itemDAO().itemlistByAir_Code(dto);
		int totalSalse = 0;
		
		for (Air_itemDTO air : dtos) {
			
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(air.getCcode());
			bidto.setBstatus(bstatus);
			
			ArrayList<BasketItemDTO> basketIDs = new BasketItemDAO().basketIDListByRcode(bidto);
			
			for (BasketItemDTO basketid : basketIDs) {
				
				System.out.println("들어는오니?");
				
				BasketpaidDTO bpdto = new BasketpaidDTO();
				bpdto.setBasketID(basketid.getBasketID());
				bpdto.setBstatus(bstatus);
				bpdto = new BasketpaidDAO().detail(bpdto);
				totalSalse+=bpdto.getTotalPrice();
				salesList.add(bpdto);
				
				//예약자 이름 검색하기!!	
			}
			
		}
		
		request.setAttribute("totalSalse", totalSalse);
		request.setAttribute("salesList",salesList);
		request.setAttribute("mainUrl", "airsell/AirSalesList.jsp");
	}
	
}
