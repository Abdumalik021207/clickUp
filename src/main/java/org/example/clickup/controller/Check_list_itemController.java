package org.example.clickup.controller;

import org.example.clickup.dto.Check_list_itemDto;
import org.example.clickup.model.Check_list_item;
import org.example.clickup.model.Result;
import org.example.clickup.service.Check_list_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{id}")
public class Check_list_itemController {

    @Autowired
    Check_list_itemService service;

    @GetMapping()
    public List<Check_list_item> readAll() {
        return service.getAllCheck_list_items();
    }

    @GetMapping("/{id}")
    public Check_list_item readOne(@PathVariable Integer id) {
        return service.getCheck_list_itemById(id);
    }

    @PostMapping()
    public Result create(@RequestBody Check_list_itemDto check_list_itemDto) {
        return service.createCheck_list_item(check_list_itemDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Check_list_itemDto check_list_itemDto) {
        return service.updateCheck_list_item(check_list_itemDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return service.deleteCheck_list_item(id);
    }

}