package hmain_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		path = "D:\\mainWork\\mainProj\\WebContent\\img";
		
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
			
			new Hot_tempDAO().hotmodify(dto);
			goUrl="Hmain";

					
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "hmain/alert.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
