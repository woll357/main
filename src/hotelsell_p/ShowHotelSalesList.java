package hotelsell_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;

public class ShowHotelSalesList {
	
	public ShowHotelSalesList(HttpServletRequest request, HttpServletResponse response, String hcode, String bstatus) {
		// TODO Auto-generated constructor stub
		ArrayList<BasketpaidDTO> salesList = new ArrayList<BasketpaidDTO>();
		
		Room_itemDTO dto = new Room_itemDTO();
		dto.setHcode(hcode);
		ArrayList<Room_itemDTO> dtos = (ArrayList)new Hot_tempDAO().roomlist(dto);
		int totalSalse = 0;
		
		for (Room_itemDTO room : dtos) {
			
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(room.getRcode());
			bidto.setBstatus(bstatus);
			
			ArrayList<BasketItemDTO> basketIDs = new BasketItemDAO().basketIDListByRcode(bidto);
			
			for (BasketItemDTO basketid : basketIDs) {
				
				
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
		request.setAttribute("mainUrl", "hotelsell/HotelSalesList.jsp");
	}
}
