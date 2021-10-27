/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.p1a;


import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author ramos
 */
@Controller
@Slf4j
public class ControladorInicio {
    @GetMapping("/")
    public String inicio(Model modelo){
        log.info("Entrando al Controlador inicio de MVC");
        var msg = "Tabla de vendedores";
        var persona = new Persona();
        persona.setNombre("Stiven");
        persona.setEnero("50");
        persona.setFebrero("50");
        persona.setMarzo("50");
        persona.setTotal("150");
        
        var persona2 = new Persona();
        persona2.setNombre("Oswaldo");
        persona2.setEnero("60");
        persona2.setFebrero("60");
        persona2.setMarzo("60");
        persona2.setTotal("180");
        
        var persona3 = new Persona();
        persona3.setNombre("Ramos");
        persona3.setEnero("70");
        persona3.setFebrero("70");
        persona3.setMarzo("70");
        persona3.setTotal("210");
        
        var persona4 = new Persona();
        persona4.setNombre("Hernadez");
        persona4.setEnero("80");
        persona4.setFebrero("80");
        persona4.setMarzo("80");
        persona4.setTotal("240");
        
        var personas = Arrays.asList(persona,persona2,persona3,persona4);
        
        modelo.addAttribute("msg",msg);
        modelo.addAttribute("personas",personas);
    return  "Index";
    
    
        
    }
}
