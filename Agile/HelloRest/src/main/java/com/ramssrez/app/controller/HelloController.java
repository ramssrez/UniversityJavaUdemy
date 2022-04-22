package com.ramssrez.app.controller;

import com.ramssrez.app.dto.HelloDto;
import com.ramssrez.app.service.IPoliteSalutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring tiene que saber que es un controlador
@RestController
//Esto es para el punto de acceso de la aplicacion
@RequestMapping("/hello")
//Etiqueta para quitar el warning
@SuppressWarnings("unused")
public class HelloController {

    private IPoliteSalutation poleteSalutation;

    public HelloController(IPoliteSalutation poleteSalutation) {
        this.poleteSalutation = poleteSalutation;
    }

    /*
    @Autowired
    public void setPoliteSalutation(IPoliteSalutation poleteSalutation){
        this.poleteSalutation = poleteSalutation;
    }

     */

    @GetMapping("/world")
    public HelloDto hello(){
        return new HelloDto("Hello World!");
    }

    @GetMapping("/polite")
    public HelloDto helloPolite(){
        return new HelloDto(poleteSalutation.getPoliteSalutation());
    }
}
