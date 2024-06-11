package org.example.clickup.service;

import org.example.clickup.dto.ProjectDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.repository.ProjectRepo;
import org.example.clickup.repository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    SpaceRepo spaceRepo;

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepo.findById(id).get();
    }

    public Result addProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setAcces_type(projectDto.getAcces_type());
        project.setColor(projectDto.getColor());
        Optional<Space> byId = spaceRepo.findById(projectDto.getSpace_id());
        if (byId.isPresent()) {
            Space space = byId.get();
            project.setSpace_id(space);
            projectRepo.save(project);
        }
        projectRepo.save(project);
        return new Result(true,"Successfully added project");
    }

    public Result updateProject(Long id, ProjectDto projectDto) {
        Optional<Project> byId = projectRepo.findById(id);
        if (byId.isPresent()) {
            Project project = byId.get();
            project.setName(projectDto.getName());
            project.setAcces_type(projectDto.getAcces_type());
            project.setColor(projectDto.getColor());
            Optional<Space> bySpaceId = spaceRepo.findById(projectDto.getSpace_id());
            if (bySpaceId.isPresent()) {
                Space space = bySpaceId.get();
                project.setSpace_id(space);
                projectRepo.save(project);
            }
            projectRepo.save(project);
        }
        return new Result(true,"Successfully updated project");
    }

    public Result deleteProject(Long id) {
        projectRepo.deleteById(id);
        return new Result(true,"Successfully deleted project");
    }

}