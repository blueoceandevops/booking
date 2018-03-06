package me.rainking.booking.repository;

import me.rainking.booking.model.BookRecord;
import me.rainking.booking.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rain
 */
public interface BookRecordRepository extends JpaRepository<BookRecord, String> {

}
