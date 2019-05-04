package hmain_p;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aacommon_p.Common;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class HroomDeleteReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getRealPath("/img");
		//path = "C:\\d\\mainWork\\greenScProj2\\WebContent\\img";
		//path = "D:\\mainWork\\mainProj\\WebContent\\img";
		path = new Common().getPath();
		
		Room_itemDTO dto = new Room_itemDTO();
		
		dto.setRcode(request.getParameter("rcode"));
		System.out.println("넌뭐냐 "+request.getParameter("rcode"));
		
		String goUrl = "";

		Room_itemDTO dto2 = new Hot_tempDAO().filedelete2(dto);
		
		if(dto2!=null && dto2.getRimg()!=null) {			
			File ff = new File(path+"\\"+dto2.getRimg());
			ff.delete();			
		}
		new Hot_tempDAO().roomdelete(dto);

		goUrl = "Hdetail?hotcont=in";


		
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "hmain/alert.jsp");
		
		return null;
	}

}
