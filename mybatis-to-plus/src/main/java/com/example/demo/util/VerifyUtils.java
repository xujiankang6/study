package com.example.demo.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * verifyUtils
 *
 * @author jiankang.xu
 * @date 2021/9/20
 */
@Component
public class VerifyUtils {

    public static boolean isNumber(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(s);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
