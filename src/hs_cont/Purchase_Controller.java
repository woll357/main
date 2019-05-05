package hs_cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;

/**
 * Servlet implementation class Purchase_Controller
 */
@WebServlet("/purchase/*")
public class Purchase_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			String service = request.getRequestURI().substring("/mainProj/purchase/".length());
			
			request.setAttribute("mainUrl","purchase/"+service+".jsp");
			
			System.out.println(request.getAttribute("mainUrl"));
			
			try {
				MvcAction action = (MvcAction)Class.forName("purchase_p."+service).newInstance();
				
				action.execute(request, response);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
				dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
