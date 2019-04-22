package com.ylq.internships.mapper;

import com.ylq.internships.entity.Manager;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员实体化接口
 */
public interface ManagerMapper {
    Manager getMangerByAccount(String manAccount);
    void updateManager(Manager manager);
}
