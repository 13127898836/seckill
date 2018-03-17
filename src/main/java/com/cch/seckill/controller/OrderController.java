package com.cch.seckill.controller;

import com.cch.seckill.domain.MiaoshaUser;
import com.cch.seckill.domain.OrderInfo;
import com.cch.seckill.redis.RedisService;
import com.cch.seckill.result.CodeMsg;
import com.cch.seckill.result.Result;
import com.cch.seckill.service.GoodsService;
import com.cch.seckill.service.MiaoshaUserService;
import com.cch.seckill.service.OrderService;
import com.cch.seckill.vo.GoodsVo;
import com.cch.seckill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 459105408@qq.com
 * 2018-03-17 21:44.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(Model model, MiaoshaUser user,
                                      @RequestParam("orderId") long orderId) {
        if(user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        OrderInfo order = orderService.getOrderById(orderId);
        if(order == null) {
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        long goodsId = order.getGoodsId();
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setGoods(goods);
        return Result.success(vo);
    }
}
