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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
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

@Entity
@Table(name = "tb_producto", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProductoId", query = "SELECT p FROM Producto p WHERE p.productoId = :productoId"),
    @NamedQuery(name = "Producto.findByCategoriaId", query = "SELECT p FROM Producto p WHERE p.categoriaId = :categoriaId"),
    @NamedQuery(name = "Producto.findByProveedorId", query = "SELECT p FROM Producto p WHERE p.proveedorId = :proveedorId"),
    @NamedQuery(name = "Producto.findByTitulo", query = "SELECT p FROM Producto p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Producto.findByModelo", query = "SELECT p FROM Producto p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByDescuento", query = "SELECT p FROM Producto p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Producto.findByStatus", query = "SELECT p FROM Producto p WHERE p.status = :status")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTO_ID", nullable = false)
    private Long productoId;
    
    @Basic(optional = false)
    @Column(name = "CATEGORIA_ID", nullable = false)
    private long categoriaId;
    
    @Basic(optional = false)
    @Column(name = "PROVEEDOR_ID", nullable = false)
    private long proveedorId;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String titulo;
    
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String image;
    
    @Lob
    @Column(length = 65535)
    private String images;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String nombre;
    
    @Column(length = 200)
    private String descripcion;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String marca;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String modelo;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private float precio;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private int cantidad;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12, scale = 3)
    private Float descuento;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    public Producto() {
    }

    public Producto(Long productoId) {
        this.productoId = productoId;
    }

    public Producto(Long productoId, long categoriaId, long proveedorId, String nombre, String titulo, String image,String images ,String descripcion,int cantidad ,Float descuento,String marca, String modelo, float precio,  boolean status) {
        this.productoId = productoId;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.titulo = titulo;
        this.image = image;
        this.images = images;
        this.descripcion = descripcion;
        this.cantidad = cantidad;      
        this.descuento = descuento;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.status = status;
    }

    public Producto(MProducto model_product) {
        this.productoId = model_product.getProductoId();
        this.categoriaId = model_product.getCategoriaId();
        this.proveedorId = model_product.getProveedorId();
        this.nombre = model_product.getNombre();
        this.titulo = model_product.getTitulo();
        this.image = model_product.getImage();
        this.images = model_product.getImages();
        this.descripcion = model_product.getDescripcion();
        this.cantidad = model_product.getCantidad();      
        this.descuento = model_product.getDescuento();
        this.marca = model_product.getMarca();
        this.modelo = model_product.getModelo();
        this.precio = model_product.getPrecio();
        this.status = model_product.isStatus();
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
