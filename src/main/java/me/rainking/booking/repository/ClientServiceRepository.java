package me.rainking.booking.repository;

import me.rainking.booking.model.ClientService;
import me.rainking.booking.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Rain
 */
public interface ClientServiceRepository extends JpaRepository<ClientService, Integer> {

    /**
     * 使用客户id查找
     *
     * @param clientId 客户id
     * @return 客户服务信息
     */
    List<ClientService> findByClientId(Integer clientId);

    /**
     * 使用服务id查找
     *
     * @param serviceId 服务id
     * @return 客户服务信息
     */
    List<ClientService> findByServiceId(Integer serviceId);

    /**
     * 使用客户和服务查找（逻辑数量为1）
     *
     * @param clientId  客户
     * @param serviceId 服务
     * @return 客户服务信息
     */
    List<ClientService> findByClientIdAndServiceId(Integer clientId, Integer serviceId);
}
