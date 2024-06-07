package org.example.clickup.service;

import org.example.clickup.repository.Check_list_itemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Check_list_itemService {

    @Autowired
    Check_list_itemRepo check_list_itemRepo;



}
