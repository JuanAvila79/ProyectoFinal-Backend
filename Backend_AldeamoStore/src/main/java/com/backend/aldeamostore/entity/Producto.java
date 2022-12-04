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
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.Id = :Id"),
    @NamedQuery(name = "Producto.findByCategoriaId", query = "SELECT p FROM Producto p WHERE p.categoriaId = :categoriaId"),
    @NamedQuery(name = "Producto.findByProveedorId", query = "SELECT p FROM Producto p WHERE p.proveedorId = :proveedorId"),
    @NamedQuery(name = "Producto.findByTitle", query = "SELECT p FROM Producto p WHERE p.title = :title"),
    @NamedQuery(name = "Producto.findByCategory", query = "SELECT p FROM Producto p WHERE p.category = :category"),
    @NamedQuery(name = "Producto.findByDescription", query = "SELECT p FROM Producto p WHERE p.description = :description"),
    @NamedQuery(name = "Producto.findByPrice", query = "SELECT p FROM Producto p WHERE p.price = :price"),
    @NamedQuery(name = "Producto.findByCount", query = "SELECT p FROM Producto p WHERE p.count = :count"),
    @NamedQuery(name = "Producto.findByDescuento", query = "SELECT p FROM Producto p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Producto.findByStatus", query = "SELECT p FROM Producto p WHERE p.status = :status")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long Id;

    @Basic(optional = false)
    @Column(name = "CATEGORIA_ID", nullable = false)
    private Long categoriaId;

    @Basic(optional = false)
    @Column(name = "PROVEEDOR_ID", nullable = false)
    private Long proveedorId;

    @Basic(optional = false)
    @Column(name = "titulo", nullable = false, length = 200)
    private String title;

    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private float price;

    @Basic(optional = false)
    @Lob
    @Column(name = "description", nullable = false, length = 65535)
    private String description;

    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String category;

    @Basic(optional = false)
    @Lob
    @Column(name = "image", nullable = false, length = 65535)
    private String image;

    @Lob
    @Column(name = "images", length = 65535)
    private String images;

    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int count;

    @Basic(optional = false)
    @Column(name = "valoracion", nullable = false)
    private float rate;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12, scale = 3)
    private Float descuento;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    public Producto() {
    }

    public Producto(Long Id) {
        this.Id = Id;
    }

    public Producto(Long Id, Long categoriaId, Long proveedorId, String title, float price, String description, String category, String image, String images, int count, float rate, Float descuento, boolean status) {
        this.Id = Id;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.images = images;
        this.count = count;
        this.rate = rate;
        this.descuento = descuento;
        this.status = status;
    }

    public Producto(MProducto producto) {
        this.Id = producto.getId();
        this.categoriaId = producto.getCategoriaId();
        this.proveedorId = producto.getProveedorId();
        this.title = producto.getTitle();
        this.price = producto.getPrice();
        this.description = producto.getDescription();
        this.category = producto.getCategory();
        this.image = producto.getImage();
        this.images = producto.getImages();
        this.count = producto.getCount();
        this.rate = producto.getRate();
        this.descuento = producto.getDescuento();
        this.status = producto.isStatus();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.Producto[ productoId=" + Id + " ]";
    }

}
