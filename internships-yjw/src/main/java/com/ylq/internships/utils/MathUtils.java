package com.ylq.internships.utils;

import java.math.BigDecimal;
import java.util.Formatter;

public class MathUtils {

    public static Double printNoMoreZero(double val) {

        Formatter rmZero = new Formatter();
        // 进行格式化截断尾部小数并转化成字符串
        String rm = ""+rmZero.format("%g", val);
        // 将字符串解析成double并存入大数类
        BigDecimal todo = BigDecimal.valueOf(Double.parseDouble(rm));
        return todo.doubleValue();
    }

}
