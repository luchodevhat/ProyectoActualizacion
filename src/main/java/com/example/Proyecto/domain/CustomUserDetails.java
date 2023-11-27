/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyecto.domain;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;



public class CustomUserDetails extends User {
    
    private final String rutaImagen;
    
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String rutaImagen) {
        super(username, password, authorities);
        this.rutaImagen = rutaImagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}
