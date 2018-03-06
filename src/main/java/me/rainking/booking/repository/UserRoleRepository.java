package me.rainking.booking.repository;

import me.rainking.booking.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Rain
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    /**
     * 查询某类角色的全部用户角色信息
     *
     * @param roleId 角色id
     * @return 用户角色信息
     */
    List<UserRole> findByRoleId(Integer roleId);

    /**
     * 查询某用户的全部角色信息
     *
     * @param userId 用户id
     * @return 用户角色信息
     */
    List<UserRole> findByUserId(Integer userId);

    /**
     * 查询某条用户角色信息（确定是否存在）
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 用户角色信息
     */
    List<UserRole> findByUserIdAndRoleId(Integer userId, Integer roleId);

}
