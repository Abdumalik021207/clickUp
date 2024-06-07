package org.example.clickup.controller;

import org.example.clickup.dto.Category_userDto;
import org.example.clickup.model.Category_user;
import org.example.clickup.model.Result;
import org.example.clickup.service.Category_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category_user")
public class Category_userController {

    @Autowired
    private Category_userService category_userService;

    @GetMapping
    public List<Category_user> getCategory_user() {
        return category_userService.readAll();
    }

    @GetMapping("/{id}")
    public Category_user getCategory_user(@PathVariable Integer id) {
        return category_userService.findById(id);
    }

    @PostMapping()
    public Result addCategory_user(@RequestBody Category_userDto category_user) {
        return category_userService.create(category_user);
    }

    @PutMapping("/{id}")
    public Result updateCategory_user(@PathVariable Integer id, @RequestBody Category_userDto category_user) {
        return category_userService.update(category_user, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCategory_user(@PathVariable Integer id) {
        return category_userService.delete(id);
    }

}
