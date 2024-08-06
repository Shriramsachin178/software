package com.example.fabricstore.models.admin.suppliers;

import com.example.fabricstore.models.common.inventory.Fabric;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(SupplierOrderDetailId.class)
public class SupplierOrderDetail {

    @Id
    @ManyToOne
    private SupplierOrder supplierOrder;

    @Id
    @ManyToOne
    private Fabric fabric;

    private Integer quantity;
    private Double price;
    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
    }
    public void setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
    }
    public Fabric getFabric() {
        return fabric;
    }
    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public SupplierOrderDetail() {
    }
    public SupplierOrderDetail(SupplierOrder supplierOrder, Fabric fabric, Integer quantity, Double price) {
        this.supplierOrder = supplierOrder;
        this.fabric = fabric;
        this.quantity = quantity;
        this.price = price;
    }

    

    
}
