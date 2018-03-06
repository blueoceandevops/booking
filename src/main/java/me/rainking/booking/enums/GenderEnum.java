package me.rainking.booking.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 性别枚举
 * @author Rain
 */
@Getter
public enum GenderEnum {
    /**
     * 未知，未选择
     */
    UNKNOWN(0, "未知"),
    /**
     * 男
     */
    MAN(1, "男"),
    /**
     * 女
     */
    WOMAN(2, "女"),
    /**
     * 其他，已选择
     */
    OTHER(3, "其他");

    private Integer code;
    private String message;

    GenderEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
