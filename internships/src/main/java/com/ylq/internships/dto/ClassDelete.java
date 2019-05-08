package com.ylq.internships.dto;

import java.util.Arrays;

public class ClassDelete {
    private String[] arr;
    private String sScName;

    public ClassDelete(){

    }

    public ClassDelete(String[] arr, String sScName) {
        this.arr = arr;
        this.sScName = sScName;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public String getsScName() {
        return sScName;
    }

    public void setsScName(String sScName) {
        this.sScName = sScName;
    }

    @Override
    public String toString() {
        return "ClassDelete{" +
                "arr=" + Arrays.toString(arr) +
                ", sScName='" + sScName + '\'' +
                '}';
    }
}
