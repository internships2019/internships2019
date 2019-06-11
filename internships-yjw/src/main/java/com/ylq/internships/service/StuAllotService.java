package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.dto.StudentInformation;
import com.ylq.internships.entity.StuAllot;

public interface StuAllotService {
    PageInfo<StuAllot> findStuAllotList(int page,int limit,String sScName,String state);
    PageInfo<StuAllot> findSchoolStuAllotList(int page,int limit,String sScName);
    PageInfo<StuAllot> findStuAllotListByStuName(int page,int limit,String sScName,String state,String stuName);
    PageInfo<StuAllot> findSchoolStuAllotListByStuName(int page, int limit, String sScName, String state, String stuName);
    PageInfo<StuAllot> findStudentToSchoolTeacher(int page,int limit,String scTeaWx);
    StudentInformation findStudentInformation(Integer id);
    String editLeadTeacher(String unitNo, String unitName, String id);
    String editCompanyTeacher(String unitNo, String unitName, String id);
    void removeStuAllot(String id);
    void editState(String wxNo);
    String batachEditLeadTeacher(String[] ids,String unitNo,String unitName);
    String batachEditCompanyTeacher(String[] ids,String unitNo,String unitName);
    String batchRemoveStuAllot(String[] ids);
}
