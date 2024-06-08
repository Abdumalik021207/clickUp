package org.example.clickup.controller;

import org.example.clickup.dto.TaskDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PostMapping()
    public Result createTask(@RequestBody TaskDto taskDto) {
        return taskService.addTask(taskDto);
    }

    @PutMapping("/{id}")
    public Result updateTask(@PathVariable Integer id, @RequestBody TaskDto taskDto) {
        return taskService.updateTask(taskDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask(@PathVariable Integer id) {
        return taskService.deleteTask(id);
    }

}
