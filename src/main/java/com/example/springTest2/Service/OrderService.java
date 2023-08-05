package com.example.springTest2.Service;

import com.example.springTest2.DTO.RequestDto.OrderRequestDto;
import com.example.springTest2.DTO.ResponseDto.ProductResponseDto;
import com.example.springTest2.Model.Order;
import com.example.springTest2.Model.Product;
import com.example.springTest2.Repository.OrderRepository;
import com.example.springTest2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    public ProductResponseDto getMostOrderProduct() {

        Map<Product,Integer> productMap=new HashMap<>();

        List<Order> orders=orderRepository.findAll();
        for(Order order: orders){
            for(Product product1: order.getProductList()){
                productMap.put(product1,productMap.getOrDefault(product1,1)+1);
            }
        }
        Product product=null;
        int freq=0;
        for(Product product1: productMap.keySet()){
            if(productMap.get(product1)>freq){
                freq=productMap.get(product1);
                product=product1;
            }
        }

        return ProductResponseDto.builder()
                .category(product.getCategory())
                .name(product.getName())
                .build();
    }

    public String createOrder(OrderRequestDto orderRequestDto){
        List<Product> products=productRepository.findAll();
        List<Product> productsA=new ArrayList<>();
        for(Product product : products){
            if(product.getName().charAt(0)=='A'){
                productsA.add(product);
            }
        }
        Order order=Order.builder()
                .paymentMode(orderRequestDto.getPaymentMode())
                .build();
        for(Product product: productsA){
            order.getProductList().add(product);
        }
        orderRepository.save(order);
        return "Order Place Successfully";
    }
}
