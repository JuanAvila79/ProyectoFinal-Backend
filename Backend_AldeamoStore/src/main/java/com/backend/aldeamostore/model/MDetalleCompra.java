/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.DetalleCompra;
import java.math.BigDecimal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Data
@Getter
@Setter

public class MDetalleCompra {

    private Long idDetalleCompra;
    private long compraId;
    private long productoId;
    private int cantidad;
    private BigDecimal monto;
    private BigDecimal iva;
    private BigDecimal descuento;
    private BigDecimal total;

    public MDetalleCompra() {
    }

    public MDetalleCompra(Long idDetalleCompra, long compraId, long productoId, int cantidad, BigDecimal monto, BigDecimal iva, BigDecimal descuento, BigDecimal total) {
        this.idDetalleCompra = idDetalleCompra;
        this.compraId = compraId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.monto = monto;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
    }

    public MDetalleCompra(DetalleCompra detalleCompra) {
        this.idDetalleCompra = detalleCompra.getIdDetalleCompra();
        this.compraId = detalleCompra.getCompraId();
        this.productoId = detalleCompra.getProductoId();
        this.cantidad = detalleCompra.getCantidad();
        this.monto = detalleCompra.getMonto();
        this.iva = detalleCompra.getIva();
        this.descuento = detalleCompra.getDescuento();
        this.total = detalleCompra.getTotal();
    }

}
