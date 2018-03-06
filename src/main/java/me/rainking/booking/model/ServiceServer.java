package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 服务_服务者
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class ServiceServer {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 服务id
     */
    private Integer serviceId;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务者用户id
     */
    private Integer serverId;

    /**
     * 服务者用户名
     */
    private String serverName;

    /**
     * 状态，0未启用1启用(StatusEnum)
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
