package me.rainking.booking.enums;

import lombok.Getter;

/**
 * 预约类型枚举
 * @author Rain
 */
@Getter
public enum BookTypeEnum {

    /**
     * 单次，非循环
     */
    ONCE(0, "单次"),
    /**
     * 每天
     */
    DAYS(1, "每天"),
    /**
     * 每周
     */
    WEEKLY(2, "每周"),
    /**
     * 每月
     */
    MONTHLY(3, "每月");

    private Integer code;
    private String message;

    BookTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
