package org.example.clickup.service;

import org.example.clickup.dto.Task_dependencyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.Task_dependency;
import org.example.clickup.repository.TaskRepo;
import org.example.clickup.repository.Task_dependencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_dependencyService {

    @Autowired
    Task_dependencyRepo task_dependencyRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Task_dependency> getTask_dependencies() {
        return task_dependencyRepo.findAll();
    }

    public Task_dependency getTask_dependency(Long id) {
        return task_dependencyRepo.findById(id).get();
    }

    public Result createTask_dependency(Task_dependencyDto task_dependencyDto) {
        Task_dependency taskDependency = new Task_dependency();
        taskDependency.setDependency_type(task_dependencyDto.getDependency_type());
        task_dependencyRepo.save(taskDependency);
        Optional<Task> byId = taskRepo.findById(task_dependencyDto.getDependency_task_id());
        if (byId.isPresent()) {
            Task task = byId.get();
            taskDependency.setTask_id(task);
            task_dependencyRepo.save(taskDependency);
        }
        return new Result(true,"Task dependency created");
    }

    public Result updateTask_dependency(Task_dependencyDto task_dependencyDto, Long id) {
        Optional<Task_dependency> byId = task_dependencyRepo.findById(id);
        if (byId.isPresent()) {
            Task_dependency taskDependency = byId.get();
            taskDependency.setDependency_type(task_dependencyDto.getDependency_type());
            task_dependencyRepo.save(taskDependency);
            Optional<Task> byTaskId = taskRepo.findById(task_dependencyDto.getTask_id());
            if (byTaskId.isPresent()) {
                Task task = byTaskId.get();
                taskDependency.setTask_id(task);
                task_dependencyRepo.save(taskDependency);
            }
            return new Result(true,"Task dependency updated");
        }
        return new Result(false,"Task dependency not found");
    }

    public Result deleteTask_dependency(Long id) {
        task_dependencyRepo.deleteById(id);
        return new Result(true,"Task dependency deleted");
    }

}