package com.jiankang.kafka.demo.design;

/**
 * BottomAdvertisingDataReported
 *
 * @author jiankang.xu
 * @date 2021/11/1
 */
public class BottomAdvertisingDataReported implements AdvertisingDataReported{
    @Override
    public String topic() {
        return "bottom";
    }

    @Override
    public String advertisingDataReported(Object param) {
        return "bottom";
    }
}
