package me.rainking.booking.service;


import me.rainking.booking.model.Variable;

/**
 * 系统参数
 *
 * @author Rain
 */
public interface VariableService {

    /**
     * 获取配置参数
     *
     * @return 配置参数
     */
    Variable getVariable();

    /**
     * 设置配置参数
     *
     * @param variable 配置参数
     * @return 修改后的配置参数
     */
    Variable setVariable(Variable variable);
}
