package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 角色信息
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 角色名称
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

    /**
     * 默认构造函数
     */
    public Role() {

    }

    /**
     * 使用角色名称和角色简介构造角色
     *
     * @param name  角色名称
     * @param intro 角色简介
     */
    public Role(String name, String intro) {
        this.name = name;
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
