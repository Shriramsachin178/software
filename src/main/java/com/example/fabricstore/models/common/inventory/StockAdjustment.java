package com.example.fabricstore.models.common.inventory;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_adjustments")
public class StockAdjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabric_id", nullable = false)
    private Fabric fabric;

    private Date adjustmentDate;

    public StockAdjustment() {
    }

    private int quantityAdjusted;

    private String reason;

    public Long getId() {
        return id;
    }

    public StockAdjustment(Long id, Fabric fabric, Date adjustmentDate, int quantityAdjusted, String reason) {
        this.id = id;
        this.fabric = fabric;
        this.adjustmentDate = adjustmentDate;
        this.quantityAdjusted = quantityAdjusted;
        this.reason = reason;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public Date getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(Date adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    public int getQuantityAdjusted() {
        return quantityAdjusted;
    }

    public void setQuantityAdjusted(int quantityAdjusted) {
        this.quantityAdjusted = quantityAdjusted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
