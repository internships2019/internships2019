package com.ylq.internships.dto;

/**
 * Created by Eskii :)
 * 2019/5/8
 **/

public class StudentInsert {
    private String openid;
    private String user_type;
    private String unit_name;
    private String user_no;
    private String p_id;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "StudentInsert{" +
                "openid='" + openid + '\'' +
                ", user_type='" + user_type + '\'' +
                ", unit_name='" + unit_name + '\'' +
                ", user_no='" + user_no + '\'' +
                ", p_id='" + p_id + '\'' +
                '}';
    }
}
