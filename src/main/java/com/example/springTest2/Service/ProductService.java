package com.example.springTest2.Service;

import com.example.springTest2.DTO.RequestDto.ProductRequestDto;
import com.example.springTest2.DTO.ResponseDto.ProductResponseDto;
import com.example.springTest2.Model.Product;
import com.example.springTest2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto){

        Product product= Product.builder()
                .name(productRequestDto.getName())
                .category(productRequestDto.getCategory())
                .price(productRequestDto.getPrice())
                .build();
        productRepository.save(product);
        return ProductResponseDto.builder()
                .name(product.getName())
                .category(product.getCategory())
                .build();
    }

    public ProductResponseDto getMaxPriceProduct() {
        List<Product> products= productRepository.findAll();
        Product product=null;
        int price=0;
        for(Product product1 : products){
            if(price<product1.getPrice()){
                price=product1.getPrice();
                product=product1;
            }
        }

        return ProductResponseDto.builder()
                .name(product.getName())
                .category(product.getCategory())
                .build();
    }
}
