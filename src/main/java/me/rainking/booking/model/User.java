package me.rainking.booking.model;

import lombok.Data;
import me.rainking.booking.enums.GenderEnum;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 0其他1男2女，默认未知
     */
    private Integer gender = GenderEnum.UNKNOWN.getCode();

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 住址
     */
    private String address;

    /**
     * 简介
     */
    private String intro;

    /**
     * 头像文件路径
     */
    private String photoIcon;

    /**
     * 密码重置码
     */
    private String pwResetCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", openid='" + openid + '\'' +
                ", realName='" + realName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", intro='" + intro + '\'' +
                ", photoIcon='" + photoIcon + '\'' +
                ", pwResetCode='" + pwResetCode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
