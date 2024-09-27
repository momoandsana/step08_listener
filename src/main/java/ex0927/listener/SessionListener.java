package ex0927.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener()
public class SessionListener implements HttpSessionListener {

    public SessionListener() {
        System.out.println("SessionListener.SessionListener constructor");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionCreated");
    }

    /*
    1. session.invalidate() 호출되었을 때
    2. session.timeout() 될 때
    브라우저 창닫기 클릭했을 때 호출되지 않는다
     */

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionDestroyed");
    }


}
