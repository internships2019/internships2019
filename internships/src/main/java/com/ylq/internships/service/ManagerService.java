package com.ylq.internships.service;


import com.ylq.internships.entity.Manager;

public interface ManagerService {
    Manager findMangerByAccount(String manAccount);
    void editManager(Manager manager);
}
