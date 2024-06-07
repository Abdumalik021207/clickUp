package org.example.clickup.service;

import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.User;
import org.example.clickup.repository.IconRepo;
import org.example.clickup.repository.SpaceRepo;
import org.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    IconRepo iconRepo;

    public List<Space> getSpaces() {
        return spaceRepo.findAll();
    }

    public Space getSpace(Integer id) {
        return spaceRepo.findById(id).get();
    }

    public Result createSpace(SpaceDto spaceDto) {
        Space space = new Space();
        space.setName(spaceDto.getName());
        space.setColor(spaceDto.getColor());
        space.setAccess_type(spaceDto.getAccess_type());
        space.setInitial_letter(spaceDto.getInitial_letter());

        Optional<User> byId = userRepo.findById(spaceDto.getOwner_id());
        if (byId.isPresent()) {
            User user = byId.get();
            space.setOwner_id(user);
            spaceRepo.save(space);
        }
        Optional<Icon> byId1 = iconRepo.findById(spaceDto.getIcon_id());
        if (byId1.isPresent()) {
            Icon icon = byId1.get();
            space.setIcon_id(icon);
            spaceRepo.save(space);
        }
        return new Result(true,"Space created");
    }

    public Result updateSpace(SpaceDto spaceDto, Integer id) {
        Optional<Space> byId = spaceRepo.findById(id);
        if (byId.isPresent()) {
            Space space = byId.get();
            space.setName(spaceDto.getName());
            space.setColor(spaceDto.getColor());
            space.setAccess_type(spaceDto.getAccess_type());
            space.setInitial_letter(spaceDto.getInitial_letter());

            Optional<User> byId1 = userRepo.findById(spaceDto.getOwner_id());
            if (byId1.isPresent()) {
                User user = byId1.get();
                space.setOwner_id(user);
                spaceRepo.save(space);
            }
            Optional<Icon> byId2 = iconRepo.findById(spaceDto.getIcon_id());
            if (byId2.isPresent()) {
                Icon icon = byId2.get();
                space.setIcon_id(icon);
                spaceRepo.save(space);
            }
            return new Result(true,"Space updated");
        }
        return new Result(false,"Space not found");
    }

    public Result deleteSpace(Integer id) {
        spaceRepo.deleteById(id);
        return new Result(true,"Space deleted");
    }

}