package com.ylq.internships.entity;

/**
 * 学生住宿信息表
 */
public class StudentApartment {
    //住宿信息编号
    private Integer id;
    //住宿详细地址
    private String liveLocation;
    //学生微信号
    private String sWx;
    //住宿地址经度
    private Double liveLongtitude;
    //住宿地址纬度
    private Double liveLatitude;

    public StudentApartment() {
    }

    public StudentApartment(Integer id, String liveLocation, String sWx, Double liveLongtitude, Double liveLatitude) {
        this.id = id;
        this.liveLocation = liveLocation;
        this.sWx = sWx;
        this.liveLongtitude = liveLongtitude;
        this.liveLatitude = liveLatitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiveLocation() {
        return liveLocation;
    }

    public void setLiveLocation(String liveLocation) {
        this.liveLocation = liveLocation;
    }

    public String getsWx() {
        return sWx;
    }

    public void setsWx(String sWx) {
        this.sWx = sWx;
    }

    public Double getLiveLongtitude() {
        return liveLongtitude;
    }

    public void setLiveLongtitude(Double liveLongtitude) {
        this.liveLongtitude = liveLongtitude;
    }

    public Double getLiveLatitude() {
        return liveLatitude;
    }

    public void setLiveLatitude(Double liveLatitude) {
        this.liveLatitude = liveLatitude;
    }
}
