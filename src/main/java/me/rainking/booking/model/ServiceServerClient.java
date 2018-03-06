package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 服务_服务者_客户
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class ServiceServerClient {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer serviceServerId;

    /**
     * 客户id
     */
    private Integer clientId;

    /**
     * 客户用户名
     */
    private String clientName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public ServiceServerClient() {
    }

    public ServiceServerClient(Integer serviceServerId, Integer clientId) {
        this.serviceServerId = serviceServerId;
        this.clientId = clientId;
    }
}
