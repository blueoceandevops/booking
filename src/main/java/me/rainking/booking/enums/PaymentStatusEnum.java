package me.rainking.booking.enums;

import lombok.Getter;

/**
 * 支付记录状态枚举
 *
 * @author Rain
 */
@Getter
public enum PaymentStatusEnum {

    /**
     * 初始值，不使用
     */
    NO_MEANING(0, "无意义"),
    /**
     * 等待支付
     */
    WAIT_FOR_PAY(1, "待支付"),
    /**
     * 已经支付
     */
    PAYED(2, "已支付"),
    /**
     * 申请退款，等待退款
     */
    WAIT_FOR_REFUND(3, "待退款"),
    /**
     * 已经退款
     */
    REFUNDED(4, "已退款"),
    /**
     * 赠送的服务，费用为0
     */
    GIFT(5, "赠送");

    private Integer code;
    private String message;

    PaymentStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
