package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.CambioEstado;
import java.util.List;

/**
 * Clase Dao para CambioEstado
 * @author faguirre
 */
public class CambioEstadoDao implements IEspecificDao<CambioEstado> {
    
    private final IGenericDao<CambioEstado> lista;
    
    public CambioEstadoDao(IGenericDao lista){
        this.lista = lista;
    }

    @Override
    public List<CambioEstado> getLista() {
        return this.lista.getLista(CambioEstado.class);
    }

    @Override
    public void guardar(CambioEstado objeto) {
        this.lista.guardar(objeto);
    }

    @Override
    public CambioEstado buscarPorNombre(String nombre) {
        CambioEstado retorno = null;
        for(CambioEstado elemento: this.lista.getLista(CambioEstado.class)){
            retorno = (elemento.getInscripcion().getAspirante().getNombre().equals(nombre))?elemento:null;            
        }
        return retorno;
    }

    @Override
    public CambioEstado buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(CambioEstado objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
