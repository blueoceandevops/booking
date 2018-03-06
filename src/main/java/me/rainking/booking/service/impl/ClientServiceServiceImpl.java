package me.rainking.booking.service.impl;

import me.rainking.booking.model.ClientService;
import me.rainking.booking.repository.ClientServiceRepository;
import me.rainking.booking.service.ClientServiceService;
import me.rainking.booking.service.ServiceService;
import me.rainking.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户的服务余量
 * @Author: Rain
 * @Date: 2017/12/5 14:13
 */
@Service
public class ClientServiceServiceImpl implements ClientServiceService {

    @Autowired
    ClientServiceRepository clientServiceRepository;

    @Autowired
    UserService userService;

    @Autowired
    ServiceService serviceService;

    @Override
    public List<ClientService> listByClient(Integer userId) {
        return clientServiceRepository.findByClientId(userId);
    }

    @Override
    public List<ClientService> listByService(Integer serviceId) {
        return clientServiceRepository.findByServiceId(serviceId);
    }

    @Override
    public ClientService getByClientAndService(Integer userId, Integer serviceId) {

        List<ClientService> clientServiceList = clientServiceRepository.findByClientIdAndServiceId(userId, serviceId);
        ClientService clientService = null;
        if (clientServiceList != null && clientServiceList.size() == 1) {
            clientService = clientServiceList.get(0);
        } else {
            //不需要处理
        }

        return clientService;
    }

    @Override
    public ClientService incraese(Integer userId, Integer serviceId, Float inNum) {

        ClientService clientService = this.getByClientAndService(userId, serviceId);
        //存在，则添加
        if (clientService != null) {
            clientService.setServiceNum(clientService.getServiceNum() + inNum);
        } else {//不存在，则新建
            clientService.setClientId(userId);
            clientService.setClientName(userService.getNameById(userId));
            clientService.setServiceId(serviceId);
            clientService.setServiceName(serviceService.getNameById(serviceId));
            clientService.setServiceNum(inNum);
        }
        //TODO 用户或服务不存在时，抛出异常

        return clientServiceRepository.save(clientService);
    }

    @Override
    public ClientService decraese(Integer userId, Integer serviceId, Float deNum) {
        ClientService clientService = this.getByClientAndService(userId, serviceId);
        if (clientService.getServiceNum() < deNum) {
            //TODO 抛出余量不足异常
        } else {
            clientService.setServiceNum(clientService.getServiceNum() - deNum);
        }

        return clientServiceRepository.save(clientService);
    }
}
