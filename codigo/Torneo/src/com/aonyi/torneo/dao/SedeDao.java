package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.Sede;
import java.util.List;

/**
 * Clase Dao para Sede
 * @author faguirre
 */
public class SedeDao implements IEspecificDao<Sede>{
    private final IGenericDao<Sede> lista;
    
    public SedeDao(IGenericDao lista){
        this.lista = lista;
    }
    
    @Override
    public void guardar(Sede objeto) {
        this.lista.guardar(objeto);
    }

    @Override
    public List<Sede> getLista() {
        return this.lista.getLista(Sede.class);
    }

    @Override
    public Sede buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sede buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Sede objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
