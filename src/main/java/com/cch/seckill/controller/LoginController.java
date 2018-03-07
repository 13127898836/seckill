package com.cch.seckill.controller;

import com.cch.seckill.redis.RedisService;
import com.cch.seckill.result.Result;
import com.cch.seckill.service.MiaoshaUserService;
import com.cch.seckill.vo.LoginVo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 登录
 * Created by 459105408@qq.com
 * 2018-03-03 21:37.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        //登录
        String token = userService.login(response, loginVo);
        return Result.success(token);
    }
}
