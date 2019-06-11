package com.ylq.internships.mapper;


import com.ylq.internships.entity.CompanyJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 动态项目持久层接口
 */
@Mapper
public interface CompanyJobMapper {
    /**
     * lwq
     * @return
     */
    List<CompanyJob> getAll(String sc_name);
    List<CompanyJob> getAllDesc(String sc_name);
    List<CompanyJob> searchByComName(String com_name,String sc_name);
    CompanyJob searchById(String job_id);
    void addNowNum(String job_id);
    String checkNowNum(String job_id);
}
