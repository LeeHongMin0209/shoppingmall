package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.QnaBean;
import bookshop.bean.QnaDAO;


public class _26_QnaUpdateForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int qna_id = Integer.parseInt(request.getParameter("qna_id"));
		String book_kind = request.getParameter("book_kind");

		//수정할 qna를 테이블에서 가져옴
		QnaDAO qnaProcess = QnaDAO.getInstance(); 
		QnaBean qna  =  qnaProcess.updateGetArticle(qna_id);
		
		request.setAttribute("qna", qna);
		request.setAttribute("qna_id", new Integer(qna_id));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("type", new Integer(1));
		return "/26_qnaUpdate.jsp";
	}
}