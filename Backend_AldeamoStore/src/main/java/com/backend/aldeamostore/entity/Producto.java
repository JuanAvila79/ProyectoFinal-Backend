/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import com.backend.aldeamostore.model.MProducto;
import java.io.Serializable;
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
@Table(name = "tb_producto", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProductoId", query = "SELECT p FROM Producto p WHERE p.productoId = :productoId"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByDescuento", query = "SELECT p FROM Producto p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Producto.findByModelo", query = "SELECT p FROM Producto p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByStatus", query = "SELECT p FROM Producto p WHERE p.status = :status"),
    @NamedQuery(name = "Producto.findByTitulo", query = "SELECT p FROM Producto p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Producto.findByCategoriaId", query = "SELECT p FROM Producto p WHERE p.categoriaId = :categoriaId"),
    @NamedQuery(name = "Producto.findByProveedorId", query = "SELECT p FROM Producto p WHERE p.proveedorId = :proveedorId")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "producto_id", nullable = false)
    private Long productoId;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private int cantidad;
    
    @Column(length = 200)
    private String descripcion;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12, scale = 0)
    private Float descuento;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String marca;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String modelo;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String nombre;
    
    @Column(precision = 12, scale = 0)
    private Float precio;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String titulo;
    
    @Basic(optional = false)
    @Column(name = "categoria_id", nullable = false)
    private long categoriaId;
    
    @Basic(optional = false)
    @Column(name = "proveedor_id", nullable = false)
    private int proveedorId;

    public Producto() {
    }

    public Producto(Long productoId) {
        this.productoId = productoId;
    }

    public Producto(Long productoId, int cantidad, String marca, String modelo, String nombre, boolean status, String titulo, long categoriaId, int proveedorId) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.status = status;
        this.titulo = titulo;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
    }

    public Producto(MProducto model_product) {
       this.productoId = model_product.getProductoId();
        this.cantidad = model_product.getCantidad();
        this.marca = model_product.getMarca();
        this.modelo = model_product.getModelo();
        this.nombre = model_product.getNombre();
        this.status = model_product.isStatus();
        this.titulo = model_product.getTitulo();
        this.categoriaId = model_product.getCategoriaId();
        this.proveedorId = model_product.getProveedorId();
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoId != null ? productoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.productoId == null && other.productoId != null) || (this.productoId != null && !this.productoId.equals(other.productoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.Producto[ productoId=" + productoId + " ]";
    }
    
}
