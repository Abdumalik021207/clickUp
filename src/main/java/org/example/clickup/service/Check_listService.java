package org.example.clickup.service;

import org.example.clickup.dto.Check_listDto;
import org.example.clickup.model.Check_list;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.repository.Check_listRepo;
import org.example.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Check_listService {

    @Autowired
    Check_listRepo check_listRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Check_list> getAllCheck_list() {
        return check_listRepo.findAll();
    }

    public Check_list getCheck_listById(Long id) {
        return check_listRepo.findById(id).get();
    }

    public Result addCheck_list(Check_listDto check_listDto) {
        Check_list checkList = new Check_list();
        checkList.setName(check_listDto.getName());
        Optional<Task> byId = taskRepo.findById(check_listDto.getTask_id());
        if (byId.isPresent()) {
            Task task = byId.get();
            check_listDto.setTask_id(task.getId());
        }
        check_listRepo.save(checkList);
        return new Result(true,"Successfully added check_list");
    }

    public Result updateCheck_list(Check_listDto check_listDto, Long id) {
        Optional<Check_list> byId = check_listRepo.findById(id);
        if (byId.isPresent()) {
            Check_list checkList = byId.get();
            checkList.setName(check_listDto.getName());

            Optional<Task> byId1 = taskRepo.findById(check_listDto.getTask_id());
            if (byId1.isPresent()) {
                Task task = byId1.get();
                check_listDto.setTask_id(task.getId());
            }
            check_listRepo.save(checkList);
            return new Result(true,"Successfully updated check_list");
        }
        return new Result(false,"Successfully updated check_list");
    }

    public Result deleteCheck_list(Long id) {
        check_listRepo.deleteById(id);
        return new Result(true,"Successfully deleted check_list");
    }

}
