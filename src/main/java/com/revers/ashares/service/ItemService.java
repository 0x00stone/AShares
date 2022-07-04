package com.revers.ashares.service;


import com.revers.ashares.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    void save(Item item);

    List<Item> findAll();
}
