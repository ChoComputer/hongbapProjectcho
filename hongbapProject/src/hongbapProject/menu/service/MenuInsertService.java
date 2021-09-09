package hongbapProject.menu.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.menu.model.MenuDAO;
import hongbapProject.menu.model.MenuVO;
import hongbapProject.restaurant.model.ResDAO;

public class MenuInsertService implements IMenuService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = null;
		session = request.getSession();
		
		String menuName=request.getParameter("menuName");
		String menuBook=request.getParameter("menuBook");
		String menuPrice= request.getParameter("menuPrice");
		
		String strResId = (String)request.getParameter("resId");
		int resId = Integer.parseInt(strResId);
		System.out.println("메뉴입력 위한 resId 값 : "+ resId);

		MenuDAO dao = MenuDAO.getInstance();
		
		MenuVO menu = new MenuVO();
		menu.setResId(resId);
		menu.setMenuName(menuName);
		menu.setMenuBook(menuBook);
		menu.setMenuPrice(menuPrice);
		
		
		int resultCode=dao.insertMenu(menu);
		if(resultCode ==1 ) {
			System.out.println("메뉴 입력 완료");
		}else {
			System.out.println("메뉴 입력 실패");
		}
		
		
		
		
	}
	
}
