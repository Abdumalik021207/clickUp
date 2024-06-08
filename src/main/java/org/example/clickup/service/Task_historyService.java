package org.example.clickup.service;

import org.example.clickup.dto.Task_historyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.Task_history;
import org.example.clickup.repository.TaskRepo;
import org.example.clickup.repository.Task_historyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_historyService {

    @Autowired
    Task_historyRepo task_historyRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Task_history> findAll() {
        return task_historyRepo.findAll();
    }

    public Task_history findById(Integer id) {
        return task_historyRepo.findById(id).get();
    }

    public Result create(Task_historyDto task_historyDto) {
        Task_history taskHistory = new Task_history();
        taskHistory.setAfter(task_historyDto.getAfter());
        taskHistory.setBefore(task_historyDto.getBefore());
        taskHistory.setData(task_historyDto.getData());
        taskHistory.setChange_field_name(task_historyDto.getChange_field_name());
        Optional<Task> byId = taskRepo.findById(task_historyDto.getTask_id());
        if (byId.isPresent()) {
            Task task = byId.get();
            taskHistory.setTask_id(task);
            task_historyRepo.save(taskHistory);
        }
        return new Result(true,"Successfully created");
    }

    public Result update(Task_historyDto task_historyDto, Integer id) {
        Optional<Task_history> byId = task_historyRepo.findById(id);
        if (byId.isPresent()) {
            Task_history taskHistory = byId.get();
            taskHistory.setAfter(task_historyDto.getAfter());
            taskHistory.setBefore(task_historyDto.getBefore());
            taskHistory.setData(task_historyDto.getData());
            taskHistory.setChange_field_name(task_historyDto.getChange_field_name());
            Optional<Task> byTaskId = taskRepo.findById(task_historyDto.getTask_id());
            if (byTaskId.isPresent()) {
                Task task = byTaskId.get();
                taskHistory.setTask_id(task);
            }
            task_historyRepo.save(taskHistory);
            return new Result(true,"Successfully updated");
        }
        return new Result(false,"Task not found");
    }

    public Result delete(Integer id) {
        task_historyRepo.deleteById(id);
        return new Result(true,"Successfully deleted");
    }

}