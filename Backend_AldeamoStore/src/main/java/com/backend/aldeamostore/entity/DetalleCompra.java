/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import com.backend.aldeamostore.model.MDetalleCompra;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Data
@Getter
@Setter

@Entity
@Table(name = "tb_detalle_compra", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d"),
    @NamedQuery(name = "DetalleCompra.findByIdDetalleCompra", query = "SELECT d FROM DetalleCompra d WHERE d.idDetalleCompra = :idDetalleCompra"),
    @NamedQuery(name = "DetalleCompra.findByCantidad", query = "SELECT d FROM DetalleCompra d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleCompra.findByDescuento", query = "SELECT d FROM DetalleCompra d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleCompra.findByIva", query = "SELECT d FROM DetalleCompra d WHERE d.iva = :iva"),
    @NamedQuery(name = "DetalleCompra.findByMonto", query = "SELECT d FROM DetalleCompra d WHERE d.monto = :monto"),
    @NamedQuery(name = "DetalleCompra.findByTotal", query = "SELECT d FROM DetalleCompra d WHERE d.total = :total"),
    @NamedQuery(name = "DetalleCompra.findByCompraId", query = "SELECT d FROM DetalleCompra d WHERE d.compraId = :compraId"),
    @NamedQuery(name = "DetalleCompra.findByProductoId", query = "SELECT d FROM DetalleCompra d WHERE d.productoId = :productoId")})
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_compra", nullable = false)
    private Long idDetalleCompra;

    @Basic(optional = false)
    @Column(nullable = false)
    private int cantidad;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal descuento;

    @Basic(optional = false)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal iva;

    @Basic(optional = false)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @Basic(optional = false)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @Basic(optional = false)
    @Column(name = "compra_id", nullable = false)
    private long compraId;

    @Basic(optional = false)
    @Column(name = "producto_id", nullable = false)
    private long productoId;

    public DetalleCompra() {
    }

    public DetalleCompra(Long idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public DetalleCompra(Long idDetalleCompra, int cantidad, BigDecimal descuento, BigDecimal iva, BigDecimal monto, BigDecimal total, long compraId, long productoId) {
        this.idDetalleCompra = idDetalleCompra;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.iva = iva;
        this.monto = monto;
        this.total = total;
        this.compraId = compraId;
        this.productoId = productoId;
    }

    public DetalleCompra(MDetalleCompra detalleCompra) {
        this.idDetalleCompra = detalleCompra.getIdDetalleCompra();
        this.compraId = detalleCompra.getCompraId();
        this.productoId = detalleCompra.getProductoId();
        this.cantidad = detalleCompra.getCantidad();
        this.monto = detalleCompra.getMonto();
        this.iva = detalleCompra.getIva();
        this.descuento = detalleCompra.getDescuento();
        this.total = detalleCompra.getTotal();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCompra != null ? idDetalleCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.idDetalleCompra == null && other.idDetalleCompra != null) || (this.idDetalleCompra != null && !this.idDetalleCompra.equals(other.idDetalleCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.DetalleCompra[ idDetalleCompra=" + idDetalleCompra + " ]";
    }

}
