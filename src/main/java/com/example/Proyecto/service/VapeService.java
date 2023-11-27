package com.example.Proyecto.service;

import com.example.Proyecto.domain.Vape;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface VapeService {
    
    // Se obtiene un listado de categorias en un List
    public List<Vape> getVapes(boolean activos);
    
   // Se obtiene un Vape, a partir del id de un categoria
    public Vape getVape(Vape vape);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Vape vape);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Vape vape);
}

