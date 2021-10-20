package com.cn.lucky.morning.storage.service.impl;

import com.cn.lucky.morning.order.api.OrderService;
import com.cn.lucky.morning.storage.service.BusinessService;
import com.cn.lucky.morning.storage.service.ITblStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lucky_morning
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private ITblStorageService storageService;
    @DubboReference
    private OrderService orderService;

    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {

        // 减库存
        storageService.deduct(commodityCode, orderCount);

        // 新增订单
        orderService.create(userId, commodityCode, orderCount);
    }
}
