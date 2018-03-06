package me.rainking.booking.service.impl;

import me.rainking.booking.model.UserRole;
import me.rainking.booking.repository.UserRoleRepository;
import me.rainking.booking.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rain
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole save(Integer userId, Integer roleId) {

        UserRole userRole;
        if (this.exist(userId, roleId)) {
            userRole = null;
        } else {
            userRole = userRoleRepository.save(new UserRole(userId, roleId));
        }
        return userRole;
    }

    @Override
    public List<UserRole> save(Integer userId, List<Integer> roleIdList) {
        return roleIdList.stream()
                .map(e -> this.save(userId, e))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean exist(Integer userId, Integer roleId) {
        Boolean isExist = false;

        List<UserRole> userRoleList = userRoleRepository.findByUserIdAndRoleId(userId, roleId);
        if (userRoleList != null && userRoleList.size() != 0) {
            isExist = true;
        }

        return isExist;
    }

    @Override
    public List<UserRole> findByUser(Integer userId) {
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public List<UserRole> findByRole(Integer roleId) {
        return userRoleRepository.findByRoleId(roleId);
    }
}
