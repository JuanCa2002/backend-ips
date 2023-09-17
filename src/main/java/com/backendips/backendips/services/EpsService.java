package com.backendips.backendips.services;

import com.backendips.backendips.models.Eps;
import com.backendips.backendips.repositories.EpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpsService {

    @Autowired
    private EpsRepository epsRepository;

    public List<Eps> getAllEps(){
         return epsRepository.findAll();
    }
}
