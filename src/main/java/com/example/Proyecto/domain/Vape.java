package com.example.Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "vape")

/*Serializacoin va a almacenar datos de la bd*/
public class Vape implements Serializable {

    private static final long serialVersionUID = 1L;
    /*para poder hacer el ciclo de la sumatoria de la categoria de bd*/

    @Id
    /*id es la llave de la tabla categoria*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vape")

    private long idVape;
    private String nombre;
    private String rutaImagen;
    private boolean activo;
    private int valor;

    public Vape() {

    }

    public Vape(long idVape, String nombre, String rutaImagen, boolean activo, int valor) {
        this.idVape = idVape;
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.valor = valor;
    }

}
