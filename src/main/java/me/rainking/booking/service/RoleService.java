package me.rainking.booking.service;

import me.rainking.booking.model.Role;

import java.util.List;

/**
 * @author Rain
 */
public interface RoleService {

    /**
     * 添加（修改）角色（更新时，或添加的角色名不存在时允许入库）
     *
     * @param role 角色信息
     * @return 更新后或新增的角色信息
     */
    Role save(Role role);

    /**
     * 查找全部角色信息
     *
     * @return 全部角色信息
     */
    List<Role> findAll();

    /**
     * 根据id查找角色信息
     *
     * @param id 角色id
     * @return 角色信息
     */
    Role findOne(Integer id);

    /**
     * 查找id列表中的角色信息
     *
     * @param roleIdList
     * @return
     */
    List<Role> findByIdIn(List<Integer> roleIdList);

    /**
     * 查找用户的全部角色
     *
     * @param userId
     * @return 用户的全部角色信息
     */
    List<Role> findByUser(Integer userId);

    /**
     * 根据角色名称查找角色信息，逻辑唯一
     *
     * @param name 角色名称
     * @return 唯一的角色信息
     */
    Role findByName(String name);

    /**
     * 删除角色（如果存在该角色用户则不允许删除，必须先取消关联）
     *
     * @param id 角色id
     */
    void delete(Integer id);


}
