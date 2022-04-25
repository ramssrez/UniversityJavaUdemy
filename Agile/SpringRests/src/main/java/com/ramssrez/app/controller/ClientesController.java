package com.ramssrez.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientesController {

    @RequestMapping("/saludo")
    @ResponseStatus(HttpStatus.CREATED)
    public String saludo(){
        return "Hello World";
    }

    @RequestMapping("/saludo2")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saludoDos(){
        String saludo = "Hola mundo dos";
        return new ResponseEntity<String>(saludo,HttpStatus.ACCEPTED);
        //return ResponseEntity.ok(saludo);
    }
}
