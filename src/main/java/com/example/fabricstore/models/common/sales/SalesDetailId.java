package com.example.fabricstore.models.common.sales;

import java.io.Serializable;
import java.util.Objects;

public class SalesDetailId implements Serializable {

    private Long sale;
    private Long fabric;

    public SalesDetailId() {
    }

    public SalesDetailId(Long sale, Long fabric) {
        this.sale = sale;
        this.fabric = fabric;
    }

    // Getters and Setters

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public Long getFabric() {
        return fabric;
    }

    public void setFabric(Long fabric) {
        this.fabric = fabric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesDetailId that = (SalesDetailId) o;
        return Objects.equals(sale, that.sale) && Objects.equals(fabric, that.fabric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sale, fabric);
    }
}
