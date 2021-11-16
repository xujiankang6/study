package com.jiankang.kafka.demo;

/**
 * DataUtils
 *
 * @author jiankang.xu
 * @date 2021/10/28
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DataUtils {

    public static String[] taxs = new String[]{"稿酬所得", "劳务报酬所得", "特许权使用费所得"};
    public static String[] documentPropertys = new String[]{"A公司", "B公司"};
    public static int[] lectures = new int[]{100, 101, 102, 103};


    public static List<DataRecord> getDatas() {
        List<DataRecord> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new DataRecord(i, taxs[i % 3], documentPropertys[i % 2], new BigDecimal(i), lectures[i % 4]));
        }
        return list;
    }

    public static void main(String[] args) {
        List a = new ArrayList();
        a.add(100);
        List<DataRecord> list = getDatas();
        //根据tax documentProperty ,lecture 分组
        Map<Integer,  List<DataRecord>> bigMap = list.stream().filter(it ->
                it.getDocument_property() != null && it.getLecture() != null && it.getTax_type() != null).collect(Collectors.groupingBy(DataRecord::getLecture));
        Set<Integer> integers = bigMap.keySet();
        for (Integer integer : integers) {
            if(a.contains(integer)){
                List<DataRecord> dataRecords = bigMap.get(integer);
                Integer deviceIp = integer;


            }
        }
    }


}
