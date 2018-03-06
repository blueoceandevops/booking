package me.rainking.booking.repository;

import me.rainking.booking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Rain
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * 使用角色名称查询角色信息
     *
     * @param name 角色名称
     * @return 角色信息
     */
    List<Role> findByName(String name);

    /**
     * 使用角色id列表查询角色信息列表
     *
     * @param idList 角色id列表
     * @return 角色信息列表
     */
    List<Role> findByIdIn(List<Integer> idList);

}
