package me.rainking.booking.repository;

import me.rainking.booking.model.ServiceServer;
import me.rainking.booking.model.ServiceServerClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rain
 */
public interface ServiceServerClientRepository extends JpaRepository<ServiceServerClient, Integer> {

}
