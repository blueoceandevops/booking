package me.rainking.booking.service;


import me.rainking.booking.model.ServiceServerClient;

import java.util.List;

/**
 * 为客户安排的服务的服务者的信息
 *
 * @author Rain
 */
public interface ServiceServerClientService {

    /**
     * 添加（不支持修改）
     *
     * @param serviceServerId 服务——服务者
     * @param clientId        客户
     * @return 服务服务者、客户关联信息
     */
    ServiceServerClient save(Integer serviceServerId, Integer clientId);

    /**
     * 根据id删除
     *
     * @param id id
     */
    void delete(Integer id);

    /**
     * 取消服务-服务者与客户的关联
     *
     * @param serviceServerId 服务-服务者
     * @param clientId 客户
     */
    void delete(Integer serviceServerId, Integer clientId);

    /**
     * 查询某用户的当前全部服务及服务者
     *
     * @param clientId 客户
     * @return 服务及服务者列表
     */
    List<ServiceServerClient> listByClient(Integer clientId);

    /**
     * 查询某项服务某服务者，全部客户
     *
     * @param serviceServer 服务-服务者
     * @return 服务及服务者列表
     */
    List<ServiceServerClient> listByServiceServer(Integer serviceServer);


}
