package hmain_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import aacommon_p.Common;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class FileDelete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getRealPath("/img");
		//path = "C:\\d\\mainWork\\mainProj\\WebContent\\img";
		//path = "D:\\mainWork\\mainProj\\WebContent\\img";
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
			
			Hot_comDTO dto2 = new Hot_tempDAO().fileDelete(dto);
			
			if(dto2!=null) {
				File ff = new File(path+"\\"+dto2.getHimg());
				ff.delete();
			}
			else {
				dto.setHimg(mm.getParameter("himg"));
			}
				
			request.setAttribute("dto", dto);
					

			request.setAttribute("mainUrl", "hmain/HmodiForm.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
