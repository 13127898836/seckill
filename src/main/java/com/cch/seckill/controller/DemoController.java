package com.cch.seckill.controller;

import com.cch.seckill.domain.User;
import com.cch.seckill.rabbitmq.MQSender;
import com.cch.seckill.redis.RedisService;
import com.cch.seckill.redis.UserKey;
import com.cch.seckill.result.CodeMsg;
import com.cch.seckill.result.Result;
import com.cch.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * demo接口
 * Created by 459105408@qq.com
 * 2018-03-03 0:10.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    MQSender mqSender;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "hello world";
    }

    @RequestMapping("/mq")
    @ResponseBody
    public Result<String> mq() {
        mqSender.send("hello,cch");
        return Result.success("hello world");
    }

    @RequestMapping("/mq/topic")
    @ResponseBody
    public Result<String> topic() {
        mqSender.sendTopic("hello,imooc");
        return Result.success("Hello，world");
    }

    @RequestMapping("/mq/fanout")
    @ResponseBody
    public Result<String> fanout() {
        mqSender.sendFanout("hello,imooc");
        return Result.success("Hello，world");
    }

    @RequestMapping("/mq/header")
    @ResponseBody
    public Result<String> header() {
        mqSender.sendHeader("hello,imooc");
        return Result.success("Hello，world");
    }


    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello world");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "cch");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> tx() {
        userService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User user = redisService.get(UserKey.getById, "" + 1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, "" + 1, user);//UserKey:id1
        return Result.success(true);
    }
}
