package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付（退款）记录
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class Payment {

    @Id
    private String id;

    /**
     * 客户id
     */
    private Integer clientId;

    /**
     * 客户用户名
     */
    private String clientName;

    /**
     * 服务id
     */
    private Integer serviceId;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 收银员id
     */
    private Integer cashierId;

    /**
     * 收银员用户名
     */
    private String cashierName;

    /**
     * 说明
     */
    private String intro;

    /**
     * 总价
     */
    private BigDecimal price;

    /**
     * 状态,0无意义1待支付2已支付3待退款4已退款 PaymentStatusEnum
     */
    private Integer status;

    /**
     * 充值的服务次数
     */
    private Float serviceNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
