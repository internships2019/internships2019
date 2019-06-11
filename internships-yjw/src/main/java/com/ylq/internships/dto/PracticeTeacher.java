package com.ylq.internships.dto;

import com.ylq.internships.entity.WaitInsertInfo;

/**
 * 待录人员信息实体
 */
public class PracticeTeacher {
    //指导老师是否绑定小程序
    private String state;
    //指导老师基本信息实体
    private WaitInsertInfo waitInsertInfo;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public WaitInsertInfo getWaitInsertInfo() {
        return waitInsertInfo;
    }

    public void setWaitInsertInfo(WaitInsertInfo waitInsertInfo) {
        this.waitInsertInfo = waitInsertInfo;
    }

    @Override
    public String toString() {
        return "PracticeTeacher{" +
                "state='" + state + '\'' +
                ", waitInsertInfo=" + waitInsertInfo +
                '}';
    }
}
