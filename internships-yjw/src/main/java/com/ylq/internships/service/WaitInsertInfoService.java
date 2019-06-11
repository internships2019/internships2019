package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.WaitInsertInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface WaitInsertInfoService {
    //获取已录学生列表
    PageInfo<WaitInsertInfo> findStudentAll(int page,int limit,String unitName,String pStatus);
    PageInfo<WaitInsertInfo> findWaitInsertInfoByName(int page,int limit,String unitName,String pStatus,String pName);
    WaitInsertInfo findWaitInsertInfoById(int id);
    WaitInsertInfo findTeacherById(int id);
    String addWaitInsertInfo(WaitInsertInfo waitInsertInfo);
    String batchAddWaitInsertInfo(MultipartFile file, String schoolName, String pStatus) throws IOException;
    void editImg(String id,String path);
    void editTeacher(WaitInsertInfo waitInsertInfo);
    void editStudent(WaitInsertInfo waitInsertInfo);
    void batchDeleteWaitInsertInfo(String[] arr);
    void removeWaitInsertInfo(int id);
}
