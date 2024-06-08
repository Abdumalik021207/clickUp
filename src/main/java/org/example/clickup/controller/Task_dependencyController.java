package org.example.clickup.controller;

import org.example.clickup.dto.Task_dependencyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task_dependency;
import org.example.clickup.service.Task_dependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_dependency")
public class Task_dependencyController {

    @Autowired
    private Task_dependencyService task_dependencyService;

    @GetMapping()
    public List<Task_dependency> getTask_dependency() {
        return task_dependencyService.getTask_dependencies();
    }

    @GetMapping("/{id}")
    public Task_dependency getTask_dependency(@PathVariable Integer id) {
        return task_dependencyService.getTask_dependency(id);
    }

    @PostMapping()
    public Result addTask_dependency(@RequestBody Task_dependencyDto task_dependencyDto) {
        return task_dependencyService.createTask_dependency(task_dependencyDto);
    }

    @PutMapping("/{id}")
    public Result updateTask_dependency(@PathVariable Integer id, @RequestBody Task_dependencyDto task_dependencyDto) {
        return task_dependencyService.updateTask_dependency(task_dependencyDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask_dependency(@PathVariable Integer id) {
        return task_dependencyService.deleteTask_dependency(id);
    }

}