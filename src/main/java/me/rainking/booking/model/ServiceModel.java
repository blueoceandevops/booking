package me.rainking.booking.model;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 服务项目
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class ServiceModel {


    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 简介
     */
    private String intro;

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

    public ServiceModel() {
    }

    public ServiceModel(String name, String intro) {
        this.name = name;
        this.intro = intro;
    }
}
