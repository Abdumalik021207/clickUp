package org.example.clickup.service;

import org.example.clickup.dto.Space_userDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.Space_user;
import org.example.clickup.repository.SpaceRepo;
import org.example.clickup.repository.Space_userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_userService {

    @Autowired
    Space_userRepo space_userRepo;

    @Autowired
    SpaceRepo spaceRepo;

    public List<Space_user> findAll() {
        return space_userRepo.findAll();
    }

    public Space_user findById(Integer id) {
        return space_userRepo.findById(id).get();
    }

    public Result save(Space_userDto space_userDto) {
        Space_user spaceUser = new Space_user();
        Optional<Space> byId = spaceRepo.findById(space_userDto.getSpace_id());
        if (byId.isPresent()) {
            Space space = byId.get();
            spaceUser.setSpace_id(space);
            space_userRepo.save(spaceUser);
        }
        return new Result(true,"Successfully saved space user");
    }

    public Result update(Space_userDto space_userDto, Integer id) {
        Optional<Space> byId = spaceRepo.findById(id);
        if (byId.isPresent()) {
            Space space = byId.get();
            Space_user spaceUser = new Space_user();
            spaceUser.setSpace_id(space);
            space_userRepo.save(spaceUser);
        }
        return new Result(true,"Successfully updated space user");
    }

    public Result delete(Integer id) {
        space_userRepo.deleteById(id);
        return new Result(true,"Successfully deleted space user");
    }

}
