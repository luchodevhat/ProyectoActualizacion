/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Proyecto.service;

import com.example.Proyecto.domain.Miembro;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public interface MiembroService {
    public List<Miembro> getMiembros();
    public Miembro getMiembro(Miembro miembro);
    public void save(Miembro miembro);
    public void delete(Miembro miembro);
}
