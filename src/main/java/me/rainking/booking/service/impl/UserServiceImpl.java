package me.rainking.booking.service.impl;

import me.rainking.booking.enums.ExceptionValueEnum;
import me.rainking.booking.model.User;
import me.rainking.booking.model.UserRole;
import me.rainking.booking.repository.UserRepository;
import me.rainking.booking.service.UserRoleService;
import me.rainking.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rain
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleService userRoleService;


    @Override
    public User save(User user) {

        List<User> userList = userRepository.findByName(user.getName());
        boolean isNotNewUser = (user.getId() != null);
        boolean isNotExist = (userList == null || userList.size() == 0);

        if (isNotNewUser || isNotExist) {
            user = userRepository.save(user);
        } else {
            user = null;
        }

        return user;
    }

    @Override
    public User save(User user, Integer roleId) {
        user = this.save(user);
        userRoleService.save(user.getId(), roleId);
        return user;
    }

    @Override
    public User save(User user, List<Integer> roleIdList) {
        user = this.save(user);
        userRoleService.save(user.getId(), roleIdList);
        return user;
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findByIdIn(List<Integer> userIdList, Pageable pageable) {
        return userRepository.findByIdIn(userIdList, pageable);
    }

    @Override
    public List<User> findByIdIn(List<Integer> userIdList) {
        return userRepository.findByIdIn(userIdList);
    }

    @Override
    public void delete(Integer id) {

        List<UserRole> userRoleList = userRoleService.findByUser(id);

        boolean isOnUse = (userRoleList != null && userRoleList.size() != 0);
        boolean isNotExist = (userRepository.findOne(id) == null);

        if (isOnUse || isNotExist) {
            ;//有关联的角色，或不存在，不能删除
        } else {
            userRepository.delete(id);
        }

    }

    @Override
    public List<User> listUserByRole(Integer roleId) {
        return this.findByIdIn(
                userRoleService.findByRole(roleId).stream()
                        .map(e -> e.getUserId())
                        .collect(Collectors.toList())
        );
    }

    @Override
    public String getNameById(Integer id) {

        String name;

        User user = this.findOne(id);
        if (user != null) {
            name = user.getName();
        } else {
            name = null;
        }

        return name;
    }
}
