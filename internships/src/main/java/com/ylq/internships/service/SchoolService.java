package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.School;

import java.util.List;

public interface SchoolService {
    PageInfo<School> getAll(int page,int limit);
    List<String> getAllName();
    School getSchoolByName(String schoolName);
    void addSchool(School school);
    void editSchol(School school);
    void removeSchool(String scName);
}
