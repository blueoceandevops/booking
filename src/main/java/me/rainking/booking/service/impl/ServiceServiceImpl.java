package me.rainking.booking.service.impl;

import me.rainking.booking.enums.StatusEnum;
import me.rainking.booking.model.ServiceModel;
import me.rainking.booking.repository.ServiceRepository;
import me.rainking.booking.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Rain
 * @Date: 2017/12/5 15:00
 */
@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public ServiceModel save(ServiceModel serviceModel) {
        return serviceRepository.save(serviceModel);
    }

    @Override
    public ServiceModel save(String name, String intro) {
        ServiceModel serviceModel = new ServiceModel(name, intro);
        serviceModel.setStatus(StatusEnum.ON.getCode());

        return serviceRepository.save(serviceModel);
    }

    @Override
    public ServiceModel changeStatus(Integer id, Integer status) {

        ServiceModel serviceModel = serviceRepository.findOne(id);
        if (serviceModel != null && !serviceModel.getStatus().equals(status)) {
            serviceModel.setStatus(status);
            serviceModel = serviceRepository.save(serviceModel);
        } else {
            //服务不存在或状态与指定状态一致，不处理
        }

        return serviceModel;
    }

    @Override
    public ServiceModel turnOn(Integer id) {
        return changeStatus(id, StatusEnum.ON.getCode());
    }

    @Override
    public ServiceModel turnOff(Integer id) {
        return changeStatus(id, StatusEnum.OFF.getCode());
    }

    @Override
    public List<ServiceModel> listAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<ServiceModel> listByStatus(Integer status) {
        return serviceRepository.findByStatus(status);
    }

    @Override
    public List<ServiceModel> listOn() {
        return listByStatus(StatusEnum.ON.getCode());
    }

    @Override
    public List<ServiceModel> listOff() {
        return listByStatus(StatusEnum.OFF.getCode());
    }

    @Override
    public ServiceModel getOne(Integer id) {
        return serviceRepository.findOne(id);
    }

    @Override
    public String getNameById(Integer id) {

        String name;
        ServiceModel serviceModel = this.getOne(id);
        if (serviceModel != null) {
            name = serviceModel.getName();
        } else {
            name = null;
        }
        return name;
    }

}
