package com.example.fabricstore.repositories.common.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.common.orders.OrderDetail;
import com.example.fabricstore.models.common.orders.OrderDetailId;

import java.util.Optional;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailId> {

    Optional<OrderDetail> findByOrderIdAndFabricId(Long orderId, Long fabricId);
}
