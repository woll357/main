package dk_service_p;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.Airp_detailsDAO;
import db_p.LocationinfoDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_ModifyReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String darea = request.getParameter("darea");
		String ddate = request.getParameter("ddate");
		String carea = request.getParameter("carea");
		String ap_code = request.getParameter("ap_code");
		String air_code = ((SignUpDTO)session.getAttribute("mem")).getAir_code();
		
		
		
		Air_itemDTO dto = new Air_itemDTO();
		
		dto.setAp_code(ap_code);
		dto.setDdateStr(ddate);
		dto.setDarea(darea);
		dto.setCarea(carea);
		dto.setMoney(Integer.parseInt(request.getParameter("money")));
		dto.setCcode(request.getParameter("ccode"));
		
		LocationinfoDTO ldto = new LocationinfoDTO();
		 
		ldto.setCarea(carea);
		ldto.setDarea(darea);
			
		ldto = new Air_itemDAO().makea_time(ldto);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date a_time = new Date();
		
		
		try {
			a_time = sdf.parse(ddate);
			
			
			a_time.setMinutes(a_time.getMinutes()+ldto.getLeadtime());
			
			dto.setA_time(a_time);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Air_itemDTO dto3 = new Air_itemDTO();
		dto3.setAir_code(air_code);
		dto3.setAp_code(ap_code);
		dto3.setCcode(request.getParameter("ccode"));
		
		
		new Air_itemDAO().modify(dto);
		new Air_itemDAO().modifyupdate(dto3);
		new Airp_detailsDAO().airConvert();
		
		
		
		
		
		request.setAttribute("msg", "작성되었습니다");
		request.setAttribute("goUrl", "AirItem_List?aotcont=in");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		return null;
	}

}
