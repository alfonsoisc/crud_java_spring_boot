package com.crud.crud.controller;

import com.crud.crud.models.UserModel;
import com.crud.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){

        return this.userService.saveUser(user);
    }

    @GetMapping
    public ArrayList<UserModel> getUsers(){

        return this.userService.getUsers();
    }


    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String userById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);

        if (ok){
            return "User with id" + id + "Delete!";

        }else {
            return "Error ";
        }
    }






}
