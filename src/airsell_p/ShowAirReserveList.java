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

public class ShowAirReserveList {
	public ShowAirReserveList(HttpServletRequest request, HttpServletResponse response, String air_code, String bstatus) {
		Air_itemDTO aidto = new Air_itemDTO();
		aidto.setAir_code(air_code);
		ArrayList<Air_itemDTO> aidtos = new Air_itemDAO().itemlistByAir_Code(aidto);//항공사 코드로 상품코드들 찾기
		
		System.out.println("항공사의 상품갯수 몇개니?"+aidtos.size());
		
		ArrayList<BasketpaidDTO> reserveList = new ArrayList<BasketpaidDTO>();
		
		for (Air_itemDTO ai : aidtos) {
			
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(ai.getCcode());
			bidto.setBstatus(bstatus);
			
			ArrayList<BasketItemDTO> basketIDs = new BasketItemDAO().basketIDListByRcode(bidto);
			
			System.out.println("basketIDs의 크기"+basketIDs.size());
			
			for (BasketItemDTO basketid : basketIDs) {
				
				
				BasketpaidDTO bpdto = new BasketpaidDTO();
				bpdto.setBasketID(basketid.getBasketID());
				bpdto.setBstatus(bstatus);
				reserveList.add(new BasketpaidDAO().detail(bpdto));
				
				//예약자 이름 검색하기!!	
			}
			
		}
		
		request.setAttribute("reserveList",reserveList);

	}
}
