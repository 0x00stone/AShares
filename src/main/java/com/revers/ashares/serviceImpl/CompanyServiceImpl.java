package com.revers.ashares.serviceImpl;

import com.revers.ashares.dao.CompanyDao;
import com.revers.ashares.pojo.Company;
import com.revers.ashares.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Revers.
 * @date 2022/07/03 22:14
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public void save(Company company) {
        companyDao.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
