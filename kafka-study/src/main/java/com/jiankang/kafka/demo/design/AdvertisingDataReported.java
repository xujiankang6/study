package com.jiankang.kafka.demo.design;

/**
 * AdvertisingDataReported
 *
 * @author jiankang.xu
 * @date 2021/11/1
 */
public interface AdvertisingDataReported {

    String topic();

    String advertisingDataReported(Object param);

}
