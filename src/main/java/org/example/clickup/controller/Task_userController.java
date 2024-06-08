package org.example.clickup.controller;

import org.example.clickup.dto.Task_userDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task_user;
import org.example.clickup.service.Task_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_user")
public class Task_userController {

    @Autowired
    private Task_userService task_userService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Task_user> getTask_user() {
        return task_userService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Task_user getTask_user(@PathVariable Integer id) {
        return task_userService.findById(id);
    }

    @PostMapping()
    public Result createTask_user(@RequestBody Task_userDto task_userDto) {
        return task_userService.create(task_userDto);
    }

    @PutMapping("/{id}")
    public Result updateTask_user(@PathVariable Integer id, @RequestBody Task_userDto task_userDto) {
        return task_userService.update(task_userDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteTask_user(@PathVariable Integer id) {
        return task_userService.delete(id);
    }

}
