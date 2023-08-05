package com.example.springTest2.Service;

import com.example.springTest2.DTO.RequestDto.UserRequestDto;
import com.example.springTest2.DTO.ResponseDto.UserResponseDto;
import com.example.springTest2.Model.User;
import com.example.springTest2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserResponseDto addUser(UserRequestDto userRequestDto){


        User user=User.builder()
                .emailId(userRequestDto.getEmailId())
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .build();
        userRepository.save(user);
        return UserResponseDto.builder()
                .emailId(user.getEmailId())
                .username(user.getUsername())
                .build();
    }
    public List<UserResponseDto> getAllUsers(){

        List<User> users = userRepository.findAll();
        List<UserResponseDto> ans= new ArrayList<>();
        for ( User user : users){
            UserResponseDto temp = UserResponseDto.builder()
                                    .username(user.getUsername())
                                    .emailId(user.getEmailId())
                                    .build();
            ans.add(temp);
        }
        return ans;
    }
}
