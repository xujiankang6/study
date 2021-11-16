package com.jiankang.kafka.demo.design;

/**
 * BottomAdvertisingDataReported
 *
 * @author jiankang.xu
 * @date 2021/11/1
 */
public class TopAdvertisingDataReported implements AdvertisingDataReported{
    @Override
    public String topic() {
        return "top";
    }

    @Override
    public String advertisingDataReported(Object param) {
        return "top";
    }
}
