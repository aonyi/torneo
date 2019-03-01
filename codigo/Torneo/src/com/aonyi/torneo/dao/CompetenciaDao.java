package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.Competencia;
import java.util.List;

/**
 * Clase Dao para Competencia
 * @author faguirre
 */
public class CompetenciaDao implements IEspecificDao<Competencia>{
     
    private final IGenericDao<Competencia> lista; 
    
    /**
     *
     * @param lista
     */
    public CompetenciaDao(IGenericDao<Competencia> lista){
        this.lista = lista;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Competencia> getLista(){
        return lista.getLista(Competencia.class);
    }

    @Override
    public Competencia buscarPorNombre(String nombre) {
        Competencia retorno = null;
        for(Competencia elemento: this.lista.getLista(Competencia.class)){
            retorno = (elemento.getNombre().equals(nombre))?elemento:null;            
        }
        return retorno;
    }

    @Override
    public void guardar(Competencia objeto) {
        this.lista.guardar(objeto);
    }

    @Override
    public Competencia buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Competencia objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
