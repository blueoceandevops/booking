package me.rainking.booking.repository;

import me.rainking.booking.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Rain
 */
public interface ServiceRepository extends JpaRepository<ServiceModel, Integer> {

    /**
     * 根据状态查询
     *
     * @param status 状态
     * @return 服务信息
     */
    List<ServiceModel> findByStatus(Integer status);

}
