package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _01_ManagerMain implements CommandAction {

	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setAttribute("type", new Integer(0));
		return "/01_managerMain.jsp";
	}
	
}
