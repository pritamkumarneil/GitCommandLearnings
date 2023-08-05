package com.example.springTest2.DTO.RequestDto;

import com.example.springTest2.Model.PaymentMode;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderRequestDto {
    PaymentMode paymentMode;
}
