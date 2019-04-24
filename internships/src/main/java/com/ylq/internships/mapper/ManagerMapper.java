package com.ylq.internships.mapper;

import com.ylq.internships.entity.Manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理员实体化接口
 */
public interface ManagerMapper {

    //通过账号获取管理员信息
    Manager getMangerByAccount(String manAccount);
    //管理人员学信息修改
    void updateManager(Manager manager);
    //获取学校管理员列表
    List<Manager> getSchoolManager(String manStatus);
    //创建管理员
    void insertManager(Manager manager);
    //删除管理员
    void deleteManager(String manAccount);
    void deleteBatchManager(String[] manAccounts);
}
