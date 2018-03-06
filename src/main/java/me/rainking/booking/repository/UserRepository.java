package me.rainking.booking.repository;

import me.rainking.booking.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Rain
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 根据用户id列表查询用户列表，并分页
     *
     * @param userIdList 用户id列表
     * @param pageable   分页信息
     * @return 分页的用户信息
     */
    Page<User> findByIdIn(List<Integer> userIdList, Pageable pageable);

    /**
     * 根据用户id列表查询用户列表
     *
     * @param userIdList 用户id列表
     * @return 用户信息列表
     */
    List<User> findByIdIn(List<Integer> userIdList);

    /**
     * 根据用户名查询用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    List<User> findByName(String name);

}
