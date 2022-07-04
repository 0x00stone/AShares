package com.revers.ashares.service;

import com.revers.ashares.pojo.Company;
import com.revers.ashares.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {
    void save(Company company);

    List<Company> findAll();
}
