package ex0927.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.concurrent.atomic.AtomicInteger;

public class AppListener implements ServletContextListener {

    public AppListener() {
        System.out.println("AppListener.AppListener constructor");
    }

    @Override
    public void contextInitialized(ServletContextEvent e) {
        System.out.println("AppListener.contextInitialized");
        //contextpath 를 application 영역에 저장
        ServletContext application = e.getServletContext();
        application.setAttribute("path",application.getContextPath());
        // 모든 jsp 에서 ${path} 로 contextpath 쉽게 사용

        application.setAttribute("count",new AtomicInteger());// 방문자 수
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("AppListener.contextDestroyed");
    }
}
