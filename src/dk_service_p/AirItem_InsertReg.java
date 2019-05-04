package dk_service_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.Air_planeDAO;
import db_p.Airp_detailsDAO;
import db_p.LocationinfoDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_InsertReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		//항공편 등록 INSERT
		Air_itemDTO dto = new Air_itemDTO();
		
		String darea = request.getParameter("darea");
		String ddate = request.getParameter("ddate")+" "+request.getParameter("h")+":"+request.getParameter("m")+":"+request.getParameter("s");
		String carea = request.getParameter("carea");
		String air_code = ((SignUpDTO) session.getAttribute("mem")).getAir_code();
		String ap_code = request.getParameter("ap_code");
		String msg = "";
		String goUrl = "";
		
		Air_itemDTO dto2 = new Air_itemDTO();
		dto2.setAir_code(air_code);
		
		dto2 = new Air_itemDAO().makeimg(dto2);
		
		dto.setAp_code(ap_code);
		dto.setDdateStr(ddate);
		dto.setDarea(darea);
		dto.setImg(dto2.getImg());
		dto.setAir_code(air_code);
		dto.setCarea(carea);
		dto.setMoney(Integer.parseInt(request.getParameter("money")));
		
		
		
		
		LocationinfoDTO ldto = new LocationinfoDTO();
		
		ldto.setCarea(carea);
		ldto.setDarea(darea);
		
		
		ldto = new Air_itemDAO().makea_time(ldto);
		
		LocationinfoDTO pdto = new LocationinfoDTO();
		pdto.setDarea(darea);
		pdto.setCarea(carea);
		
		pdto = new Air_itemDAO().makeair_p(pdto);
		
		dto.setAir_p(pdto.getAir_p());
		
	
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
	
		
		if(	new Air_itemDAO().itemtimedetail(dto)) {		

			msg="같은날 상품이 있습니다.";
			goUrl = "AirItem_List?aotcont=in";
		
		}else if(new Air_planeDAO().apvalidity(air_code,ap_code)) {
			
			msg = "추가되었습니다.";
			goUrl = "AirItem_List?aotcont=in";
			
			
			new Air_itemDAO().insert(dto);
			new Airp_detailsDAO().airConvert();
			
			
			
		}
		
		
		else {
			
			msg = "없는 비행기입니다.";
			goUrl = "AirItem_Insert";
		}
		
		
	
		
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
