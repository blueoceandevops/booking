package me.rainking.booking.repository;

import me.rainking.booking.model.UserRole;
import me.rainking.booking.model.Variable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rain
 */
public interface VariableRepository extends JpaRepository<Variable, Integer> {

}
