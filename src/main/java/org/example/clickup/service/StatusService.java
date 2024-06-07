package org.example.clickup.service;

import org.example.clickup.dto.StatusDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.CategoryRepo;
import org.example.clickup.repository.ProjectRepo;
import org.example.clickup.repository.SpaceRepo;
import org.example.clickup.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepo statusRepo;

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public List<Status> getAll() {
        return statusRepo.findAll();
    }

    public Status getStatus(Integer id) {
        return statusRepo.findById(id).get();
    }

    public Result addStatus(StatusDto statusDto) {
        Status status = new Status();
        status.setName(statusDto.getName());
        status.setColor(statusDto.getColor());
        status.setType(statusDto.getType());

        Optional<Project> byId = projectRepo.findById(statusDto.getProject_id());
        if (byId.isPresent()) {
            Project project = byId.get();
            status.setProject_id(project);
            statusRepo.save(status);
        }
        Optional<Space> bySpaceId = spaceRepo.findById(statusDto.getSpace_id());
        if (bySpaceId.isPresent()) {
            Space space = bySpaceId.get();
            status.setSpace_id(space);
            statusRepo.save(status);
        }
        Optional<Category> byCategoryId = categoryRepo.findById(statusDto.getCategory_id());
        if (byCategoryId.isPresent()) {
            Category category = byCategoryId.get();
            status.setCategory_id(category);
            statusRepo.save(status);
        }
        statusRepo.save(status);
        return new Result(true,"Successfully added status");
    }

    public Result updateStatus(Integer id, StatusDto statusDto) {
        Optional<Status> byId = statusRepo.findById(id);
        if (byId.isPresent()) {
            Status status = byId.get();
            status.setName(statusDto.getName());
            status.setColor(statusDto.getColor());
            status.setType(statusDto.getType());
            Optional<Project> byProjectId = projectRepo.findById(statusDto.getProject_id());
            if (byProjectId.isPresent()) {
                Project project = byProjectId.get();
                status.setProject_id(project);
                statusRepo.save(status);
            }
            Optional<Space> bySpaceId = spaceRepo.findById(statusDto.getSpace_id());
            if (bySpaceId.isPresent()) {
                Space space = bySpaceId.get();
                status.setSpace_id(space);
                statusRepo.save(status);
            }
            Optional<Category> byCategoryId = categoryRepo.findById(statusDto.getCategory_id());
            if (byCategoryId.isPresent()) {
                Category category = byCategoryId.get();
                status.setCategory_id(category);
                statusRepo.save(status);
            }
            statusRepo.save(status);
            return new Result(true,"Successfully updated status");
        }
        return new Result(false,"Not found status");
    }

    public Result deleteStatus(Integer id) {
        statusRepo.deleteById(id);
        return new Result(true,"Successfully deleted status");
    }

}