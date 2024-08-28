package com.example.indentity_service.service;

import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.dto.request.UserUpdateRequest;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.exception.AppException;
import com.example.indentity_service.exception.ErrorCode;
import com.example.indentity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){

        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.Error_Existed);
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return  userRepository.save(user);

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userid){
        return userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException(ErrorCode.Error_Uncategorized.toString()));
    }

    public User updateUser(String userId, UserUpdateRequest request){

        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return  userRepository.save(user);

    }

    public void deleteUser( String userId ){
        userRepository.deleteById(userId);
    }

}
