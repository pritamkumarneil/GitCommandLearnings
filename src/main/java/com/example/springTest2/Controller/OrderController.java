package com.example.springTest2.Controller;

import com.example.springTest2.DTO.RequestDto.OrderRequestDto;
import com.example.springTest2.DTO.ResponseDto.OrderResponseDto;
import com.example.springTest2.DTO.ResponseDto.ProductResponseDto;
import com.example.springTest2.Service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("create")
    public ResponseEntity createOrder(OrderRequestDto orderRequestDto){
        String response= orderService.createOrder(orderRequestDto);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("get-ordered-porduct")
    public ResponseEntity getMostOrderProduct(){
        ProductResponseDto product=orderService.getMostOrderProduct();
        return new ResponseEntity(product,HttpStatus.FOUND);
    }
    @GetMapping("get-all-products")
    public ResponseEntity getAllOrders(){
        List<OrderResponseDto> orders = orderService.getAllOrders();
        return new ResponseEntity(orders,HttpStatus.FOUND);
    }
}
