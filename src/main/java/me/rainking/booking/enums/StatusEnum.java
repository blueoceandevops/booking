package me.rainking.booking.enums;

import lombok.Getter;

/**
 * 通用状态枚举
 * @author Rain
 */
@Getter
public enum StatusEnum {

    /**
     * 未启用
     */
    OFF(0, "未启用"),
    /**
     * 已启用
     */
    ON(1, "已启用");

    private Integer code;
    private String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
