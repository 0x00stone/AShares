package com.revers.ashares.service;


import com.revers.ashares.pojo.Item;

import java.util.List;

public interface ItemService {
    void save(Item item);

    List<Item> findAll();
}
