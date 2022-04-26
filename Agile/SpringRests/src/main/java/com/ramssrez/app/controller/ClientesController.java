package com.ramssrez.app.controller;

import com.ramssrez.app.domain.ClienteResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping("/saludo/{nombre}")
    public ResponseEntity<String> saludConNombre(@PathVariable String nombre){
        String response;
        if (nombre.length()<2){
            response = "Nombre inválido";
            return new ResponseEntity<String>(response,HttpStatus.BAD_REQUEST);
        }
        response = "Saludos " + nombre;
        return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
        //return ResponseEntity.ok(saludo);
    }

    @GetMapping("/cliente")
    public ResponseEntity<ClienteResponse> retornarCliente(@RequestParam("nombre") String nombre,
                                                           @RequestParam("apellido") String apellido,
                                                           @RequestParam("fechaNacimiento") String fechaNacimiento,
                                                           @RequestParam("numeroCliente") Long numeroCliente
                                                           ){
        //path = http://localhost:8585/cliente?nombre=Raúl&apellido=Ramírez&fechaNacimiento=14-06-1995&numeroCliente=152362
        if (nombre.length()<3 ||  apellido.length() < 2 || numeroCliente.toString().length()<5){
            return new ResponseEntity<ClienteResponse>(HttpStatus.BAD_REQUEST);
        }

        ClienteResponse clienteResponse = new ClienteResponse(nombre,apellido,fechaNacimiento,numeroCliente);
        return new ResponseEntity<ClienteResponse>(clienteResponse,HttpStatus.ACCEPTED);
    }
}
