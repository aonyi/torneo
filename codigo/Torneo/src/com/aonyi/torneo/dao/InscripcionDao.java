package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.Inscripcion;
import java.util.List;

/**
 * Clase Dao para Inscripcion
 * @author faguirre
 */
public class InscripcionDao implements IEspecificDao<Inscripcion>{
    private final IGenericDao<Inscripcion> lista;
    
    public InscripcionDao(IGenericDao lista){
        this.lista = lista;
    }
    
    @Override
    public List<Inscripcion> getLista() {
        return lista.getLista(Inscripcion.class);
    }

    @Override
    public void guardar(Inscripcion objeto) {
        lista.guardar(objeto);
    }

    @Override
    public Inscripcion buscarPorNombre(String nombre) {
        Inscripcion retorno = null;
        for(Inscripcion elemento: this.lista.getLista(Inscripcion.class)){
            retorno = (elemento.getNombre().equals(nombre))?elemento:null;            
        }
        return retorno;
    }

    @Override
    public Inscripcion buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Inscripcion objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
