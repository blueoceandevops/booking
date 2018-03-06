package me.rainking.booking.service;


import me.rainking.booking.model.RolePermission;

import java.util.List;

/**
 * 角色——权限关联服务
 *
 * @author Rain
 */
public interface RolePermissionService {

    /**
     * 为角色添加权限，不允许重复添加
     *
     * @param roleId       角色
     * @param permissionId 权限
     * @return 角色权限信息
     */
    RolePermission save(Integer roleId, Integer permissionId);

    /**
     * 删除某个权限授权
     *
     * @param id 角色权限id
     */
    void delete(Integer id);

    /**
     * 删除某角色的权限授权
     *
     * @param roleId       角色
     * @param permissionId 权限
     */
    void delete(Integer roleId, Integer permissionId);

    /**
     * 根据角色、授权查找
     *
     * @param roleId 角色
     * @param permissionId 权限
     * @return 角色权限信息
     */
    RolePermission getOne(Integer roleId, Integer permissionId);

    /**
     * 查询角色的全部权限
     *
     * @param roleId 角色
     * @return 角色权限列表
     */
    List<RolePermission> listByRole(Integer roleId);

    /**
     * 查询具有某项权限的全部角色
     *
     * @param permissionId 权限
     * @return 角色权限列表
     */
    List<RolePermission> listByPermission(Integer permissionId);

    /**
     * 检查某角色是否具有某权限
     *
     * @param roleId       角色
     * @param permissionId 权限
     * @return 检查结果
     */
    boolean hasPermission(Integer roleId, Integer permissionId);


}
