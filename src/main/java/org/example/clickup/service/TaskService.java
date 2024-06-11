package org.example.clickup.service;

import org.example.clickup.dto.TaskDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Status;
import org.example.clickup.model.Task;
import org.example.clickup.repository.StatusRepo;
import org.example.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    StatusRepo statusRepo;

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepo.findById(id).get();
    }

    public Result addTask(TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setParent_task_id(taskDto.getParent_task_id());
        task.setActived_date(taskDto.getActived_date());
        task.setDue_date(taskDto.getDue_date());
        task.setEstimate_time(taskDto.getEstimate_time());
        task.setActived_date(taskDto.getActived_date());
        task.setDue_time_has(taskDto.getDue_time_has());
        task.setPriority_id(taskDto.getPriority_id());
        task.setStart_time_has(taskDto.getStart_time_has());
        task.setStarted_date(taskDto.getStarted_date());
        Optional<Status> byId = statusRepo.findById(taskDto.getStatus_id());
        if (byId.isPresent()) {
            Status status = byId.get();
            task.setStatus_id(status);
        }
        taskRepo.save(task);
        return new Result(true,"Task created successfully");
    }

    public Result updateTask(TaskDto taskDto, Long id) {
        Optional<Task> byId = taskRepo.findById(id);
        if (byId.isPresent()) {
            Task task = byId.get();
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            task.setParent_task_id(taskDto.getParent_task_id());
            task.setActived_date(taskDto.getActived_date());
            task.setDue_date(taskDto.getDue_date());
            task.setEstimate_time(taskDto.getEstimate_time());
            task.setActived_date(taskDto.getActived_date());
            task.setDue_time_has(taskDto.getDue_time_has());
            task.setPriority_id(taskDto.getPriority_id());
            task.setStart_time_has(taskDto.getStart_time_has());
            task.setStarted_date(taskDto.getStarted_date());
            task.setDue_time_has(taskDto.getDue_time_has());
            Optional<Status> byId1 = statusRepo.findById(taskDto.getStatus_id());
            if (byId1.isPresent()) {
                Status status = byId1.get();
                task.setStatus_id(status);
            }
            taskRepo.save(task);
            return new Result(true,"Task updated successfully");
        }
        return new Result(false,"Task not found");
    }

    public Result deleteTask(Long id) {
        taskRepo.deleteById(id);
        return new Result(true,"Task deleted successfully");
    }

}
