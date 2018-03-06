package me.rainking.booking.enums;

import lombok.Getter;

/**
 * 预约状态枚举状态,0无意义1待（服务者）审核2待赴约3待(客户)确认4已取消5已赴约
 * @author Rain
 */
@Getter
public enum BookStatusEnum {

    /**
     * 无意义
     */
    NOMEANING(0, "无意义"),
    /**
     * 客户已经提交预约申请，等待服务者审核确认
     */
    WAIT_FOR_CHECK(1, "待审核"),
    /**
     * 服务者已审核确认，等待客户赴约
     */
    WAIT_FOR_USE(2, "待赴约"),
    /**
     * 服务者修改了预约申请，等待客户确认
     */
    WAIT_FOR_CONFIRM(3, "待确认"),
    /**
     * 客户取消待审核、待确认的预约
     */
    CANCELED(4, "已取消"),
    /**
     * 客户已经赴约
     */
    USED(5, "已赴约")
    ;

    private Integer code;
    private String message;

    BookStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
