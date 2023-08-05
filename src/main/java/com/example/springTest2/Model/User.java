package com.example.springTest2.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.convert.DataSizeUnit;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String username;
    String emailId;
    String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Order> orderList=new ArrayList<>();

}
