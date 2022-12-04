/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.productoConverter;
import com.backend.aldeamostore.entity.Categoria;
import com.backend.aldeamostore.entity.Producto;
import com.backend.aldeamostore.model.MProducto;
import com.backend.aldeamostore.repository.categotiaRepository;
import com.backend.aldeamostore.repository.productoRepository;
import com.backend.aldeamostore.repository.proveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Service("ProductoService")
public class productoService {

    @Autowired
    @Qualifier("ProductoRepository")
    private productoRepository productRepository;

    @Autowired
    @Qualifier("CategoriaRepository")
    private categotiaRepository categotiaRepository;

    @Autowired
    @Qualifier("ProveedorRepository")
    private proveedorRepository proveedorRepository;

    @Autowired
    @Qualifier("ProductoConverter")
    private productoConverter productConverter;

    /**
     * Metodo listAll en la clase Services
     *
     * Este Metodo retorna un listado de todos los productos existentes en la
     * base de datos, este metodo se apoya en la clase ConverterList, la cual
     * recibe una lista de tipo Entidad y la Convierte a un Modelo lista de tipo
     * MProduct
     */
    public List<MProducto> listAll() {
        return productConverter.converterList(productRepository.findAll());
    }

    /**
     * Metodo Create en la clase Services
     *
     * Este metodo permite la creación de los Productos en la base de datos
     * siempre y cuando los datos ingresados pasen las validaciones previas de
     * los campos en la clase Controller, este metodo recibe un modelo de tipo
     * MProducto y se apoya en la clase converterModelToEntity para convertir
     * este modelo en una Entidad y poder persistirla en la base de datos.
     */
    public boolean create(MProducto producto) {
        try {
            Categoria category = categotiaRepository.findById(producto.getCategoriaId()).get();
            producto.setCategory(category.getNombre());
            producto.setStatus(true);
            productRepository.save(productConverter.converterModelToEntity(producto));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Metodo Update en la clase Services
     *
     * Este metodo permite la actualización de un producto en la base de datos
     * siempre y cuando los datos ingresados pasen las validaciones previas de
     * los campos en la clase Controller, este metodo recibe un modelo de tipo
     * MProduct, y verfica si existe el id del producto antes de persistirlo,
     * luego se apoya en la clase converterModelToEntity para convertir este
     * modelo en una Entidad y poder hacer la persistencia en la base de datos.
     */
    public MProducto update(MProducto producto) {
        try {
            if (!productRepository.existsById(producto.getId())) {
                Producto update_producto = productRepository.findById(producto.getId()).get();
                Categoria categoria = categotiaRepository.findById(producto.getCategoriaId()).get();
                update_producto.setId(producto.getId());
                update_producto.setCategoriaId(producto.getCategoriaId());
                update_producto.setProveedorId(producto.getProveedorId());
                update_producto.setTitle(producto.getTitle());
                update_producto.setPrice(producto.getPrice());
                update_producto.setDescription(producto.getDescription());
                update_producto.setCategory(categoria.getNombre());
                update_producto.setImage(producto.getImage());
                update_producto.setImages(producto.getImages());
                update_producto.setCount(producto.getCount());
                update_producto.setRate(producto.getRate());
                update_producto.setDescuento(producto.getDescuento());
                update_producto.setStatus(producto.isStatus());
                productRepository.save(update_producto);
                return producto = productConverter.converterEntityToModel(update_producto);
            } else {
                return null; //  productConverter.converterEntityToModel( productRepository.findById(producto.getProductoId())) ;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Metodo Delete en la clase Services
     *
     * Este metodo recibe un parametro Id de tipo Long, y verifica que el Id
     * recibido como parametro existe en la base de datos. luego procede con la
     * eliminacion del registro en la base de datos
     */
    public boolean delete(Long id) {
        if (!productRepository.findById(id).isEmpty()) {
            productRepository.deleteById(id);
        }
        return true;
    }

    /**
     * Metodo findProducto en la clase Services
     *
     * Este metodo recibe un parametro Id de tipo Long, y verifica que el Id del
     * producto recibido como parametro existe en la base de datos.
     */
    public boolean findProducto(Long id) {
        return productRepository.existsById(id);
    }

    /**
     * Metodo findCategoria en la clase Services
     *
     * Este metodo recibe un Modelo de la case MProducto, y permite varificar si
     * existe una Categoria en la base de datos.
     */
    public boolean findCategoria(MProducto producto) {
        return categotiaRepository.existsById(producto.getCategoriaId());
    }

    /**
     * Metodo findProveedor en la clase Services
     *
     * Este metodo recibe un Modelo de la case MProducto, y permite varificar si
     * existe un Proveedor en la base de datos.
     */
    public boolean findProveedor(MProducto producto) {
        return proveedorRepository.existsById(producto.getProveedorId());
    }

}
