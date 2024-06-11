package org.example.clickup.service;

import org.example.clickup.dto.Check_list_itemDto;
import org.example.clickup.model.Check_list;
import org.example.clickup.model.Check_list_item;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.Check_listRepo;
import org.example.clickup.repository.Check_list_itemRepo;
import org.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Check_list_itemService {

    @Autowired
    Check_list_itemRepo check_list_itemRepo;

    @Autowired
    Check_listRepo check_listRepo;

    @Autowired
    UserRepo userRepo;

    public List<Check_list_item> getAllCheck_list_items() {
        return check_list_itemRepo.findAll();
    }

    public Check_list_item getCheck_list_itemById(Long id) {
        return check_list_itemRepo.findById(id).get();
    }

    public Result createCheck_list_item(Check_list_itemDto check_list_itemDto) {
        Check_list_item checkListItem = new Check_list_item();
        checkListItem.setName(check_list_itemDto.getName());
        checkListItem.setResolved(check_list_itemDto.isResolved());

        Optional<Check_list> byId = check_listRepo.findById(check_list_itemDto.getCheck_list_id());
        Check_list checkList = byId.get();
        checkListItem.setCheck_list_id(checkList);

        Optional<User> byId1 = userRepo.findById(check_list_itemDto.getAssigned_user_id());
        User user = byId1.get();
        checkListItem.setAssigned_user_id(user);

        check_list_itemRepo.save(checkListItem);

        return new Result(true,"Successfully created check_list_item");
    }

    public Result updateCheck_list_item(Check_list_itemDto check_list_itemDto, Long id) {
        Optional<Check_list_item> byId = check_list_itemRepo.findById(id);
        if (byId.isPresent()) {
            Check_list_item checkListItem = byId.get();
            checkListItem.setName(check_list_itemDto.getName());
            checkListItem.setResolved(check_list_itemDto.isResolved());

            Optional<Check_list> byId1 = check_listRepo.findById(check_list_itemDto.getCheck_list_id());
            Check_list checkList = byId1.get();
            checkListItem.setCheck_list_id(checkList);

            Optional<User> byId2 = userRepo.findById(check_list_itemDto.getAssigned_user_id());
            User user = byId2.get();
            checkListItem.setAssigned_user_id(user);

            check_list_itemRepo.save(checkListItem);

            return new Result(true,"Successfully updated check_list_item");
        }
        return new Result(false,"Check_list_item not found");
    }

    public Result deleteCheck_list_item(Long id) {
        check_list_itemRepo.deleteById(id);
        return new Result(true,"Successfully deleted check_list_item");
    }


}
