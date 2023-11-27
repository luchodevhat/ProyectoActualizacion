/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyecto.controller;

import com.example.Proyecto.domain.Miembro;
import com.example.Proyecto.service.MiembroService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/miembros")
@Slf4j
public class MiembroController {
    
    @Autowired
    private MiembroService miembroService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Miembro> miembros = miembroService.getMiembros();
        model.addAttribute("miembros", miembros);
        model.addAttribute("totalMiembros", miembros.size());
        return "/miembro/listar";
        
    }

    @GetMapping("/nuevo")
    public String nuevo(Miembro miembro) {
        return "miembro/nuevo";

    }

    @PostMapping("/guardar")
    public String guardar(Miembro miembro,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        BCryptPasswordEncoder codigo = new BCryptPasswordEncoder();
        miembro.setContrasena(codigo.encode(miembro.getContrasena()));
        if (!imagenFile.isEmpty()) {
            miembroService.save(miembro);
//            vape.setRutaImagen()  Necesita que le pase un parámetros con el cual settear el atributo imagen, falta el guardado de imagenes con firebase;
                    
        }
        miembroService.save(miembro);
        return "redirect:/miembros/listar";
    }
    
    @PostMapping("/registrarse")
    public String registrarse(Miembro miembro,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        
        BCryptPasswordEncoder codigo = new BCryptPasswordEncoder();
        miembro.setContrasena(codigo.encode(miembro.getContrasena()));
        if (!imagenFile.isEmpty()) {
            miembroService.save(miembro);
//            vape.setRutaImagen()  Necesita que le pase un parámetros con el cual settear el atributo imagen, falta el guardado de imagenes con firebase;
                    
        }
        miembroService.save(miembro);
        return "redirect:/";
    }
    
    

    @GetMapping("/eliminar/{idMiembro}")
    public String eliminar(Miembro miembro) {
        miembroService.delete(miembro);
        return "redirect:/miembros/listar";
    }

    @GetMapping("/modificar/{idMiembro}")
    public String modificar(Miembro miembro, Model model) {
        miembro = miembroService.getMiembro(miembro);
        model.addAttribute("miembro", miembro);
        return "/miembro/modifica";
    }
}
