package com.revers.ashares.mapper;

import com.revers.ashares.ASharesApplication;
import com.revers.ashares.dao.InitTableDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Revers.
 * @date 2022/07/03 22:09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ASharesApplication.class)
public class TestCreateCompanyTable {

    @Autowired
    private InitTableDao createTableMapper;

    @Test
    public void testCreateTable(){
        createTableMapper.createCompany();
        System.out.println("success");
    }
}
