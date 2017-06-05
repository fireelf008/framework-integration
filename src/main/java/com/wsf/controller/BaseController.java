package com.wsf.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YSD on 2017/5/9.
 */
public class BaseController {

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }
}
