package dk_service_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import di.MvcAction;
import di.MvcForward;

public class FileDelete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String path = request.getRealPath("/img");
		path = "C:\\apache-tomcat-8.5.38\\webapps\\mainProj\\img";
		
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
	
			
			Air_comDTO dto = new Air_comDTO();
			
			
			dto.setAir_code(mm.getParameter("air_code"));
		
		
			String msg = "";
			
			Air_comDTO dto2 = new Air_comDAO().fileDelete(dto);
			
			if(dto2!=null) {
				
				///파일삭제
				File ff = new File(path+"\\"+dto2.getImg());
				ff.delete();
				msg = "파일이 삭제되었습니다.";
				
			}else {
				dto.setImg(mm.getParameter("img"));
			}
			
			
			request.setAttribute("dto", dto);			
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", "AirLine_Detail?aotcont=in");		
			request.setAttribute("mainUrl", "air/ModifyForm.jsp");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
