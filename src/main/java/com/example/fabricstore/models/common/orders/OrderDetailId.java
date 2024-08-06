package com.example.fabricstore.models.common.orders;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailId implements Serializable {
    private Long order;
    private Long fabric;

    // Default constructor
    public OrderDetailId() {
    }

    // Parameterized constructor
    public OrderDetailId(Long order, Long fabric) {
        this.order = order;
        this.fabric = fabric;
    }

    // Getters and setters
    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getFabric() {
        return fabric;
    }

    public void setFabric(Long fabric) {
        this.fabric = fabric;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return Objects.equals(order, that.order) && Objects.equals(fabric, that.fabric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, fabric);
    }
}
