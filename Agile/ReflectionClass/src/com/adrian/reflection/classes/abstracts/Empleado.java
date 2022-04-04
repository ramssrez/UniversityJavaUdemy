package com.adrian.reflection.classes.abstracts;

import com.adrian.reflection.classes.constnts.PuestosEnum;
import com.adrian.reflection.classes.domain.EnumExample;

import java.time.LocalDate;

public class Empleado {
    private PuestosEnum puestosEnum = PuestosEnum.DEVELOPER;
    private LocalDate fechaIngreso = LocalDate.now();
    private double sueldo = 10000;

    public PuestosEnum getPuestosEnum() {
        return puestosEnum;
    }

    public void setPuestosEnum(PuestosEnum puestosEnum) {
        this.puestosEnum = puestosEnum;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
