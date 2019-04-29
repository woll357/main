package hmain_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import aacommon_p.Common;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class HroommodiReg implements MvcAction {

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
		
			Room_itemDTO dto = new Room_itemDTO();
			dto.setRkind(mm.getParameter("rkind"));
			dto.setRcnt(Integer.parseInt(mm.getParameter("rcnt")));
			dto.setPcnt(Integer.parseInt(mm.getParameter("pcnt")));
			dto.setRcode(mm.getParameter("rcode"));
			
			if(mm.getParameter("rimg")!= null) {
				dto.setRimg(mm.getParameter("rimg"));
			}else
				dto.setRimg(mm.getFilesystemName("rimg"));
			
			dto.setMoney(Integer.parseInt(mm.getParameter("money")));
			dto.setWmoney(Integer.parseInt(mm.getParameter("wmoney")));
			
			dto.setWifi(mm.getParameter("wifi"));
			dto.setMorning(mm.getParameter("morning"));
			
			String goUrl = "";
			
			
			new Hot_tempDAO().roommodify(dto);
			goUrl = "Hdetail";
			
			/*
			 * if((mm.getParameter("rimg")==null)){ File ff = new
			 * File(path+"\\"+dto.getRimg()); ff.delete(); }
			 */
			
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "hmain/alert.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
