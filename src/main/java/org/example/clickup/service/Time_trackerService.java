package org.example.clickup.service;

import org.example.clickup.dto.Time_trackerDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.Time_tracker;
import org.example.clickup.repository.TaskRepo;
import org.example.clickup.repository.Time_trackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Time_trackerService {

    @Autowired
    Time_trackerRepo time_trackerRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Time_tracker> getAll() {
        return time_trackerRepo.findAll();
    }

    public Time_tracker getById(Integer id) {
        return time_trackerRepo.findById(id).get();
    }

    public Result create(Time_trackerDto time_trackerDto) {
        Time_tracker timeTracker = new Time_tracker();
        timeTracker.setStarted_time(time_trackerDto.getStarted_time());
        timeTracker.setStopped_time(time_trackerDto.getStopped_time());
        Optional<Task> byId = taskRepo.findById(time_trackerDto.getTask_id());
        if (byId.isPresent()) {
            Task task = byId.get();
            timeTracker.setTask_id(task);
        }
        time_trackerRepo.save(timeTracker);
        return new Result(true,"Time tracker created");
    }

    public Result update(Time_trackerDto time_trackerDto, Integer id) {
        Optional<Time_tracker> byId = time_trackerRepo.findById(id);
        if (byId.isPresent()) {
            Time_tracker timeTracker = byId.get();
            timeTracker.setStarted_time(time_trackerDto.getStarted_time());
            timeTracker.setStopped_time(time_trackerDto.getStopped_time());
            Optional<Task> byTaskId = taskRepo.findById(time_trackerDto.getTask_id());
            if (byTaskId.isPresent()) {
                Task task = byTaskId.get();
                timeTracker.setTask_id(task);
            }
            time_trackerRepo.save(timeTracker);
            return new Result(true,"Time tracker updated");
        }
        return new Result(false,"Time tracker not found");
    }

    public Result delete(Integer id) {
        time_trackerRepo.deleteById(id);
        return new Result(true,"Time tracker deleted");
    }

}