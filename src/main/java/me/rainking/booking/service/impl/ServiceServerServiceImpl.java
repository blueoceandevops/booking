package me.rainking.booking.service.impl;

import me.rainking.booking.model.ServiceServer;
import me.rainking.booking.repository.ServiceServerRepository;
import me.rainking.booking.service.ServiceServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Rain
 * @Date: 2017/12/6 9:33
 */
@Service
public class ServiceServerServiceImpl implements ServiceServerService {

    @Autowired
    ServiceServerRepository serviceServerRepository;

    @Override
    public ServiceServer save(ServiceServer serviceServer) {
        return serviceServerRepository.save(serviceServer);
    }

    /**
     * 添加（添加前，判断是否已存在）
     *
     * @param serviceId 服务
     * @param serverId  服务者
     * @return 服务服务者信息
     */
    @Override
    public ServiceServer save(Integer serviceId, Integer serverId) {
        return null;
    }

    /**
     * 删除
     *
     * @param id 服务服务者
     */
    @Override
    public void delete(Integer id) {

    }

    /**
     * 删除（删除前判断是否存在）
     *
     * @param serviceId 服务
     * @param serverId  服务者
     */
    @Override
    public void delete(Integer serviceId, Integer serverId) {

    }

    /**
     * 根据服务查出所有服务者
     *
     * @param serviceId 服务
     * @return 服务服务者信息列表
     */
    @Override
    public List<ServiceServer> listByService(Integer serviceId) {
        return null;
    }

    /**
     * 根据服务者查询其服务
     *
     * @param serverId 服务者
     * @return 服务服务者信息列表
     */
    @Override
    public List<ServiceServer> listByServer(Integer serverId) {
        return null;
    }

    /**
     * 某服务-服务者是否已存在
     *
     * @param serviceId 服务
     * @param serverId  服务者
     * @return 是否存在
     */
    @Override
    public boolean isExist(Integer serviceId, Integer serverId) {
        return false;
    }
}
