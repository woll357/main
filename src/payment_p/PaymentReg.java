package payment_p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.BuyDAO;
import db_p.BuyDTO;
import db_p.PaymentDAO;
import db_p.PaymentDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class PaymentReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
			
			String id =((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
			
			String [] basketIDs = request.getParameterValues("basketIDs");
			String cComName = request.getParameter("cComName");
			
			
			//결제정보 입력
			
			PaymentDTO dto = new PaymentDTO();

		
			String cNum = "";
			for (String cn : request.getParameterValues("cNum")) {
				cNum+=cn;
			};
		
			String exDate = "";
			for (String ed : request.getParameterValues("exDate")) {
				exDate+=ed;
			};
			
			String cPw = request.getParameter("cPw");
			String cvc = request.getParameter("cvc");

			
			for (int i = 0; i < basketIDs.length; i++) {
				System.out.println("==============================="+basketIDs[i]);
				
				BasketDTO tt = new BasketDTO();
				tt.setBasketID(basketIDs[i]);
				tt = new BasketDAO().detail(tt);
				
				
				BuyDTO bdto = new BuyDTO();
				
				bdto.setBasketID(basketIDs[i]); //bnum
				Date now = new Date();
				bdto.setBdate(now);//현재시간
				bdto.setId(id);//내아이디
				bdto.setTotalPrice(tt.getTotalPrice());
				
				new BuyDAO().insert(bdto); //구매테이블 만들었다.
				
				
				bdto = new BuyDAO().detail(bdto); //구매튜플의 구매코드 가지고오기
				
				System.out.println(bdto.getBcode()+"bcode나와라!!!!!!!!!!!!");
				
				dto.setBcode(bdto.getBcode());
				dto.setcComName(cComName);
				dto.setcNum(cNum);
				dto.setExDate(exDate);
				dto.setcPw(cPw);
				dto.setCvc(cvc);
				dto.setId(id);

				
				new PaymentDAO().insert(dto);		
				
				dto = new PaymentDAO().detail(dto);
				
				bdto.setpCode(""+dto.getpCode());
				bdto.setBdate(now);
				bdto.setId(id);
				
				new BuyDAO().givePcode(bdto);
				
				/////////////////////장바구니 넘기기
				BasketDTO badto = new BasketDTO();
				BasketpaidDTO bpdto = new BasketpaidDTO();
				
				System.out.println(basketIDs[i]+"장바구니 코드는 나오니?");
				badto.setBasketID(basketIDs[i]);				
				bpdto.setBasketID(basketIDs[i]);
				
				badto = new BasketDAO().detail(badto);
				
				System.out.println(badto.getDdateStr()+"이거 널이니?");
				
				bpdto.setBasketID(badto.getBasketID());
				bpdto.setcType(badto.getcType());
				bpdto.setcNum(badto.getcNum());
				bpdto.setcName(badto.getcName());
				bpdto.setItemName(badto.getItemName());
				bpdto.setDdate(badto.getDdate());
				bpdto.setFdate(badto.getFdate());
				bpdto.setLocation1(badto.getLocation1());
				bpdto.setLocation2(badto.getLocation2());
				bpdto.setTotalPrice(badto.getTotalPrice());
				bpdto.setPsn(badto.getPsn());
				bpdto.setBcode(bdto.getBcode());
				bpdto.setId(badto.getId());
				
				new BasketpaidDAO().insert(bpdto); //구매된 장바구니에 넣는다.
				new BasketDAO().delete(badto);	//기존 장바구니에서 삭제한다.
				
				BasketItemDTO bidto = new BasketItemDTO();
				bidto.setBasketID(basketIDs[i]);
				bidto.setBstatus("m");
				new BasketItemDAO().modifyBstatus(bidto); //모든  상품코드의 상태를 예약상태로 바뀐다.
				
			}
			
				//클래스로 빼기, 구매코드별 장바구니 항목 보기
				
				ArrayList<BasketpaidDTO> adtos = new ArrayList<BasketpaidDTO>();
				ArrayList<BasketpaidDTO> hdtos = new ArrayList<BasketpaidDTO>();
		
				
				int totalPrice = 0;
				
				for (int j = 0; j < basketIDs.length; j++) {
					BasketpaidDTO jbdto = new BasketpaidDTO();
						jbdto.setBasketID(basketIDs[j]);
					jbdto = new BasketpaidDAO().detail(jbdto);
					totalPrice += jbdto.getTotalPrice();
					
					if(jbdto.getcType().equals("A")) {
						adtos.add(jbdto);
					}
					else if(jbdto.getcType().equals("H")) {
						hdtos.add(jbdto);
					}
				}
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("hdtos",hdtos);
				request.setAttribute("adtos",adtos);
				request.setAttribute("mainUrl", "payment/JustBuyDetail.jsp");
			}
			
		 catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
