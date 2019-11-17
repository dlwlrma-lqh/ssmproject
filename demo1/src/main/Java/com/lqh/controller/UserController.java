package com.lqh.controller;

import com.lqh.service.UserService;
import com.lqh.pojo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/portal/user/")
public class UserController {
   @Autowired
    UserService userService;
    @RequestMapping("register.do")
    public ModelAndView register(String uname, String psd) {
        ModelAndView mav = new ModelAndView();
        // 使用业务层方法
        int register = userService.register(uname, psd);
        if (register <= 0) {
            mav.addObject("msg", "用户注册失败！请重新注册");
            mav.setViewName("register");
        } else {
            mav.addObject("msg", "用户注册成功，请登录！");
            mav.setViewName("index");
        }
        return mav;
    }

    //用户登录

    @RequestMapping("login.do")
    public ModelAndView login(String uname, String psd, HttpSession session){
        ModelAndView mav = new ModelAndView();
        Users users = userService.login(uname, psd);
        if(users == null){
            mav.addObject("msg","登录失败，请重新登录！");
            mav.setViewName("index");
            return mav;
        }
        //如果用户登录成功，就保存用户的信息
        session.setAttribute("user",users);
        mav.setViewName("home");
        return mav;
    }

    //用户存钱
    @RequestMapping("savemoney.do")
    public ModelAndView setMoney(int money,HttpSession session){
        ModelAndView mav = new ModelAndView();

        //此处可以做用户是否登录的验证
        Users u = (Users) session.getAttribute("user");

        //执行业务层操作
        int i = userService.setMoney(u.getUname(), money);

        //返回前端，跳转页面
        mav.setViewName("home");
        if(i <= 0){
            mav.addObject("msg","存款失败！请查询问题！");
            return mav;
        }
        mav.addObject("msg","存款成功！");
        u.setMoney(u.getMoney()+money);
        session.setAttribute("user",u);
        return mav;
    }

    //用户转账
    @RequestMapping("atob.do")
    public ModelAndView aToB(String bname,int money,HttpSession session){
        ModelAndView mav = new ModelAndView();

        //此处可以做用户是否登录的验证
        Users u = (Users) session.getAttribute("user");

        //执行业务层操作
        int i = userService.aToB(u.getUname(),bname,money);

        //返回前端，跳转页面
        mav.setViewName("home");
        if(i <= 1){
            mav.addObject("msg","转账失败！请查询问题！");
            return mav;
        }
        mav.addObject("msg","转账成功！");
        u.setMoney(u.getMoney()-money);
        session.setAttribute("user",u);
        return mav;
    }

    //用户取钱
    @RequestMapping("getmoney.do")
    public ModelAndView getMoney(int money,HttpSession session){
        ModelAndView mav = new ModelAndView();

        //此处可以做用户是否登录的验证
        Users u = (Users) session.getAttribute("user");

        //执行业务层操作
        int i = userService.getMoney(u.getUname(), money);

        //返回前端，跳转页面
        mav.setViewName("home");
        if(i <= 0){
            mav.addObject("msg","取款失败！请查询问题！");
            return mav;
        }
        mav.addObject("msg","取款成功！");
        u.setMoney(u.getMoney()-money);
        session.setAttribute("user",u);
        return mav;
    }

    //用户退出
    @RequestMapping("exit.do")
    public ModelAndView exit(HttpSession session) {
        session.invalidate();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    //修改信息
    @RequestMapping("modify.do")
    public ModelAndView modify( String psd,int age,HttpSession session) {

        Users u = (Users) session.getAttribute("user");

        ModelAndView mav = new ModelAndView();
        // 使用业务层方法
        String uname=u.getUname();
        int modify = userService.modify(uname, psd,age);
        System.out.println(modify);
        if (modify <= 0) {
            mav.addObject("msg", "用户信息修改失败！请重新修改");
            mav.setViewName("other");
        } else {
            mav.addObject("msg", "用户信息修改成功，请重新登录！");
            mav.setViewName("index");
        }
        return mav;
    }

}

