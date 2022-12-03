/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Compra;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Juan Carlos Avila Meza
 */
@Data
@Getter
@Setter

public class MCompra {
    private Long compraId;
    private long userId;
    private Date fecha;
    private boolean status;
    private BigDecimal total;

    public MCompra() {
    }

    public MCompra(Long compraId, long userId, Date fecha, boolean status, BigDecimal total) {
        this.compraId = compraId;
        this.userId = userId;
        this.fecha = fecha;
        this.status = status;
        this.total = total;
    }

    public MCompra(Compra compra) {
        this.compraId = compra.getCompraId();
        this.userId = compra.getUserId();
        this.fecha = compra.getFecha();
        this.total = compra.getTotal();
        this.status = compra.isStatus();

    }

}
