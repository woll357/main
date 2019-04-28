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

public class ShowHotelReserveList {
	public ShowHotelReserveList(HttpServletRequest request, HttpServletResponse response, String hcode, String bstatus) {
		// TODO Auto-generated constructor stub
		ArrayList<BasketpaidDTO> reserveList = new ArrayList<BasketpaidDTO>();
		
		Room_itemDTO dto = new Room_itemDTO();
		dto.setHcode(hcode);
		ArrayList<Room_itemDTO> dtos = (ArrayList)new Hot_tempDAO().roomlist(dto);
		
		for (Room_itemDTO room : dtos) {
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(room.getRcode());
			bidto.setBstatus(bstatus);
			
			ArrayList<BasketItemDTO> basketIDs = new BasketItemDAO().basketIDListByRcode(bidto);
			
			for (BasketItemDTO basketid : basketIDs) {
				
				
				BasketpaidDTO bpdto = new BasketpaidDTO();
				bpdto.setBasketID(basketid.getBasketID());
				bpdto.setBstatus(bstatus);
				reserveList.add(new BasketpaidDAO().detail(bpdto));
				
				//예약자 이름 검색하기!!	
			}
			
		}
		
		request.setAttribute("reserveList",reserveList);
		request.setAttribute("mainUrl", "hotelsell/HotelReserveList.jsp");
		request.setAttribute("topUrl", "hotelsell/HotelReserveListTop.jsp");
	}
}
