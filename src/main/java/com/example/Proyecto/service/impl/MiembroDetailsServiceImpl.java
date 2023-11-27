/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyecto.service.impl;

import com.example.Proyecto.domain.Miembro;
import com.example.Proyecto.dao.MiembroDao;
import com.example.Proyecto.domain.CustomUserDetails;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Proyecto.service.MiembroDetailsService;

@Service("userDetailsService")
public class MiembroDetailsServiceImpl implements MiembroDetailsService, UserDetailsService {
    
    
    @Autowired
    private MiembroDao miembroDao;
    
    

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Miembro miembro = miembroDao.findByUsername(username);
        if (miembro == null) throw new UsernameNotFoundException(username);
        
        System.out.println(miembro.getUsername());
        
        List<GrantedAuthority> roles = new ArrayList<>();
        
//        for (Rol rol : miembro.getRoles()) {
//            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
//        }
        
        return new CustomUserDetails(miembro.getUsername(), miembro.getContrasena(), roles, miembro.getRutaImagen());
        
    }
}
