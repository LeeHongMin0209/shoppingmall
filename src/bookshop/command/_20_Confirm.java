package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bookshop.bean.MemberDAO;

public class _20_Confirm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		  
		//주어진 id의 중복여부를 체크해 값을 반환.
		MemberDAO manager = MemberDAO.getInstance();
		int check= manager.confirm(id);
		
		request.setAttribute("check", new Integer(check));
		return "/20_confirm.jsp";
	}
}