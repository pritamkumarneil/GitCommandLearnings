package com.example.springTest2.Controller;

import com.example.springTest2.DTO.RequestDto.UserRequestDto;
import com.example.springTest2.DTO.ResponseDto.UserResponseDto;
import com.example.springTest2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto user=userService.addUser(userRequestDto);
        return new ResponseEntity(user, HttpStatus.CREATED);

    }
}
