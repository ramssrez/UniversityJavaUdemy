package com.ramssrez.app.domain;

import lombok.Data;

@Data
public class ClienteResponse {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private Long numeroCliente;

    public ClienteResponse(String nombre, String apellido, String fechaNacimiento, Long numeroCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroCliente = numeroCliente;
    }
}
