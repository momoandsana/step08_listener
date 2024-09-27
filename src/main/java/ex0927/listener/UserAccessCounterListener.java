package ex0927.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

public class UserAccessCounterListener implements ServletContextListener, HttpSessionListener {


    /*
    서버가 시작될 applicationScope 영역에 nowCounter 값을 초기화한다
    AtomicInteger()


     */

    ServletContext application;

    @Override
    public void contextInitialized(ServletContextEvent e) {
        application = e.getServletContext();
        application.setAttribute("nowCounter",new AtomicInteger());
        // ${nowCounter}
    }
    /*
    nowCounter 의 값을 1 증가
     */

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        AtomicInteger at = (AtomicInteger)application.getAttribute("nowCounter");
        int nowCounter=at.incrementAndGet();
        System.out.println("증가된 후(현재 접속자 수) = " + nowCounter);
    }

    /*
    nowCounter 의 값을 1 감소
     */

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        AtomicInteger at = (AtomicInteger) application.getAttribute("nowCounter");
        int nowCounter=at.decrementAndGet();
        System.out.println("감소된 후(현재 접속자 수) = " + nowCounter);
    }

}
