package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProcessRin {

    private List<RinClass> listaRines = new ArrayList<>();

    public ProcessRin() {
    }

    public ProcessRin(List<RinClass> listaRines) {
        this.listaRines = listaRines;
    }

    public void agregarRegistro(RinClass rinClass) {
        this.listaRines.add(rinClass);
    }

    public void modificarRegistro(int i, RinClass rinClass) {
        this.listaRines.set(i, rinClass);
    }

    public void eliminarRegistro(int i) {
        this.listaRines.remove(i);
    }

    public RinClass obtenerRegistro(int i) {
        return listaRines.get(i);
    }

    public int cantidadRegistro() {
        return this.listaRines.size();
    }

    public void ordenarLista() {
        Collections.sort(listaRines, new Comparator<RinClass>() {
            @Override
            public int compare(RinClass p1, RinClass p2) {
                return p1.getAerodinamica().compareTo(p2.getAerodinamica());
                //return p2.getAerodinamica().compareTo(p1.getAerodinamica());
            }
        });
    }
    
    public RinClass primerRin(){
        RinClass primerRin = listaRines.get(0);
        return primerRin;
    }
    
    public RinClass ultimoRin(){
        return listaRines.get(listaRines.size()-1);
    }

//    public int buscaCodigo(int codigo){
//        for(int i = 0; i < cantidadRegistro(); i++){
//            if(codigo == obtenerRegistro(i).getCodigo())return i;
//        }
//        return -1;
//    }
}
