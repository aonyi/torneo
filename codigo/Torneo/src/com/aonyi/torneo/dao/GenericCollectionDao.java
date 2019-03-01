package com.aonyi.torneo.dao;

import com.aonyi.torneo.utils.TorneoLogger;
import java.util.*;
import java.util.logging.Level;

/**
 * Clase que implementa la interfaz genérica DAO utilizando colecciones.
 * @author faguirre
 * @param <T>
 */
public class GenericCollectionDao<T> implements IGenericDao<T>{
    private final List<T> lista;


    public GenericCollectionDao(){
        this.lista = new ArrayList<>();
    }
    
    @Override
    public void guardar(T objeto) {        
        lista.add(objeto);
        TorneoLogger.getLogger().log(Level.INFO,"Se a guardado correctamente: {0} ", objeto);
    }

    @Override
    public List<T> getLista(Class<T> tipo) {
        return lista;
    }

    @Override
    public void borrar(T objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T buscarPorNombre(Class<T> clase, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T buscarPorId(Class<T> clase, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    

   
}
