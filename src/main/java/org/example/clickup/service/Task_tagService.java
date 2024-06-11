package org.example.clickup.service;

import org.example.clickup.dto.Task_tagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.model.Task;
import org.example.clickup.model.Task_tag;
import org.example.clickup.repository.TagRepo;
import org.example.clickup.repository.TaskRepo;
import org.example.clickup.repository.Task_tagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_tagService {

    @Autowired
    Task_tagRepo task_tagRepo;

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    TagRepo tagRepo;

    public List<Task_tag> getTask_tags() {
        return task_tagRepo.findAll();
    }

    public Task_tag getTask_tag(Long id) {
        return task_tagRepo.findById(id).get();
    }

    public Result createTask_tag(Task_tagDto task_tagDto) {
        Task_tag taskTag = new Task_tag();
        Optional<Task> byId = taskRepo.findById(task_tagDto.getTask_id());
        if (byId.isPresent()) {
            Task task = byId.get();
            taskTag.setTask_id(task);
        }
        Optional<Tag> byId1 = tagRepo.findById(task_tagDto.getTag_id());
        if (byId1.isPresent()) {
            Tag tag = byId1.get();
            taskTag.setTag_id(tag);
        }
        task_tagRepo.save(taskTag);
        return new Result(true,"Task tag created");
    }

    public Result updateTask_tag(Task_tagDto task_tagDto, Long id) {
        Optional<Task_tag> byId = task_tagRepo.findById(id);
        if (byId.isPresent()) {
            Task_tag taskTag = byId.get();
            Optional<Task> byId1 = taskRepo.findById(task_tagDto.getTask_id());
            if (byId1.isPresent()) {
                Task task = byId1.get();
                taskTag.setTask_id(task);
            }
            Optional<Tag> byId2 = tagRepo.findById(task_tagDto.getTag_id());
            if (byId2.isPresent()) {
                Tag tag = byId2.get();
                taskTag.setTag_id(tag);
            }
            task_tagRepo.save(taskTag);
            return new Result(true,"Task tag updated");
        }
        return new Result(false,"Task tag not found");
    }

    public Result deleteTask_tag(Long id) {
        task_tagRepo.deleteById(id);
        return new Result(true,"Task tag deleted");
    }

}