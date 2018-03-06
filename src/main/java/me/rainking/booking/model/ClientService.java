package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 客户_服务
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class ClientService {

    @Id
    @GeneratedValue
    private Integer id;

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
     * 剩余服务次数
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
