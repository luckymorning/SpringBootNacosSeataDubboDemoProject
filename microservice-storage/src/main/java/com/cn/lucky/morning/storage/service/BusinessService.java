package com.cn.lucky.morning.storage.service;

/**
 * @author lucky_morning
 */
public interface BusinessService {
    /**
     * 采购
     */
    void purchase(String userId, String commodityCode, int orderCount);
}
