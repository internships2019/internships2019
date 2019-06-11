package com.ylq.internships.mapper;

import com.ylq.internships.entity.StudentApartment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 住宿信息持久化接口
 */
@Mapper
public interface StudentApartmentMapper {
    String getAddress(String wxNo);
    void insertAddress(StudentApartment studentApartment);
    void updateAddress(StudentApartment studentApartment);
}
