
package dominio;

import java.util.Date;

public class Cliente extends Persona {
    private int idCleinte;
    private Date fechaRegistro;
    private boolean vip;
    
    public Cliente(){
        
    }

    public int getIdCleinte() {
        return idCleinte;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    
    
}
