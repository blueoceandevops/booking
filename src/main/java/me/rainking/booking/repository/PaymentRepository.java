package me.rainking.booking.repository;

import me.rainking.booking.model.BookRecord;
import me.rainking.booking.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rain
 */
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
