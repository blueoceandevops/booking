package me.rainking.booking.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**返回的结果
 * @author Rain
 * @param <T>
 */
@Data
public class ResultViewModel<T> {
    /**
     * 状态码
     */
    @JsonProperty("jsonview")
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 具体数据
     */
    private T data;
}
