/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="miembro")
public class Miembro {
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_miembro")
    private long idMiembro;
    
    private String identificacion;
    private int edad;
    private String nombre;
    private String apellidos;
    private String username;
    private String telefono;
    private String correo;
    private String rutaImagen;
    private boolean activo;
    private String contrasena;

    
    public Miembro(String identificacion, int edad, String nombre, String apellidos, String telefono, String correo, String rutaImagen, boolean activo, String constrasena) {
        this.identificacion = identificacion;
        this.edad = edad;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.contrasena = constrasena;
    }

    public Miembro() {}
}
