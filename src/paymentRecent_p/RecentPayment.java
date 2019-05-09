package paymentRecent_p;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.PaymentDAO;
import db_p.PaymentDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class RecentPayment implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = ((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PaymentDTO pdto = new PaymentDTO();
		
		pdto.setId(id);
		pdto = new PaymentDAO().detail(pdto);
		try {
			if(pdto.getcNum1()!=null) {
				request.setAttribute("pdto", pdto);
				}
		} catch (Exception e) {
			request.setAttribute("msg", "최근 이용 내역이 없습니다.");
			//request.setAttribute("goUrl", "../payment/PaymentMain");
		}
		
		
		
		return null;
	}

}
