package com.revers.ashares.dao;

import com.revers.ashares.pojo.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company,Integer> {
}
