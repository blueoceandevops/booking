package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 权限信息
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class Permission {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 权限码
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 简介
     */
    private String intro;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Permission() {
    }

    public Permission(String code, String name, String intro) {
        this.code = code;
        this.name = name;
        this.intro = intro;
    }
}
