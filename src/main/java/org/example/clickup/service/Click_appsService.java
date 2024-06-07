package org.example.clickup.service;

import org.example.clickup.dto.Click_appsDto;
import org.example.clickup.model.Click_apps;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.repository.Click_appsRepo;
import org.example.clickup.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Click_appsService {

    @Autowired
    Click_appsRepo click_appsRepo;

    @Autowired
    IconRepo iconRepo;

    public List<Click_apps> getClick_apps() {
        return click_appsRepo.findAll();
    }

    public Click_apps getClick_apps(Integer id) {
        return click_appsRepo.findById(id).get();
    }

    public Result addClick_apps(Click_appsDto click_appsDto) {
        Click_apps clickApps = new Click_apps();
        clickApps.setName(click_appsDto.getName());
        Optional<Icon> byId = iconRepo.findById(click_appsDto.getIcon_id());
        if (byId.isPresent()) {
            Icon icon = byId.get();
            clickApps.setIcon_id(icon);

            click_appsRepo.save(clickApps);
            return new Result(true, "Successfully added Click Apps");
        }
        return new Result(false, "Icon not found");
    }

    public Result updateClick_apps(Click_appsDto click_appsDto, Integer id) {
        Optional<Click_apps> byId = click_appsRepo.findById(id);
        if (byId.isPresent()) {
            Click_apps clickApps = byId.get();
            clickApps.setName(click_appsDto.getName());
            Icon save = iconRepo.save(clickApps.getIcon_id());
            clickApps.setIcon_id(save);
            click_appsRepo.save(clickApps);
            return new Result(true, "Successfully updated Click Apps");
        }
        return new Result(false, "Icon not found");
    }

    public Result deleteClick_apps(Integer id) {
        click_appsRepo.deleteById(id);
        return new Result(true, "Successfully deleted Click Apps");
    }



}
