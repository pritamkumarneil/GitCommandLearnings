package com.example.springTest2.DTO.ResponseDto;

import com.example.springTest2.Model.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDto {
    String name;
    Category category;
}
