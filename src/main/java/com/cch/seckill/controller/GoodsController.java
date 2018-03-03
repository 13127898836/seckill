package com.cch.seckill.controller;

import com.cch.seckill.domain.MiaoshaUser;
import com.cch.seckill.redis.RedisService;
import com.cch.seckill.service.MiaoshaUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by 459105408@qq.com
 * 2018-03-03 22:57.
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_list")
    public String list(Model model,MiaoshaUser user ) {
        model.addAttribute("user",user);
        return "goods_list";
    }

}
