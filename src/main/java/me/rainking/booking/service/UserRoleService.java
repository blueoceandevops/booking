package me.rainking.booking.service;

import me.rainking.booking.model.UserRole;

import java.util.List;


/**
 * @author Rain
 */
public interface UserRoleService {

    /**
     * 为用户添加角色，添加前检查是否已存在
     *
     * @param userId 用户
     * @param roleId 角色
     * @return
     */
    UserRole save(Integer userId, Integer roleId);

    /**
     * 为用户添加多个角色，添加前检查是否已存在
     *
     * @param userId     用户
     * @param roleIdList 角色列表
     * @return
     */
    List<UserRole> save(Integer userId, List<Integer> roleIdList);

    /**
     * 根据用户id和角色id查询记录是否存在
     *
     * @param userId 用户
     * @param roleId 角色
     * @return 记录是否存在
     */
    Boolean exist(Integer userId, Integer roleId);

    /**
     * 查找用户的全部角色
     *
     * @param userId 用户id
     * @return 角色用户信息
     */
    List<UserRole> findByUser(Integer userId);

    /**
     * 查找角色的全部用户
     *
     * @param roleId 角色id
     * @return 角色用户信息
     */
    List<UserRole> findByRole(Integer roleId);

}
