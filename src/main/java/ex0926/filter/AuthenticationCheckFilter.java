package ex0926.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/session/LoginOk.jsp"})
public class AuthenticationCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 사전처리
        System.out.println("오니?");

        HttpServletRequest req = (HttpServletRequest) request;//ServletRequest 가 부모이기 때문에
        HttpSession session = req.getSession();
//        System.out.println(session.getAttribute("sessionId"));
//        System.out.println(session.getAttribute("sessionName"));
//        System.out.println(session.getAttribute("creationTime"));

        if(session.getAttribute("sessionId")==null)
        {
            // 오류 페이지로 이동하기 전에 오류메시지 저장
            req.setAttribute("errMsg","로그인하고 jjjj이용해주세요");
            // 에러메시지를 세션에 저장해서 보낸다.
            // 뷰에서 ${errMsg} requestScope.errMsg
            req.getRequestDispatcher("../error/error.jsp").forward(request, response);
            return;// 다음 doFilter 함수가 실행되면 안 되니까
        }

        chain.doFilter(request,response);

        //사후처리
    }
}
