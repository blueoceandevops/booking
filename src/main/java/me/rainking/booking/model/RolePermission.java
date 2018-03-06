package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 角色权限关联信息
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class RolePermission {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 角色
     */
    private Integer roleId;

    /**
     * 权限
     */
    private Integer permissionId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    public RolePermission(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
}
