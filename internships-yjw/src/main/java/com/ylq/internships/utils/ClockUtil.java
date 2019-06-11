package com.ylq.internships.utils;

import java.awt.geom.Point2D;

import static com.ylq.internships.utils.Contant.APARTMENT;
import static com.ylq.internships.utils.Contant.COMPANY;

/**
 * Created by Eskii :)
 * 2019/5/23
 **/
public class ClockUtil {

    /**
     * 地球半径
     */
    private static double EARTH_RADIUS = 6371393.0;

    public Boolean isValidate(Point2D clockLocation, Point2D stuLocation,String type) {
        Double area = 0.0;
        switch (type) {
            case COMPANY:
                area = 800.0;
                break;
            case APARTMENT:
                area = 500.0;
                break;
            default:
                area = 50.0;
                break;
        }
        // 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        double radiansAX = Math.toRadians(clockLocation.getX()); // A经弧度
        double radiansAY = Math.toRadians(clockLocation.getY()); // A纬弧度
        double radiansBX = Math.toRadians(stuLocation.getX()); // B经弧度
        double radiansBY = Math.toRadians(stuLocation.getY()); // B纬弧度

        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        //        System.out.println("cos = " + cos); // 值域[-1,1]
        double acos = Math.acos(cos); // 反余弦值
        //        System.out.println("acos = " + acos); // 值域[0,π]
        //        System.out.println("∠AOB = " + Math.toDegrees(acos)); // 球心角 值域[0,180]
        double distance = EARTH_RADIUS * acos;
        if (distance > area){
            return false;
        }
        return true;
    }

}
