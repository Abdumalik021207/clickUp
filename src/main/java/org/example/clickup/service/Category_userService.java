package org.example.clickup.service;

import org.example.clickup.dto.Category_userDto;
import org.example.clickup.model.Category;
import org.example.clickup.model.Category_user;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.CategoryRepo;
import org.example.clickup.repository.Category_userRepo;
import org.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Category_userService {

    @Autowired
    Category_userRepo category_userRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    UserRepo userRepo;

    public List<Category_user> readAll() {
        return category_userRepo.findAll();
    }

    public Category_user findById(Long id) {
        return category_userRepo.findById(id).get();
    }

    public Result create(Category_userDto category_userDto) {
        Category_user category_user = new Category_user();
        category_user.setName(category_userDto.getName());
        category_user.setTask_permission(category_userDto.getTask_permission());

        Optional<Category> byId = categoryRepo.findById(category_userDto.getCategory_id());
        Category category = byId.get();
        category_user.setCategory_id(category);

        Optional<User> byId1 = userRepo.findById(category_userDto.getUser_id());
        User user = byId1.get();
        category_user.setUser_id(user);

        category_userRepo.save(category_user);

        return new Result(true,"Successfully created");
    }

    public Result update(Category_userDto category_userDto, Long id) {
        Optional<Category_user> byId = category_userRepo.findById(id);
        Category_user category_user = byId.get();

        if (byId.isPresent()) {
            category_user.setName(category_userDto.getName());
            category_user.setTask_permission(category_userDto.getTask_permission());

            Optional<Category> byId1 = categoryRepo.findById(category_userDto.getCategory_id());
            Category category = byId1.get();
            category_user.setCategory_id(category);

            Optional<User> byId2 = userRepo.findById(category_userDto.getUser_id());
            User user = byId2.get();
            category_user.setUser_id(user);

            category_userRepo.save(category_user);
            return new Result(true,"Successfully updated");

        }
        return new Result(false,"Error");
    }

    public Result delete(Long id) {
        category_userRepo.deleteById(id);
        return new Result(true,"Successfully deleted");
    }


}
