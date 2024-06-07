package org.example.clickup.service;

import org.example.clickup.dto.Space_click_appsDto;
import org.example.clickup.model.Click_apps;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.Space_click_apps;
import org.example.clickup.repository.Click_appsRepo;
import org.example.clickup.repository.SpaceRepo;
import org.example.clickup.repository.Space_click_appsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_click_appsService {

    @Autowired
    Space_click_appsRepo space_click_appsRepo;

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    Click_appsRepo click_appsRepo;

    public List<Space_click_apps> getSpace_click_apps() {
        return space_click_appsRepo.findAll();
    }

    public Space_click_apps getSpace_click_apps(Integer id) {
        return space_click_appsRepo.findById(id).get();
    }

    public Result createSpace_click_apps(Space_click_appsDto space_click_appsDto) {
        Space_click_apps spaceClickApps = new Space_click_apps();
        Optional<Space> byId = spaceRepo.findById(space_click_appsDto.getSpace_id());
        if (byId.isPresent()) {
            Space space = byId.get();
            spaceClickApps.setSpace_id(space);
            space_click_appsRepo.save(spaceClickApps);
        }
        Optional<Click_apps> byId1 = click_appsRepo.findById(space_click_appsDto.getClick_apps_id());
        if (byId1.isPresent()) {
            Click_apps clickApps = byId1.get();
            spaceClickApps.setClick_apps_id(clickApps);
            space_click_appsRepo.save(spaceClickApps);
        }
        return new Result(true,"Successfully created space click apps");
    }

    public Result update(Space_click_appsDto space_click_appsDto, Integer id) {
        Optional<Space_click_apps> byId = space_click_appsRepo.findById(id);
        if (byId.isPresent()) {
            Space_click_apps spaceClickApps = byId.get();
            Optional<Space> byId1 = spaceRepo.findById(space_click_appsDto.getSpace_id());
            if (byId1.isPresent()) {
                Space space = byId1.get();
                spaceClickApps.setSpace_id(space);
                space_click_appsRepo.save(spaceClickApps);
            }
            Optional<Click_apps> byId2 = click_appsRepo.findById(space_click_appsDto.getClick_apps_id());
            if (byId2.isPresent()) {
                Click_apps clickApps = byId2.get();
                spaceClickApps.setClick_apps_id(clickApps);
                space_click_appsRepo.save(spaceClickApps);
            }
            return new Result(true,"Successfully updated space click apps");
        }
        return new Result(false,"Not found space click apps");
    }

    public Result delete(Integer id) {
        space_click_appsRepo.deleteById(id);
        return new Result(true,"Successfully deleted space click apps");
    }

}
