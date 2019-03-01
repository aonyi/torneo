package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.Escuela;
import java.util.List;

/**
 * Clase Dao para Escuela
 * @author faguirre
 */
public class EscuelaDao implements IEspecificDao<Escuela>{
    
    private final IGenericDao<Escuela> lista;
    
    public EscuelaDao(IGenericDao<Escuela> lista){
        this.lista = lista;
    }
    
    @Override
    public List<Escuela> getLista(){
        return lista.getLista(Escuela.class);
    }
    
    @Override
    public void guardar(Escuela objeto){
        this.lista.guardar(objeto);
    }

    @Override
    public Escuela buscarPorNombre(String nombre) {
        Escuela retorno = null;
        for(Escuela elemento: this.lista.getLista(Escuela.class)){
            retorno = (elemento.getNombre().equals(nombre))?elemento:null;            
        }
        return retorno;
    }
    
    @Override
    public Escuela buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Escuela objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
