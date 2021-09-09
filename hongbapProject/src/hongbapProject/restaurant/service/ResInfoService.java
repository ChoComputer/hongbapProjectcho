package hongbapProject.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.menu.model.MenuDAO;
import hongbapProject.menu.model.MenuVO;
import hongbapProject.restaurant.model.ResDAO;
import hongbapProject.restaurant.model.ResVO;

public class ResInfoService implements IResService {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			HttpSession session = null;
			session = request.getSession();
			
			
			String strid = (String)request.getParameter("resId");
			System.out.println("strid값 : "+strid);
			int resId = Integer.parseInt(strid);
		
			ResDAO dao = ResDAO.getInstance();
			MenuDAO mdao = MenuDAO.getInstance();
			
			MenuVO menu = new MenuVO();
			ResVO resResult = new ResVO();
			
			
			menu = mdao.getMenu(resId);
			resResult = dao.getResInfo(resId);
			
			System.out.println("menu 정보 : "+ menu);
			request.setAttribute("resResult", resResult);
			request.setAttribute("menu", menu);
			
			// resId 세션 발급(후에 이것으로 레스토랑 삭제, 레스토랑 수정, 메뉴 조회 가능)
			session.setAttribute("resId", resId);
			System.out.println("resId 세션 값 : "+ resId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	

}
