package org.example.clickup.service;

import org.example.clickup.dto.Task_userDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.Task_user;
import org.example.clickup.model.User;
import org.example.clickup.repository.TaskRepo;
import org.example.clickup.repository.Task_userRepo;
import org.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_userService {

    @Autowired
    Task_userRepo task_userRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Task_user> findAll() {
        return task_userRepo.findAll();
    }

    public Task_user findById(Integer id) {
        return task_userRepo.findById(id).get();
    }

    public Result create(Task_userDto task_userDto) {
        Task_user taskUser = new Task_user();
        Optional<User> byId = userRepo.findById(task_userDto.getUser_id());
        if (byId.isPresent()) {
            User user = byId.get();
            taskUser.setUser_id(user);
        }
        Optional<Task> byId1 = taskRepo.findById(task_userDto.getTask_id());
        if (byId1.isPresent()) {
            Task task = byId1.get();
            taskUser.setTask_id(task);
        }
        task_userRepo.save(taskUser);
        return new Result(true,"Successfully created");
    }

    public Result update(Task_userDto task_userDto, Integer id) {
        Optional<Task_user> byId = task_userRepo.findById(id);
        if (byId.isPresent()) {
            Task_user taskUser = byId.get();
            Optional<User> byId1 = userRepo.findById(task_userDto.getTask_id());
            if (byId1.isPresent()) {
                User user = byId1.get();
                taskUser.setUser_id(user);
            }
            Optional<Task> byId2 = taskRepo.findById(task_userDto.getTask_id());
            if (byId2.isPresent()) {
                Task task = byId2.get();
                taskUser.setTask_id(task);
            }
            task_userRepo.save(taskUser);
            return new Result(true,"Successfully updated");
        }
        return new Result(false,"Not found");
    }

    public Result delete(Integer id) {
        task_userRepo.deleteById(id);
        return new Result(true,"Successfully deleted");
    }

}