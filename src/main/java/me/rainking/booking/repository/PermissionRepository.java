package me.rainking.booking.repository;

import me.rainking.booking.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Rain
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    /**
     * 统计权限码的使用数量（理论可能数量为0或1）
     *
     * @param code 权限码
     * @return 数量
     */
    long countByCode(String code);

    /**
     * 根据列表查询权限信息
     *
     * @param idList id列表
     * @return 权限信息
     */
    List<Permission> findByIdIn(List<Integer> idList);

}
