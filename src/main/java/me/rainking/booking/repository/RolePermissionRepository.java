package me.rainking.booking.repository;

import me.rainking.booking.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Rain
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

    /**
     * 根据角色和权限查找
     *
     * @param roleId       角色
     * @param permissionId 权限
     * @return 角色权限信息
     */
    List<RolePermission> findByRoleIdAndPermissionId(Integer roleId, Integer permissionId);

    /**
     * 根据角色查询
     *
     * @param roleId 角色
     * @return 角色权限信息
     */
    List<RolePermission> findByRoleId(Integer roleId);

    /**
     * 根据权限查询
     *
     * @param permissionId 权限
     * @return 角色权限信息
     */
    List<RolePermission> findByPermissionId(Integer permissionId);

}
