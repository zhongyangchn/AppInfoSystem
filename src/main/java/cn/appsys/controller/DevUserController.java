package cn.appsys.controller;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value ="/dev")
public class DevUserController {
    @Resource
    private DevUserService service;
    private Logger logger= Logger.getLogger(DevUserController.class);

    @RequestMapping(value="/login")
    public String login(){
        logger.debug("LoginController welcome AppinfoSystem develper=====");
        return "devlogin";
    }
    @RequestMapping(value="/dologin", method= RequestMethod.POST)
    public String dologin(@RequestParam String devCode, @RequestParam String devPassword,
                          HttpSession session, HttpServletRequest request) throws Exception {
        logger.debug("dologin=================");
        DevUser user = null;
        //调用Service方法，进行用户匹配
        user = service.login(devCode,devPassword);
        if(null!=user) {
            //成功 放入session 会话当中
            session.setAttribute(Constants.DEV_USER_SESSION, user);
            //页面跳转（main.jsp）
            return "redirect:/dev/developer/main";
        }else{
            //失败 保留在devlogin.jsp，带出一些提示信息
            request.setAttribute("error","用户名或密码不正确");
            return "devlogin";
        }
    }
    @RequestMapping(value="/developer/main")
    public String main(HttpSession session){
        if(session.getAttribute(Constants.DEV_USER_SESSION) == null){
            return "redirect:/dev/login";
        }
        return "developer/main";
    }
    @RequestMapping(value="/logout")
    public String  logout(HttpSession session){
        //清除session
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "devlogin";
    }


}
