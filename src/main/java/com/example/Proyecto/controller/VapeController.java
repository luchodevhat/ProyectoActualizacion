/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.Proyecto.controller;

import com.example.Proyecto.domain.Vape;
import com.example.Proyecto.service.VapeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/vapes")
@Slf4j
public class VapeController {
    
    @Autowired
    private VapeService vapeService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Vape> vapes = vapeService.getVapes(true);
        model.addAttribute("vapes", vapes);
        model.addAttribute("size", vapes.size());
        return "/vape/listar";
    }
    
    @GetMapping("/nuevo")
    public String newElement(Vape vape) {
        return "/vape/nuevo";
    }
    
    @PostMapping("/guardar")
    public String save(Vape vape,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
//        if (!imagenFile.isEmpty()) {
//            vapeService.save(vape);
//            vape.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "vape", 
//                            vape.getIdVape()));
//        }
        vapeService.save(vape);
        return "redirect:/vape/listado";
    }

    
    @GetMapping("/actualizar/{idVape}")
    public String update(Vape vape, Model model) {
        vape = vapeService.getVape(vape);
        model.addAttribute("vape", vape);
        return "/vape/modificar";
    }

    @GetMapping("/eliminar/{idVape}")
    public String delete(Vape vape, Model model) {
        vape = vapeService.getVape(vape);
        
        vapeService.delete(vape);
        
        return "redirect:/vape/listar";
    }    
    
}
