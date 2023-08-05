package com.example.springTest2.DTO.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {
    String username;
    String password;
    String emailId;

}
