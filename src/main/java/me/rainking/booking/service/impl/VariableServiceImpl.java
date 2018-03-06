package me.rainking.booking.service.impl;

import me.rainking.booking.model.Variable;
import me.rainking.booking.repository.VariableRepository;
import me.rainking.booking.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rain
 */
@Service
public class VariableServiceImpl implements VariableService {

    Variable variable;

    @Autowired
    VariableRepository variableRepository;

    /**
     * 只保留一条数据，id为1，不可变
     */
    private static final Integer ID = 1;

    @Override
    public Variable getVariable() {

        if (variable == null || variable.getId() == null) {
            variable = variableRepository.findOne(ID);
        }

        return variable;
    }

    @Override
    public Variable setVariable(Variable variable) {

        variable.setId(ID);

        return variableRepository.save(variable);
    }
}
