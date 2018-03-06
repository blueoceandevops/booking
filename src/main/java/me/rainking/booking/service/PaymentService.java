package me.rainking.booking.service;


import me.rainking.booking.model.Payment;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户的支付信息
 *
 * @author Rain
 */
public interface PaymentService {

    /**
     * 查找用户的全部支付记录
     *
     * @param clientId 客户
     * @return 支付记录
     */
    List<Payment> listByClient(Integer clientId);

    /**
     * 查找服务的全部支付记录
     *
     * @param serviceId 服务
     * @return 支付记录
     */
    List<Payment> listByService(Integer serviceId);

    /**
     * 查找收银员的全部收账记录
     *
     * @param cashierId 收银员
     * @return 支付记录
     */
    List<Payment> listByCashier(Integer cashierId);

    /**
     * 充值，增加服务次数
     *
     * @param clientId   客户
     * @param serviceId  服务
     * @param cashierId  收银员
     * @param intro      备注
     * @param price      总价（退款）
     * @param serviceNum 服务次数
     * @return
     */
    Payment charge(Integer clientId,
                   Integer serviceId,
                   Integer cashierId,
                   String intro,
                   BigDecimal price,
                   Float serviceNum);

    /**
     * 退款（根据余量退款）
     *
     * @param clientId  客户
     * @param serviceId 服务
     * @param cashierId 收银员
     * @param intro     备注
     * @param price     总价（退款）
     * @return
     */
    Payment refund(Integer clientId,
                   Integer serviceId,
                   Integer cashierId,
                   String intro,
                   BigDecimal price);
}
