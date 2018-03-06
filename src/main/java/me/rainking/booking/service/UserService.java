package me.rainking.booking.service;

import me.rainking.booking.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Rain
 */
public interface UserService {

    /**
     * 保存用户信息（更新或新增，不允许添加相同用户名用户）
     *
     * @param user 用户信息
     * @return 保存的用户信息
     */
    User save(User user);

    /**
     * 保存用户信息，同时保存用户的角色信息
     *
     * @param user   用户信息
     * @param roleId 角色id
     * @return 保存的用户信息
     */
    User save(User user, Integer roleId);

    /**
     * 添加用户，同时设置角色
     *
     * @param user       用户信息
     * @param roleIdList 角色id列表
     * @return 用户信息
     */
    User save(User user, List<Integer> roleIdList);

    /**
     * 根据id查找用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User findOne(Integer id);

    /**
     * 根据id列表查找用户(分页)
     *
     * @param userIdList 用户id列表
     * @param pageable   分页信息
     * @return 用户信息列表
     */
    Page<User> findByIdIn(List<Integer> userIdList, Pageable pageable);

    /**
     * 根据id列表查找用户
     *
     * @param userIdList 用户id列表
     * @return 用户信息列表
     */
    List<User> findByIdIn(List<Integer> userIdList);

    /**
     * 删除用户（用户必须存在，且无角色信息）
     *
     * @param id
     */
    void delete(Integer id);


    /**
     * 根据角色id获取用户
     *
     * @param roleId
     * @return
     */
    List<User> listUserByRole(Integer roleId);

    /**
     * 根据id获取用户名
     *
     * @param id
     * @return
     */
    String getNameById(Integer id);


}
