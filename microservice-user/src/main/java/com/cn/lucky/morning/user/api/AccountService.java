package com.cn.lucky.morning.user.api;

/**
 * @author lucky_morning
 */
public interface AccountService {

    /**
     * 从用户账户中借出
     *
     * @param userId 用户ID
     * @param money  金额
     */
    void debit(String userId, int money);
}
