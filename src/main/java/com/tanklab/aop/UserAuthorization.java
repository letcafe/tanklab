package com.tanklab.aop;

import com.tanklab.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class UserAuthorization {

    UserService userService;

    @Autowired
    public UserAuthorization(UserService userService) {
        this.userService = userService;
    }


    //并不是所有方法都要AOP，只要在我们的管理员后台进入点判断就可以，注意切入的方法前添加HttpSession参数
//    @Around("execution(* com.tanklab.controller.NewsController.getAllNews(..))")
//    public String queryDeviceById_before(ProceedingJoinPoint point) throws Throwable {
//        HttpSession userSession = (HttpSession) point.getArgs()[0];//获取切入的第一个方法
//        String loginName = (String)userSession.getAttribute("loginName");//获取Session中的参数，是在登录成功后设置的
//        if(loginName != null) {
//            String loginToPage = (String)point.proceed();
//            return loginToPage;
//        } else {
//            return "/web/login";
//        }
//    }

}
