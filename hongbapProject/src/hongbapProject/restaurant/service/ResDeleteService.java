package hongbapProject.restaurant.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.attach.model.AttachDAO;
import hongbapProject.menu.model.MenuDAO;
import hongbapProject.restaurant.model.ResDAO;

public class ResDeleteService implements IResService{
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = null;
		session=request.getSession();
		
		Integer IntresId=(Integer)session.getAttribute("resId");
		int resId = IntresId.intValue();
		 
		// menu 테이블과 restaurant 테이블이 외래키로 연결되어있기 때문에
		// menu 테이블 행부터 삭제 해야함
		MenuDAO mdao = MenuDAO.getInstance();
		int mDeleteResult = mdao.menuDelete(resId);
		
		
		if(mDeleteResult ==1) {
			System.out.println("메뉴 삭제 완료");
		}else {
			System.out.println("메뉴 삭제 실패");
		}
		
		// restaurant 테이블과 참조 관계인 resAttacht 테이블도 삭제해야함 
		AttachDAO adao = AttachDAO.getInstance();
		int aDeleteResult = adao.attachDeleteAll(resId);
		
		if(aDeleteResult == 1) {
			System.out.println("식당 평가 삭제 완료");
		}
		else {
			System.out.println("식당 평가 삭제 실패");
		}
		
		// 그 후 레스토랑 행 삭제
		ResDAO rdao = ResDAO.getInstance();
		int rDeleteResult = rdao.resDelete(resId);
		if(rDeleteResult == 1) {
			System.out.println("레스토랑 삭제 완료");
			session.removeAttribute("resId");
		// 레스토랑 행 삭제되면 발급된 레스토랑 Id 세션 삭제
		}else {
			System.out.println("레스토랑 삭제 실패");
		}
		
		
	}
}
