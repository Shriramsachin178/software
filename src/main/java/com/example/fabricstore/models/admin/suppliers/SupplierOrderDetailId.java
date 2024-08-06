package com.example.fabricstore.models.admin.suppliers;

import java.io.Serializable;
import java.util.Objects;

public class SupplierOrderDetailId implements Serializable {

    private Long supplierOrder;
    private Long fabric;

    // Default constructor
    public SupplierOrderDetailId() {}

    // Parameterized constructor
    public SupplierOrderDetailId(Long supplierOrder, Long fabric) {
        this.supplierOrder = supplierOrder;
        this.fabric = fabric;
    }

    // Getters and setters
    public Long getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(Long supplierOrder) {
        this.supplierOrder = supplierOrder;
    }

    public Long getFabric() {
        return fabric;
    }

    public void setFabric(Long fabric) {
        this.fabric = fabric;
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierOrder, fabric);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrderDetailId that = (SupplierOrderDetailId) o;
        return Objects.equals(supplierOrder, that.supplierOrder) &&
               Objects.equals(fabric, that.fabric);
    }
}
