package com.jiankang.kafka.demo.design;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * StrategyFactory
 *
 * @author jiankang.xu
 * @date 2021/11/1
 */
public class StrategyFactory implements ApplicationContextAware {

    private final Map<String, AdvertisingDataReported> STRATEGY_MAP = new ConcurrentHashMap<>();


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, AdvertisingDataReported> tempMap = applicationContext.getBeansOfType(AdvertisingDataReported.class);
        tempMap.values().forEach(str->STRATEGY_MAP.put(str.getClass().getName(),str));
    }

    public <T extends AdvertisingDataReported> AdvertisingDataReported getInstance(String clazz) {
        return STRATEGY_MAP.get(clazz);
    }
}
