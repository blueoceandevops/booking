package me.rainking.booking.service;


import me.rainking.booking.model.ServiceModel;

import java.util.List;

/**
 * 服务项目
 *
 * @author Rain
 */
public interface ServiceService {

    /**
     * 添加、修改服务项
     *
     * @param serviceModel 服务信息
     * @return 服务信息
     */
    ServiceModel save(ServiceModel serviceModel);

    /**
     * 添加服务项，默认启用
     *
     * @param name  服务名
     * @param intro 简介
     * @return 服务信息
     */
    ServiceModel save(String name, String intro);

    /**
     * 修改服务状态
     *
     * @param id     编号
     * @param status 状态
     * @return 服务信息
     */
    ServiceModel changeStatus(Integer id, Integer status);

    /**
     * 启用服务
     *
     * @param id 服务id
     * @return 服务信息
     */
    ServiceModel turnOn(Integer id);

    /**
     * 停用服务
     *
     * @param id
     * @return 服务信息
     */
    ServiceModel turnOff(Integer id);

    /**
     * 查询全部服务
     *
     * @return 全部服务信息
     */
    List<ServiceModel> listAll();

    /**
     * 根据状态查询服务
     *
     * @param status 状态，0未启用1启用(StatusEnum)
     * @return 服务信息
     */
    List<ServiceModel> listByStatus(Integer status);

    /**
     * 查询全部启用的服务
     *
     * @return
     */
    List<ServiceModel> listOn();

    /**
     * 查询全部停用的服务
     *
     * @return
     */
    List<ServiceModel> listOff();

    /**
     * 根据id获取
     *
     * @param id id
     * @return 服务
     */
    ServiceModel getOne(Integer id);


    /**
     * 根据id获取名称
     *
     * @param id id
     * @return 名称
     */
    String getNameById(Integer id);

}
