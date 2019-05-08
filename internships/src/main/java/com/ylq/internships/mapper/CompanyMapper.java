package com.ylq.internships.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 企业持久层接口
 */
@Mapper
public interface CompanyMapper {

    public List<String> getAll();
}
