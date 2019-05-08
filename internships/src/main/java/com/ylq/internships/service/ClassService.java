package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.dto.ClassDto;
import com.ylq.internships.entity.Class;

import java.util.List;

public interface ClassService {
    PageInfo<Class> findClassAll(int page,int limit,String sScName);
    List<Class> findByNames(String sScName,String className);
    List<String> findAllClassNames(String sScName);
    Class findClassByNams(String sScName,String className);
    void addClass(Class aclass);
    void addBatchClass(List<Class> list);
    void editClass(ClassDto classDto);
    void removerClass(String sScName,String className);
    void removerBatchClass(String[] arr,String sScName);
}
