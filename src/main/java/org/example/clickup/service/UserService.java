package org.example.clickup.service;

import org.example.clickup.dto.UserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).get();
    }

    public Result addUser(UserDto userDto) {
        User user = new User();
        user.setAvatarId(userDto.getAvatarId());
        user.setEmail(userDto.getEmail());
        user.setColor(userDto.getColor());
        user.setPassword(userDto.getPassword());
        user.setFull_name(userDto.getFull_name());
        user.setInitial_letter(userDto.getInitial_letter());
        userRepo.save(user);
        return new Result(true,"Successfully added user");
    }

    public Result updateUser(UserDto userDto, Integer id) {
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setAvatarId(userDto.getAvatarId());
            user.setEmail(userDto.getEmail());
            user.setColor(userDto.getColor());
            user.setPassword(userDto.getPassword());
            user.setFull_name(userDto.getFull_name());
            user.setInitial_letter(userDto.getInitial_letter());
            userRepo.save(user);
            return new Result(true,"Successfully updated user");
        }
        return new Result(false,"User not found");
    }

    public Result deleteUser(Integer id) {
        userRepo.deleteById(id);
        return new Result(true,"Successfully deleted user");
    }

}
