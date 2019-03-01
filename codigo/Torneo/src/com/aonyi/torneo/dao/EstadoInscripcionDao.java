package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.EstadoInscripcion;
import java.util.List;

/**
 * Clase Dao para EstadoInscripcion
 * @author faguirre
 */
public class EstadoInscripcionDao implements IEspecificDao<EstadoInscripcion>{

    private final IGenericDao<EstadoInscripcion> lista;
    
    public EstadoInscripcionDao(IGenericDao lista){
        this.lista = lista;
    }
    
    @Override
    public List<EstadoInscripcion> getLista() {
        return this.lista.getLista(EstadoInscripcion.class);
    }

    @Override
    public void guardar(EstadoInscripcion objeto) {
        this.lista.guardar(objeto);
    }

    @Override
    public EstadoInscripcion buscarPorNombre(String nombre) {
        EstadoInscripcion retorno = null;
        for(EstadoInscripcion elemento: this.lista.getLista(EstadoInscripcion.class)){
            retorno = (elemento.getNombre().equals(nombre))?elemento:null;            
        }
        return retorno;
    }

    @Override
    public EstadoInscripcion buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(EstadoInscripcion objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
