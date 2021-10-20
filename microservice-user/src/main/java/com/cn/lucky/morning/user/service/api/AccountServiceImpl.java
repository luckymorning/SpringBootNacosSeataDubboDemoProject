package com.cn.lucky.morning.user.service.api;

import com.cn.lucky.morning.user.api.AccountService;
import com.cn.lucky.morning.user.entity.TblAccount;
import com.cn.lucky.morning.user.service.ITblAccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private ITblAccountService tblAccountService;

    @Override
    public void debit(String userId, int money) {
        TblAccount account = tblAccountService.getById(userId);
        if (account == null) {
            throw new RuntimeException("用户不存在");
        }
        account.setMoney(account.getMoney() - money);
        if (account.getMoney() < 0) {
            throw new RuntimeException("用户余额不足");
        }
        tblAccountService.updateById(account);
    }
}
