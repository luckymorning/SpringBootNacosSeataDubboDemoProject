package com.cn.lucky.morning.order.api;

/**
 * @author lucky_morning
 */
public interface OrderService {
    /**
     * 创建订单
     * @return
     */
    boolean create(String userId, String commodityCode, int orderCount);
}
