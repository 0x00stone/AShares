package com.revers.ashares.serviceImpl;

import com.revers.ashares.dao.ItemDao;
import com.revers.ashares.pojo.Item;
import com.revers.ashares.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Revers.
 * @date 2022/06/25 14:27
 **/

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public void save(Item item) {
        itemDao.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemDao.findAll();
    }
}
