package com.example.springTest2.Controller;

import com.example.springTest2.DTO.RequestDto.ProductRequestDto;
import com.example.springTest2.DTO.ResponseDto.ProductResponseDto;
import com.example.springTest2.Model.Product;
import com.example.springTest2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto product=productService.addProduct(productRequestDto);
        return new ResponseEntity( product, HttpStatus.CREATED);
    }
    @GetMapping("max-priced")
    public ResponseEntity<ProductResponseDto> getMaxPricedProduct(){
        ProductResponseDto product= productService.getMaxPriceProduct();
        return new ResponseEntity<>(product,HttpStatus.FOUND);
    }
}
