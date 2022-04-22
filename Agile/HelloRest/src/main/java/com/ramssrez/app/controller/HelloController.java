package com.ramssrez.app.controller;

import com.ramssrez.app.dto.HelloDto;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/world")
    public HelloDto hello(){
        return new HelloDto("Hello World!");
    }
}
