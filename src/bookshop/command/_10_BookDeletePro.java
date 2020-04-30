package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.ManagerDAO;


public class _10_BookDeletePro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_kind = request.getParameter("book_kind");
		
		//DB연동 - book_id에 해당하는 상품을 삭제
		ManagerDAO bookProcess = ManagerDAO.getInstance();
		bookProcess.deleteBook(book_id); 
		
		request.setAttribute("book_kind", book_kind);
		return "/10_bookDeletePro.jsp";
	}
}