package org.example.clickup.controller;

import org.example.clickup.dto.Project_userDto;
import org.example.clickup.model.Project_user;
import org.example.clickup.model.Result;
import org.example.clickup.service.Project_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_user")
public class Project_userController {

    @Autowired
    Project_userService project_userService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Project_user> getProject_user() {
        return project_userService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Project_user getProject_user(@PathVariable Long id) {
        return project_userService.findById(id);
    }

    @PostMapping()
    public Result addProject_user(@RequestBody Project_userDto project_userDto) {
        return project_userService.save(project_userDto);
    }

    @PutMapping("/{id}")
    public Result updateProject_user(@PathVariable Long id, @RequestBody Project_userDto project_userDto) {
        return project_userService.update(project_userDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteProject_user(@PathVariable Long id) {
        return project_userService.delete(id);
    }
}
