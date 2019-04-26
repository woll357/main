package payment_p;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDTO;
import db_p.BuyDAO;
import db_p.BuyDTO;
import db_p.PaymentDAO;
import db_p.PaymentDTO;
import di.MvcAction;
import di.MvcForward;

public class PaymentReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
			
			String id = "1112";
			int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
			
			String [] basketIDs = request.getParameterValues("basketIDs");
			
			PaymentDTO dto = new PaymentDTO();
			dto.setcComName(request.getParameter("cComName"));
			String cNum = "";
			for (String cn : request.getParameterValues("cNum")) {
				cNum+=cn;
			};
			dto.setcNum(cNum);
			String exDate = "";
			for (String ed : request.getParameterValues("exDate")) {
				exDate+=ed;
			};
			dto.setExDate(exDate);
			dto.setcPw(request.getParameter("cPw"));
			dto.setCvc(request.getParameter("cvc"));
			dto.setId(id);//id
			new PaymentDAO().modify(dto);
			
			dto = new PaymentDAO().detail(dto);
			
			BuyDTO bdto = new BuyDTO();
			
			bdto.setBnum(basketIDs.length); //bnum
			Date now = new Date();
			bdto.setBdate(now);//현재시간
			bdto.setId(id);//내아이디
			bdto.setTotalPrice(totalPrice);;
			bdto.setpCode(""+dto.getpCode());
			
			new BuyDAO().insert(bdto); //구매테이블 만들었다.
			
			for (int i = 0; i < basketIDs.length; i++) {
				
				BasketDTO badto = new BasketDTO();

				badto.setBasketID(basketIDs[i]);
				
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
//		request.setAttribute("mainUrl", "basket/BasketMain.jsp");
//		request.setAttribute("topUrl", "basket/BasketMainTop.jsp");
		return null;
	}

}
