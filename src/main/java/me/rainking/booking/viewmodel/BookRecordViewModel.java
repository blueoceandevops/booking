package me.rainking.booking.viewmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import me.rainking.booking.serializer.Date2StringSerializer;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @Description: 用于FullCalendar的预约记录模型，需转为JSON，缺省字段不传输
 * @Author: Rain
 * @Date: 2017/12/4 11:01
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookRecordViewModel {

    /**
     * 序号
     */
    private String id;

    /**
     * 显示的标题
     */
    private String title;

    /**
     * 开始时间
     */
    @JsonSerialize(using = Date2StringSerializer.class)
    private Date start;

    /**
     * 结束时间
     */
    @JsonSerialize(using = Date2StringSerializer.class)
    private Date end;

    /**
     * 点击执行的url（支持js）
     */
    private String url;
}
