package com.example.springTest2.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    PaymentMode paymentMode;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<Product> productList=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    User user;
}
