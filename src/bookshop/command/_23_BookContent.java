package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.ManagerBean;
import bookshop.bean.ManagerDAO;
import bookshop.bean.QnaBean;
import bookshop.bean.QnaDAO;

public class _23_BookContent implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		
		List<QnaBean> qnaLists;
		String book_kind = request.getParameter("book_kind");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		
		//book_id에 해당하는 상품을 얻어냄
		ManagerDAO bookProcess = ManagerDAO.getInstance();
		ManagerBean book = bookProcess.getBook(book_id);
		
		//book_id에 해당하는 상품의 QnA 수를 얻어냄
		QnaDAO qnaProcess = QnaDAO.getInstance();
		int count = qnaProcess.getArticleCount(book_id);
	
		if (count > 0){//QnA가 있으면 수행
			///book_id에 해당하는 상품의 QnA를 얻어냄 
			qnaLists = qnaProcess.getArticles(count, book_id);
        	request.setAttribute("qnaLists", qnaLists);
        }

		request.setAttribute("book", book);
		request.setAttribute("book_id", new Integer(book_id));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(1));
		return "/23_bookContent.jsp";
	}
}