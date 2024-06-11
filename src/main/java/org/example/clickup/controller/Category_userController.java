package org.example.clickup.controller;

import org.example.clickup.dto.Category_userDto;
import org.example.clickup.model.Category_user;
import org.example.clickup.model.Result;
import org.example.clickup.service.Category_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category_user")
public class Category_userController {

    @Autowired
    private Category_userService category_userService;

    @GetMapping
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Category_user> getCategory_user() {
        return category_userService.readAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Category_user getCategory_user(@PathVariable Long id) {
        return category_userService.findById(id);
    }

    @PostMapping()
    public Result addCategory_user(@RequestBody Category_userDto category_user) {
        return category_userService.create(category_user);
    }

    @PutMapping("/{id}")
    public Result updateCategory_user(@PathVariable Long id, @RequestBody Category_userDto category_user) {
        return category_userService.update(category_user, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteCategory_user(@PathVariable Long id) {
        return category_userService.delete(id);
    }

}
