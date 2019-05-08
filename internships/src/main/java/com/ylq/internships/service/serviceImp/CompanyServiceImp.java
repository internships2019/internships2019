package com.ylq.internships.service.serviceImp;

import com.ylq.internships.mapper.CompanyMapper;
import com.ylq.internships.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<String> getAllCompany() {
        return companyMapper.getAll();
    }
}
