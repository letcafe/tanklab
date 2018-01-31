package com.tanklab.controller;

import com.tanklab.bean.User;
import com.tanklab.service.UserService;
import com.tanklab.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping(value="/")
public class LoginSessionController {

    private UserService userService;

    @Autowired
    LoginSessionController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/admin/login")
    public String login(HttpSession session, Model model,
            String loginName, String password) throws Exception{
        //验证

        User user = userService.loginRight(loginName,MD5.GetMD5Code(password));
        if(user!=null) {
            //在Session里保存信息
            session.setAttribute("loginName",loginName);
            //Session超时时间，单位秒
            session.setMaxInactiveInterval(60 * 60);
            return "/admin/news?page=1";
        } else {
            model.addAttribute("message","用户名或密码错误");
            model.addAttribute("loginName",loginName);
            model.addAttribute("password",password);
            return "/admin/login";
        }
    }

    /**
     * 退出系统
     * @param session
     *          Session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/admin/logout")
    public String logout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();
        return "/admin/login";
    }
}
