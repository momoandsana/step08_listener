package ex0924.servlet;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login" , loadOnStartup = 1)
public class LoginCheckServlet extends HttpServlet {
	//비교정보
	  String dbId="jang", dbPwd="1234";
	  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  //전송된 데이터 받기
		  String userId= request.getParameter("userId");
		  String userPwd= request.getParameter("userPwd");
		   String userName= request.getParameter("userName");
		   
		   if(dbId.equals(userId) && dbPwd.equals((userPwd))){
			   System.out.println("LoginCheckServlet.doPost");
			   //세션에 아이디, 이름, 접속시간 을 저장
			   HttpSession session = request.getSession();
			   
			   session.setAttribute("sessionId", userId);
			   session.setAttribute("sessionName", userName);
			   
			   
			   //session.getCreationTime()//세션이시작한 시간 ms			   
			   
			   //로그인된 시간
			   Calendar cal=  Calendar.getInstance();//현재날짜와 시간설정
			   int y = cal.get(Calendar.YEAR);
			   int m = cal.get(Calendar.MONTH)+1;
			   int d = cal.get(Calendar.DATE);
			   
			   int h = cal.get(Calendar.HOUR_OF_DAY);
			   int min = cal.get(Calendar.MINUTE);
			   int s = cal.get(Calendar.SECOND);
			   
			   StringBuilder sb = new StringBuilder();
			   sb.append(y+"년 ");
			   sb.append(m+"월 ");
			   sb.append(d+"일 ");
			   sb.append(h+"시 ");
			   sb.append(min+"분 ");
			   sb.append(s+"초");
			   
			   session.setAttribute("creationTime", sb.toString());
			   
			   //이동한다.
			   response.sendRedirect("session/LoginOk.jsp");
			   
		   }else{
			 //response.setContentType("text/html; charset=UTF-8");

//			 PrintWriter out = response.getWriter();
//			 out.println("<script>");
//			 out.println("alert('" + userName + "님 정보를 다시 확인해주세요.')");
//			 out.println("history.back();");
//			 out.println("</script>");

			   request.setAttribute("errMsg", userName + "님 정보를 확인해주세요");
			   request
					   .getRequestDispatcher("/error/error.jsp")
					   .forward(request, response);
		   }
		
	}
}



