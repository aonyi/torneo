package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.Torneo;
import java.util.List;

/**
 * Clase Dao para Torneo
 * @author faguirre
 */
public class TorneoDao implements IEspecificDao<Torneo>{
    private final IGenericDao<Torneo> lista;
    
    public TorneoDao(IGenericDao lista){
        this.lista = lista;
    }
    @Override
    public void guardar(Torneo objeto) {
        this.lista.guardar(objeto);
    }

    @Override
    public List<Torneo> getLista() {
        return lista.getLista(Torneo.class);
    }

    @Override
    public Torneo buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Torneo buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Torneo objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
