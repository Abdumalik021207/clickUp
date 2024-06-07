package org.example.clickup.service;

import org.example.clickup.dto.Project_userDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.Project_user;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.ProjectRepo;
import org.example.clickup.repository.Project_userRepo;
import org.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Project_userService {

    @Autowired
    Project_userRepo project_userRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProjectRepo projectRepo;

    public List<Project_user> findAll() {
        return project_userRepo.findAll();
    }

    public Project_user findById(Integer id) {
        return project_userRepo.findById(id).get();
    }

    public Result save(Project_userDto project_userDto) {
        Project_user project_user = new Project_user();
        project_user.setTask_permission(project_userDto.getTask_permission());

        Optional<User> byId = userRepo.findById(project_userDto.getProject_id());
        if (byId.isPresent()) {
            User user = byId.get();
            project_user.setUser_id(user);
            project_userRepo.save(project_user);
        }

        Optional<Project> byId1 = projectRepo.findById(project_userDto.getProject_id());
        if (byId1.isPresent()) {
            Project project = byId1.get();
            project_user.setProject_id(project);
            project_userRepo.save(project_user);
        }
        return new Result(true,"Successfully Saved");
    }

    public Result update(Project_userDto project_userDto, Integer id) {
        Optional<Project_user> byId = project_userRepo.findById(id);
        if (byId.isPresent()) {
            Project_user project_user = byId.get();
            project_user.setTask_permission(project_userDto.getTask_permission());

            Optional<Project> byId1 = projectRepo.findById(project_userDto.getProject_id());
            if (byId1.isPresent()) {
                Project project = byId1.get();
                project_user.setProject_id(project);
                project_userRepo.save(project_user);
            }
            Optional<User> byId2 = userRepo.findById(project_userDto.getUser_id());
            if (byId2.isPresent()) {
                User user = byId2.get();
                project_user.setUser_id(user);
                project_userRepo.save(project_user);
            }
            return new Result(true,"Successfully Updated");
        }
        return new Result(false,"Not Found");
    }

    public Result delete(Integer id) {
        project_userRepo.deleteById(id);
        return new Result(true,"Successfully Deleted");
    }


}
