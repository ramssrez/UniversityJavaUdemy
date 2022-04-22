package com.ramssrez.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring tiene que saber que es un controlador
@RestController
//Esto es para el punto de acceso de la aplicacion
@RequestMapping("/hello")
//Etiqueta para quitar el warning
@SuppressWarnings("unused")
public class HelloController {


}
