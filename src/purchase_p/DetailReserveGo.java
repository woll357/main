package purchase_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class DetailReserveGo {

	public DetailReserveGo(String id, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated constructor stub
		
		BasketpaidDTO dto = new BasketpaidDTO();
		dto.setId(id);
		ArrayList<BasketpaidDTO> myReserveList = new BasketpaidDAO().myReserveList(dto);
		System.out.println("내가 예약한 것 갯수"+myReserveList.size());
		ArrayList<BasketpaidDTO> adtos = new ArrayList<BasketpaidDTO>();
		ArrayList<BasketpaidDTO> hdtos = new ArrayList<BasketpaidDTO>();

		for (BasketpaidDTO bpdto : myReserveList) {
			if(bpdto.getcType().equals("A")) {
				adtos.add(bpdto);
			}
			else if(bpdto.getcType().equals("H")){
				hdtos.add(bpdto);
			}
		}
		
		request.setAttribute("adtos",adtos);
		request.setAttribute("hdtos",hdtos);
		request.setAttribute("mainUrl", "purchase/DetailReserveInfo.jsp");
		request.setAttribute("topUrl", "purchase/DetailReserveInfoTop.jsp");
		
	}

}
