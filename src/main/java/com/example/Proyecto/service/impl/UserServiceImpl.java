/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyecto.service.impl;

import com.example.Proyecto.domain.Miembro;
import com.example.Proyecto.service.MiembroService;
import com.example.Proyecto.dao.MiembroDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements MiembroService {

    @Autowired
    private MiembroDao miembroDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Miembro> getMiembros() {
        List<Miembro> lista = miembroDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Miembro getMiembro(Miembro miembro) {
        return miembroDao.findById(miembro.getIdMiembro()).orElse(null);
    }

    @Override
     @Transactional
    public void save(Miembro miembro) {
        miembroDao.save(miembro);
    }

   
    @Override
     @Transactional
    public void delete(Miembro miembro) {
        miembroDao.delete(miembro);
    }
    
}
