package com.revers.ashares.mapper;

import com.revers.ashares.ASharesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Revers.
 * @date 2022/06/23 22:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ASharesApplication.class)
public class TestCreateTable {

    @Autowired
    private createTableMapper createTableMapper;

    @Test
    public void testCreateTable(){
        createTableMapper.createTable("a");
        System.out.println("success");
    }
}
