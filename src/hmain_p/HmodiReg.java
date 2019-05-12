package hmain_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import aacommon_p.Common;
import db_p.BasketDAO;
import db_p.BasketpaidDAO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class HmodiReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getRealPath("/img");
		 //path = "C:\\d\\mainWork\\mainProj\\WebContent\\img"; 
		path = new Common().getPath();
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			Hot_comDTO dto = new Hot_comDTO();
			
			dto.setHname(mm.getParameter("hname"));
			dto.setHinfo(mm.getParameter("hinfo"));

			dto.setCountry(mm.getParameter("country"));
			dto.setCity(mm.getParameter("city"));
			dto.setId(mm.getParameter("id"));

			
			if(mm.getParameter("himg")!= null)
			dto.setHimg(mm.getParameter("himg"));
			else
			dto.setHimg(mm.getFilesystemName("himg"));
			
			String goUrl = ""; 
			
			
			Hot_comDTO dto2 = new Hot_tempDAO().detail(dto);
			
			
			System.out.println("난 옛날 호텔이름이야!!!!!!!!!!!!!!!!!!!!!1"+dto2.getHname());
			System.out.println("난 새로운 호텔이름이야!!!!!!!!!!!!!!!!!!!1"+mm.getParameter("hname"));
			
			
			new BasketDAO().modifycName(dto2.getHname(), mm.getParameter("hname"));
			new BasketpaidDAO().modifycName(dto2.getHname(), mm.getParameter("hname"));
			 
			
			new Hot_tempDAO().hotmodify(dto);
			goUrl="Hdetail?hotcont=in";
			
			
			
					
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "hmain/alert.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
