package me.rainking.booking.service;


import me.rainking.booking.model.Permission;

import java.util.List;

/**
 * 权限服务
 *
 * @author Rain
 */
public interface PermissionService {

    /**
     * 检查权限码是否已被使用
     *
     * @param code 权限码
     * @return 检查结果
     */
    boolean isCodeOnUse(String code);

    /**
     * 新建或更新权限信息
     *
     * @param permission 权限信息
     * @return 权限信息
     */
    Permission save(Permission permission);

    /**
     * 新建权限
     *
     * @param code  权限码
     * @param name  权限名称
     * @param intro 介绍
     * @return 权限信息，权限码已经存在时返回null
     */
    Permission save(String code, String name, String intro);

    /**
     * 删除权限，删除前检查是否存在
     *
     * @param id 权限id
     */
    void delete(Integer id);

    /**
     * 查找id列表中的全部权限信息
     *
     * @param permissionIdList 权限id列表
     * @return 权限信息列表
     */
    List<Permission> findByIdIn(List<Integer> permissionIdList);

    /**
     * 根据id获取权限信息
     *
     * @param id
     * @return 权限信息
     */
    Permission getOne(Integer id);


}
