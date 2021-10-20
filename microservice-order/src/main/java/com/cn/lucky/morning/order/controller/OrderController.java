package com.cn.lucky.morning.order.controller;

import com.cn.lucky.morning.order.api.OrderService;
import com.cn.lucky.morning.order.entity.TblOrder;
import com.cn.lucky.morning.user.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucky_morning
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public String create(String userId, String commodityCode, int orderCount) {
        try {
            return "订单创建结果：" + orderService.create(userId, commodityCode, orderCount);
        }catch (Exception e){
            return "订单创建失败：" + e.getMessage();
        }
    }
}
