package me.rainking.booking.service;


import me.rainking.booking.model.ServiceServer;

import java.util.List;

/**
 * 服务-服务者
 *
 * @author Rain
 */
public interface ServiceServerService {

    /**
     * 添加（不提供修改）
     *
     * @param serviceServer 服务服务者
     * @return 服务服务者信息
     */
    ServiceServer save(ServiceServer serviceServer);

    /**
     * 添加（添加前，判断是否已存在）
     *
     * @param serviceId 服务
     * @param serverId  服务者
     * @return 服务服务者信息
     */
    ServiceServer save(Integer serviceId, Integer serverId);

    /**
     * 删除
     *
     * @param id 服务服务者
     */
    void delete(Integer id);

    /**
     * 删除（删除前判断是否存在）
     *
     * @param serviceId 服务
     * @param serverId  服务者
     */
    void delete(Integer serviceId, Integer serverId);

    /**
     * 根据服务查出所有服务者
     *
     * @param serviceId 服务
     * @return 服务服务者信息列表
     */
    List<ServiceServer> listByService(Integer serviceId);

    /**
     * 根据服务者查询其服务
     *
     * @param serverId 服务者
     * @return 服务服务者信息列表
     */
    List<ServiceServer> listByServer(Integer serverId);

    /**
     * 某服务-服务者是否已存在
     *
     * @param serviceId 服务
     * @param serverId  服务者
     * @return 是否存在
     */
    boolean isExist(Integer serviceId, Integer serverId);

}
