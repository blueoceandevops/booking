package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 预约记录
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class BookRecord {

    @Id
    private String id;


    /**
     * 服务_服务者_客户id
     */
    private Integer serviceServerClientId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 服务次数(按时间计算)
     */
    private BigDecimal serviceNum;

    /**
     * 预约类型,0不重复1每天2每周3每月
     */
    private Integer bookType;

    /**
     * 重复id
     */
    private Integer repeatId;

    /**
     * 创建人id
     */
    private Integer createrId;

    /**
     * 创建人姓名
     */
    private String createrName;

    /**
     * 修改人id
     */
    private Integer modifierId;

    /**
     * 修改人姓名
     */
    private String modifierName;

    /**
     * 说明
     */
    private String intro;

    /**
     * 状态,0无意义1待审核2待赴约3待确认4已取消5已赴约
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
