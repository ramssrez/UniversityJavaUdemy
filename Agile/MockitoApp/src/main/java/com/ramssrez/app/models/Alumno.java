package com.ramssrez.app.models;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private Long id;
    private String nombre;
    private String apellido;
    private String carrera;
    private List<Materia> materias;

    public Alumno(Long id, String nombre, String apellido, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.materias = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public void agregarMateria(Materia materia){
        this.materias.add(materia);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alumno{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", carrera='").append(carrera).append('\'');
        sb.append(", materias=").append(materias);
        sb.append('}');
        return sb.toString();
    }
}
