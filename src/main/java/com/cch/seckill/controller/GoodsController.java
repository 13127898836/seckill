package com.cch.seckill.controller;

import com.cch.seckill.domain.MiaoshaUser;
import com.cch.seckill.redis.RedisService;
import com.cch.seckill.service.GoodsService;
import com.cch.seckill.service.MiaoshaUserService;
import com.cch.seckill.vo.GoodsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


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
    GoodsService goodsService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_list")
    public String list(Model model,HttpServletRequest request ,MiaoshaUser user) {
        model.addAttribute("user",user);
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList",goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String detail(Model model, HttpServletRequest request , MiaoshaUser user,
                         @PathVariable("goodsId") long goodsId) {
        //snowflake
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods",goods);

        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();
        int miaoshaStatus = 0;
        int remainSeconds =0;
        if(now < startAt){//秒杀还没开始，倒计时
            miaoshaStatus =0;
            remainSeconds = (int)(startAt-now)/1000;
        }else if(now > endAt){//秒杀已经结束
            miaoshaStatus =2;
            remainSeconds=-1;
        }else{//秒杀进行中
            miaoshaStatus =1;
            remainSeconds=0;
        }
        model.addAttribute("miaoshaStatus",miaoshaStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goods_detail";
    }
}
