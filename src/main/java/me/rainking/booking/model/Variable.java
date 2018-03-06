package me.rainking.booking.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

/**
 * 系统参数
 * @author Rain
 */
@Entity
@DynamicUpdate
@Data
public class Variable {

    @Id
    private Integer id;

    /**
     * 早上开始时间
     */
    private Time morningStart;

    /**
     * 晚上结束时间
     */
    private Time eveningEnd;

    /**
     * 一个预约时间的分钟数
     */
    private Integer bookDuration;

    /**
     * 休息日，第一位为星期一，1工作0休息，如1111100
     */
    private String restDays;

    /**
     * 服务者角色名称，如教师、医生
     */
    private String serverRoleName;

    /**
     * 客户角色名称，如学生、患者
     */
    private String clientRoleName;

    /**
     * 服务分类名称，如课程、科室
     */
    private String serviceName;

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
        return "Variable{" +
                "id=" + id +
                ", morningStart=" + morningStart +
                ", eveningEnd=" + eveningEnd +
                ", bookDuration=" + bookDuration +
                ", restDays='" + restDays + '\'' +
                ", serverRoleName='" + serverRoleName + '\'' +
                ", clientRoleName='" + clientRoleName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
