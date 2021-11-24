
package objetos;

import java.io.Serializable;

/**
 *
 * @author ramssrez
 */
public class Pedido implements Serializable{
    private String nombre;
    private String dirección;
    private String pack;
    private String telefono;
    private String repartidor;
    private String tiempo;

    public Pedido() {
    }

    public Pedido(String nombre, String dirección, String pack, String telefono) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.pack = pack;
        this.telefono = telefono;
    }

    public Pedido(String nombre, String dirección, String pack, String repartidor, String tiempo) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.pack = pack;
        this.repartidor = repartidor;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nombre=" + nombre + ", direcci\u00f3n=" + dirección + ", pack=" + pack + ", repartidor=" + repartidor + ", tiempo=" + tiempo + '}';
    }
    
    
}
