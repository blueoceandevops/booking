package me.rainking.booking.service.impl;

import me.rainking.booking.model.RolePermission;
import me.rainking.booking.repository.RolePermissionRepository;
import me.rainking.booking.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Rain
 * @Date: 2017/12/5 16:36
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    RolePermissionRepository rolePermissionRepository;

    @Override
    public RolePermission save(Integer roleId, Integer permissionId) {

        RolePermission rolePermission = this.getOne(roleId, permissionId);

        if (rolePermission == null) {
            rolePermission = new RolePermission(roleId, permissionId);
            rolePermission = rolePermissionRepository.save(rolePermission);
        }

        return rolePermission;
    }

    @Override
    public void delete(Integer id) {
        rolePermissionRepository.delete(id);
    }

    @Override
    public void delete(Integer roleId, Integer permissionId) {
        RolePermission rolePermission = this.getOne(roleId, permissionId);

        if (rolePermission != null) {
            rolePermissionRepository.delete(rolePermission.getId());
        }
    }

    @Override
    public RolePermission getOne(Integer roleId, Integer permissionId) {

        RolePermission rolePermission = null;

        List<RolePermission> rolePermissionList
                = rolePermissionRepository.findByRoleIdAndPermissionId(roleId, permissionId);

        if (rolePermissionList != null) {
            rolePermission = rolePermissionList.get(0);
        }

        //不唯一时，删除多余的
        if (rolePermissionList.size() != 1) {
            for (int index = 1; index < rolePermissionList.size(); index++) {
                rolePermissionRepository.delete(rolePermissionList.get(index));
            }
        }

        return rolePermission;
    }

    @Override
    public List<RolePermission> listByRole(Integer roleId) {
        return rolePermissionRepository.findByRoleId(roleId);
    }

    @Override
    public List<RolePermission> listByPermission(Integer permissionId) {
        return rolePermissionRepository.findByPermissionId(permissionId);
    }

    @Override
    public boolean hasPermission(Integer roleId, Integer permissionId) {
        return this.getOne(roleId, permissionId) != null;
    }
}
