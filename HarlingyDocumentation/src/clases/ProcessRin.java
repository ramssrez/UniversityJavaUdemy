package clases;

import java.util.ArrayList;
import java.util.List;

public class ProcessRin {
    private List <RinClass> listaRines = new ArrayList<>();

    public ProcessRin() {
    }
    
    public ProcessRin(List<RinClass> listaRines){
        this.listaRines = listaRines;
    }
      public void agregarRegistro(RinClass rinClass){
        this.listaRines.add(rinClass);
    }

    public void modificarRegistro(int i, RinClass rinClass){
        this.listaRines.set(i, rinClass);
    }
    
    public void eliminarRegistro(int i){
        this.listaRines.remove(i);
    }
    
    public RinClass obtenerRegistro(int i){
        return listaRines.get(i);
    }
    
    public int cantidadRegistro(){
        return this.listaRines.size();
    }
    
    public void ordenarLista(){
        
    }
    
//    public int buscaCodigo(int codigo){
//        for(int i = 0; i < cantidadRegistro(); i++){
//            if(codigo == obtenerRegistro(i).getCodigo())return i;
//        }
//        return -1;
//    }

}
