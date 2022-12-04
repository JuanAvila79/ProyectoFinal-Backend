/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.notificacionConverter;
import com.backend.aldeamostore.model.MNotificacion;
import com.backend.aldeamostore.model.MProducto;
import com.backend.aldeamostore.repository.canalRepository;
import com.backend.aldeamostore.repository.notificacionRepository;
import com.backend.aldeamostore.repository.tipoNotificacionRepository;
import com.backend.aldeamostore.repository.userRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Service("NotificacionService")
public class notificacionService {

    @Autowired
    @Qualifier("NotificacionRepository")
    private notificacionRepository notificacionRepository;

    @Autowired
    @Qualifier("TipoNotificacionRepository")
    private tipoNotificacionRepository tipoNotificacionRepository;

    @Autowired
    @Qualifier("CanalRepository")
    private canalRepository canalRepository;

    @Autowired
    @Qualifier("UserRepository")
    private userRepository userRepository;

    @Autowired
    @Qualifier("NotificacionConverter")
    private notificacionConverter notificacionConverter;

        /**
     * Metodo listAll en la clase Services
     *
     * Este Metodo retorna un listado de todos los productos existentes en la
     * base de datos, este metodo se apoya en la clase ConverterList, la cual
     * recibe una lista de tipo Entidad y la Convierte a un Modelo lista de tipo
     * MProduct
     * @return 
     */
    public List<MNotificacion> listAll() {
        return notificacionConverter.converterList(notificacionRepository.findAll());
    }
    
    public boolean create( MNotificacion notificacion ){
        
        try {
             notificacion.setStatus(true);
             notificacionRepository.save(notificacionConverter.converterModelToEntity(notificacion));
             return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean existsTipoNotificacion( long tipo_notificacion_id ){
        return tipoNotificacionRepository.existsById(tipo_notificacion_id);
    }
    
    public boolean existCanal( long canal_id ){
        return canalRepository.existsById(canal_id);
    }
       
    public boolean existsUser( long user_id ){
        return userRepository.existsById(user_id);
    }
    
    
}
