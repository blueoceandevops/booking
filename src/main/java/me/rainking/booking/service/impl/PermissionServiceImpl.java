package me.rainking.booking.service.impl;

import me.rainking.booking.model.Permission;
import me.rainking.booking.repository.PermissionRepository;
import me.rainking.booking.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Rain
 * @Date: 2017/12/6 8:25
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public boolean isCodeOnUse(String code) {
        boolean isUsed;
        if (permissionRepository.countByCode(code) == 0) {
            isUsed = false;
        } else {
            isUsed = true;
        }
        return isUsed;
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission save(String code, String name, String intro) {
        Permission permission;
        if (!isCodeOnUse(code)) {
            permission = permissionRepository.save(new Permission(code, name, intro));
        } else {
            permission = null;
            //TODO 权限码已被使用异常
        }

        return permission;
    }

    @Override
    public void delete(Integer id) {
        if (getOne(id) != null) {
            permissionRepository.delete(id);
        } else {
            //TODO 项不存在异常
        }
    }

    @Override
    public List<Permission> findByIdIn(List<Integer> permissionIdList) {
        return permissionRepository.findByIdIn(permissionIdList);
    }

    @Override
    public Permission getOne(Integer id) {
        return permissionRepository.findOne(id);
    }
}
