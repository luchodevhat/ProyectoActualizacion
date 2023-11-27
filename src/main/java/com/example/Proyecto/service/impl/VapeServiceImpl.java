package com.example.Proyecto.service.impl;

import com.example.Proyecto.domain.Vape;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Proyecto.service.VapeService;
import com.example.Proyecto.dao.VapeDao;

@Service
public class VapeServiceImpl implements VapeService {

    @Autowired
    private VapeDao vapeDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Vape> getVapes(boolean activos) {
        var lista = vapeDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Vape getVape(Vape vape) {
        return vapeDao.findById(vape.getIdVape()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Vape vape) {
        vapeDao.save(vape);
    }

    @Override
    @Transactional
    public void delete(Vape vape) {
        vapeDao.delete(vape);
    }

 
}
