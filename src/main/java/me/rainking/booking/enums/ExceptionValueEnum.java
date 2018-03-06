package me.rainking.booking.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: Rain
 * @Date: 2017/12/5 15:24
 */
@Getter
public enum ExceptionValueEnum {

    /**
     * 值不存在时，使用该枚举值
     */
    NOT_FOUND(0,"该值不存在")
    ;


    private Integer code;
    private String message;

    ExceptionValueEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
