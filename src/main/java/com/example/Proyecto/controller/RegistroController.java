package com.example.Proyecto.controller;

import com.example.Proyecto.domain.Vape;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.example.Proyecto.service.VapeService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/vape")
public class RegistroController {

    @Autowired
    private VapeService vapeService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var vapes = vapeService.getVapes(false);
        model.addAttribute("vapes", vapes);
        model.addAttribute("totalVapes", vapes.size());
        return "vape/listado";
        
    }

    @GetMapping("/nuevo")
    public String vapeNuevo(Vape vape) {
        return "vape/modifica";

    }

    @PostMapping("/guardar")
    public String arbolGuardar(Vape vape,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            vapeService.save(vape);
//            vape.setRutaImagen() // Necesita que le pase un parámetros con el cual settear el atributo imagen, falta el guardado de imagenes con firebase;
                    
        }
        vapeService.save(vape);
        return "redirect:/vape/listado";
    }

    @GetMapping("/eliminar/{idVape}")
    public String arbolEliminar(Vape vape) {
        vapeService.delete(vape);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idVape}")
    public String arbolModificar(Vape vape, Model model) {
        vape = vapeService.getVape(vape);
        model.addAttribute("arbol", vape);
        return "/vape/modifica";
    }
}
