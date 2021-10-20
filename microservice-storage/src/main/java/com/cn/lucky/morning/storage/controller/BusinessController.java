package com.cn.lucky.morning.storage.controller;


import com.cn.lucky.morning.storage.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lucky_morning
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 采购
     *
     * @param userId        采购用户
     * @param commodityCode 商品Code
     * @param orderCount    商品数量
     * @return 采购结果
     */
    @GetMapping("/purchase")
    public String purchase(String userId, String commodityCode, int orderCount) {
        try {
            businessService.purchase(userId, commodityCode, orderCount);
            return "操作成功";
        } catch (Exception e) {
            return "操作失败：" + e.getMessage();
        }
    }
}
