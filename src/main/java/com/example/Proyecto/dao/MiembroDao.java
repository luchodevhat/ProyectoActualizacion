/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Proyecto.dao;

import com.example.Proyecto.domain.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroDao extends JpaRepository <Miembro, Long> {
    Miembro findByUsername(String username);
}
