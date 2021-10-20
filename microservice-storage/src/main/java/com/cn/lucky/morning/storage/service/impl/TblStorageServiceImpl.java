package com.cn.lucky.morning.storage.service.impl;

import com.cn.lucky.morning.storage.entity.TblStorage;
import com.cn.lucky.morning.storage.mapper.TblStorageMapper;
import com.cn.lucky.morning.storage.service.ITblStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lucky_morning
 * @since 2021-10-20
 */
@Service
public class TblStorageServiceImpl extends ServiceImpl<TblStorageMapper, TblStorage> implements ITblStorageService {

    @Override
    public void deduct(String commodityCode, int count) {
        TblStorage storage = this.lambdaQuery().eq(TblStorage::getCommodityCode, commodityCode).last("limit 1").one();
        if (storage == null) {
            throw new RuntimeException("商品不存在");
        }
        if (storage.getCount() < count) {
            throw new RuntimeException("商品库存不足");
        }
        storage.setCount(storage.getCount() - count);
        this.updateById(storage);
    }
}
