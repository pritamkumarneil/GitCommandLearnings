package com.example.springTest2.DTO.RequestDto;

import com.example.springTest2.Model.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRequestDto {
    String name;
    Category category;

    int price;
}
