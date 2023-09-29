package com.crud.crud.service;

import com.crud.crud.models.UserModel;
import com.crud.crud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) iUserRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return iUserRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return iUserRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id){
        UserModel user = iUserRepository.findById(id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        return user;

    }

    public Boolean deleteUser(Long id){
        try {
            iUserRepository.deleteById(id);
            return true;

        }catch (Exception e){
            return false;
        }
    }



}
