package com.cn.lucky.morning.order.service.api;

import com.cn.lucky.morning.order.api.OrderService;
import com.cn.lucky.morning.order.entity.TblOrder;
import com.cn.lucky.morning.order.service.ITblOrderService;
import com.cn.lucky.morning.user.api.AccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lucky_morning
 */
@Service
@DubboService
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ITblOrderService tblOrderService;
    @DubboReference
    private AccountService accountService;

    @Override
    public boolean create(String userId, String commodityCode, int orderCount) {
        int orderMoney = calculate(commodityCode, orderCount);

        accountService.debit(userId, orderMoney);

        TblOrder order = new TblOrder();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        return tblOrderService.save(order);
    }

    /**
     * 计算价格
     *
     * @param commodityCode 商品Code
     * @param orderCount    商品数量
     * @return 购买价格
     */
    private int calculate(String commodityCode, int orderCount) {
        return 100 * orderCount;
    }
}
