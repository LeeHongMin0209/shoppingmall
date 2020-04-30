package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.QnaBean;
import bookshop.bean.QnaDAO;


public class _29_QnaList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		List<QnaBean> qnaLists;
	
		//DB연동 - 상품QnA의 수를 얻어낸
		QnaDAO qnaProcess = QnaDAO.getInstance();
		int count = qnaProcess.getArticleCount();
		
		if (count > 0){//상품QnA가 있으면 수행
			//지정한 수만큼의 상품QnA를 얻어냄
			qnaLists = qnaProcess.getArticles(count);
        	request.setAttribute("qnaLists", qnaLists);
        }
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(0));
		return "/29_qnaList.jsp";
	}
}
