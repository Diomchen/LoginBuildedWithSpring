package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request ,LoginCommand loginCommand){
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUsername(),loginCommand.getPassword());

        if(!isValidUser){
            return new ModelAndView("login","error","用户名或密码错误");
        }
        else{
            User user = userService.findUserByUser(loginCommand.getUsername());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.updateLoginInfo(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }

    }

    @Autowired(required = false)
    public void setUserService(UserService userService){
        this.userService = userService;
    }


}
