package com.e_commerce_project.orderservice.Repository;

import com.e_commerce_project.orderservice.Entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRespository extends JpaRepository<OrderLine, Long> {
}
