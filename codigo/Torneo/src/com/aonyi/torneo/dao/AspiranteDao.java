package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.Aspirante;
import java.util.List;

/**
 * Clase Dao para Aspirante
 * @author faguirre
 */
public class AspiranteDao implements IEspecificDao<Aspirante> {
    
    private final IGenericDao<Aspirante> lista;
    
    public AspiranteDao(IGenericDao lista){
        this.lista = lista;
    }
    
    @Override
    public void guardar(Aspirante objeto){
        this.lista.guardar(objeto);
    }
    
    @Override
    public List<Aspirante> getLista(){
        return this.lista.getLista(Aspirante.class);
    }

    @Override
    public Aspirante buscarPorNombre(String nombre) {
        Aspirante retorno = null;
        for(Aspirante elemento: this.lista.getLista(Aspirante.class)){
            retorno = (elemento.getNombre().equals(nombre))?elemento:null;            
        }
        return retorno;
    }

    @Override
    public Aspirante buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Aspirante objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
