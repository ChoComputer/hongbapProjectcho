package hongbapProject.attach.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.attach.model.AttachDAO;
import hongbapProject.attach.model.AttachVO;

public class AttachWriteService implements IAttachService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = null;
		session = request.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 댓글 글쓴이가 현재 로그인되어 있는 유저로 표기하기 위해 로그인된 세션을 불러온다. 
		String nick = (String)session.getAttribute("nick_session");
		// 로그인 세션 검사
		if(nick==null) {
				try {
					
					String ui = "/user/userLogin.jsp";
					RequestDispatcher dp = request.getRequestDispatcher(ui);
					dp.forward(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		
		
		Integer iResId = (Integer)session.getAttribute("resId");
		
		
		
		if(iResId==null) {
			System.out.println("레스토랑ID 세션 받기 실패");
		}
		int resId = iResId.intValue();
		System.out.println("댓글쓰기 resId 값 : " + resId);
		
		String awriter = nick;
		String acheck =  nick+"("+resId+")";
		String acontent = (String)request.getParameter("acontent");
		
		String strAssessment = (String)request.getParameter("assessment");
		int assessment = Integer.parseInt(strAssessment);
		
		AttachVO attach = new AttachVO () ;
		attach.setAcheck(acheck);
		attach.setAcontent(acontent);
		attach.setResId(resId);
		attach.setAssessment(assessment);
		attach.setAwriter(awriter);
		
		System.out.println("nick 세션 불러온 값(awriter): "+ awriter);
		AttachDAO dao = AttachDAO.getInstance();
		int resultCode = dao.attachWrite(attach);
		
		if(resultCode==1) {
			System.out.println("댓글, 평점 입력완료");
		}else {
			System.out.println("댓글, 평점 입력실패");
		}
		
		
		
	}
}
