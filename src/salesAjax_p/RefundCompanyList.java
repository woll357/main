package salesAjax_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class RefundCompanyList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String comcode = request.getParameter("comcode");
		
		if(comcode.substring(0, 1).equals("A")) {
			Air_comDTO adto = new Air_comDTO();
			adto.setAir_code(comcode);
			adto = new Air_comDAO().serarchByAirCode(adto);
			
			BasketpaidDTO bpdto = new BasketpaidDTO();
			bpdto.setcName(adto.getAir_name());
			ArrayList<BasketpaidDTO> comRefundLists = new BasketpaidDAO().comRefundList(bpdto);
			
			request.setAttribute("refundLists", comRefundLists);
			
		}
		else if(comcode.substring(0, 1).equals("H")) {
			
			Hot_comDTO hdto = new Hot_comDTO();
			hdto.setHcode(comcode);
			hdto = new Hot_tempDAO().hotelDetailByhcode(hdto);
			
			BasketpaidDTO bpdto = new BasketpaidDTO();
			bpdto.setcName(hdto.getHname());
			ArrayList<BasketpaidDTO> comRefundLists = new BasketpaidDAO().comRefundList(bpdto);
			
			request.setAttribute("refundLists", comRefundLists);
			
		}
		
		return null;
	}

}
