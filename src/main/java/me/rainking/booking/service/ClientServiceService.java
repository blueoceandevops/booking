package me.rainking.booking.service;


import me.rainking.booking.model.ClientService;

import java.util.List;

/**
 * 客户的服务余量
 *
 * @author Rain
 */
public interface ClientServiceService {

    /**
     * 查找用户全部服务及余量
     *
     * @param userId 用户
     * @return 客户服务信息
     */
    List<ClientService> listByClient(Integer userId);

    /**
     * 查找服务的全部用户及余量
     *
     * @param serviceId 服务
     * @return 客户服务信息
     */
    List<ClientService> listByService(Integer serviceId);

    /**
     * 查找用户某项服务的信息
     *
     * @param userId    用户
     * @param serviceId 服务
     * @return 用户服务信息
     */
    ClientService getByClientAndService(Integer userId, Integer serviceId);

    /**
     * 添加，不存在则新建
     *
     * @param userId    用户
     * @param serviceId 服务
     * @param inNum     添加的量
     * @return 剩余量
     */
    ClientService incraese(Integer userId, Integer serviceId, Float inNum);

    /**
     * 扣减，余量不足时不允许扣减
     *
     * @param userId    用户
     * @param serviceId 服务
     * @param deNum     扣减量
     * @return 剩余量
     */
    ClientService decraese(Integer userId, Integer serviceId, Float deNum);

}
