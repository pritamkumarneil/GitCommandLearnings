package com.example.springTest2.DTO.RequestDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequestDto {
    String username;
    String password;
    String emailId;
}
