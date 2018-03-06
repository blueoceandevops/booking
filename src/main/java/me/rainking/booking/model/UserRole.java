package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户角色关联信息
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class UserRole {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 用户
     */
    private Integer userId;

    /**
     * 角色
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public UserRole() {

    }

    public UserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
