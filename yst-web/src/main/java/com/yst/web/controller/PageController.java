package com.yst.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName Page1Controller
 * @Author hang
 * @DATE 2018/10/18 11:13
 * @Description TODO
 **/
@RestController
@RequestMapping("page")
public class PageController {

    @RequestMapping("weixin")
    public ModelAndView weixin(){
        return new ModelAndView("weixin");
    }

    @RequestMapping("list")
    public ModelAndView listPage(){
        return new ModelAndView("list");
    }

    @RequestMapping("test")
    public ModelAndView test(){
        return new ModelAndView("test");
    }
}