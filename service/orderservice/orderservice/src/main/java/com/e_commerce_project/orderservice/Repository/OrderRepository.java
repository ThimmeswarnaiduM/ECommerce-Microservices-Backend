package com.e_commerce_project.orderservice.Repository;

import com.e_commerce_project.orderservice.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
