package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Manager;

public interface ManagerService {
    Manager findMangerByAccount(String manAccount);
    void editManager(Manager manager);
    PageInfo<Manager> findSchoolManager(int page,int limit);
    void addManager(Manager manager);
    void removeManager(String manAccount);
    void removeBatchManager(String[] manAccounts);
}
