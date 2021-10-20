package com.cn.lucky.morning.storage.service;

import com.cn.lucky.morning.storage.entity.TblStorage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lucky_morning
 * @since 2021-10-20
 */
public interface ITblStorageService extends IService<TblStorage> {
    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);
}
