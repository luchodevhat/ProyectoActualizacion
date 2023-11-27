
package com.example.Proyecto.dao;

import com.example.Proyecto.domain.Vape;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VapeDao extends JpaRepository <Vape, Long> {
    
}
