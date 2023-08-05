package com.example.springTest2.Repository;

import com.example.springTest2.Model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "SELECT * FROM ORDER", nativeQuery = true)
    public List<Order> findAll();
}
