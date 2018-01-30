package com.tanklab.controller;

import com.tanklab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

public class LoginSessionController {

    private UserService userService;

    @Autowired
    LoginSessionController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/login")
    public String login(HttpSession session, String loginName, String password) throws Exception{
        //验证
        boolean isLogin = userService.loginRight(loginName, password);
        if(isLogin == true) {
            //在Session里保存信息
            session.setAttribute("loginName", loginName);
            //Session超时时间，单位秒
            session.setMaxInactiveInterval(60 * 60);
            return "/web/login";
        } else {
            return "/web/loginError";
        }
    }

    /**
     * 退出系统
     * @param session
     *          Session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();
        return "/web/index";
    }
}
