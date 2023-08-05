package com.example.springTest2.DTO.ResponseDto;

import com.example.springTest2.Model.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    public int orderId;
    public PaymentMode paymentMode;
}
