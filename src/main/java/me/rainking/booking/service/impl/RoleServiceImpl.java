package me.rainking.booking.service.impl;

import me.rainking.booking.model.Role;
import me.rainking.booking.model.UserRole;
import me.rainking.booking.repository.RoleRepository;
import me.rainking.booking.service.RoleService;
import me.rainking.booking.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rain
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleService userRoleService;

    @Override
    public Role save(Role role) {

        //更新，或添加的角色名不存在则允许入库
        if (role.getId() != null || findByName(role.getName()) == null) {
            role = roleRepository.save(role);
        } else {
            role = null;
        }

        return role;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findOne(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<Role> findByIdIn(List<Integer> roleIdList) {
        return roleRepository.findByIdIn(roleIdList);
    }

    @Override
    public List<Role> findByUser(Integer userId) {

        List<Integer> roleId = userRoleService.findByUser(userId).stream()
                .map(e -> e.getRoleId())
                .collect(Collectors.toList());

        return roleRepository.findByIdIn(roleId);
    }

    @Override
    public Role findByName(String name) {
        Role role;
        List<Role> roleList = roleRepository.findByName(name);
        if (roleList != null && roleList.size() == 1) {
            role = roleList.get(0);

        } else {
            role = null;
        }

        return role;
    }

    @Override
    public void delete(Integer id) {
        List<UserRole> userRoleList = userRoleService.findByRole(id);

        boolean isRoleExist = (roleRepository.findOne(id) == null);
        boolean isRoleOnUse = (userRoleList != null && userRoleList.size() != 0);

        if (isRoleOnUse || isRoleExist) {
            ;//有关联的用户，或不存在，不能删除
            //TODO 禁止删除异常
        } else {
            roleRepository.delete(id);
        }
    }
}
