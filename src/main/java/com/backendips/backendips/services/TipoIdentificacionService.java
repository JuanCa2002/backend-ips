package com.backendips.backendips.services;

import com.backendips.backendips.models.TipoIdentificacion;
import com.backendips.backendips.repositories.TipoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoIdentificacionService {

    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    public List<TipoIdentificacion> getAllTipoIdentificacion(){
        return tipoIdentificacionRepository.findAll();
    }
}
