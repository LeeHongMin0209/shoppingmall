package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.BuyBean;
import bookshop.bean.BuyDAO;

public class _39_BuyList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String buyer = request.getParameter("buyer");
		
		List<BuyBean> buyLists = null;
		int count = 0;
		
		//해당 buyer의 구매목록의 수를 얻어냄
		BuyDAO buyProcess = BuyDAO.getInstance();
		count = buyProcess.getListCount(buyer);

		if(count > 0){//구매 목록이 있으면 수행
			//해당 buyer의 구매목록을 얻어냄
			buyLists = buyProcess.getBuyList(buyer);
			request.setAttribute("buyLists",buyLists);
		}
	
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(1));
		return "/39_buyList.jsp";
	}
}