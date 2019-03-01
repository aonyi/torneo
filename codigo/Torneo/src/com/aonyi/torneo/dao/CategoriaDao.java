package com.aonyi.torneo.dao;

import com.aonyi.torneo.modelo.Categoria;
import java.util.List;

/**
 * Clase Dao para Categoria
 * @author faguirre
 */
public class CategoriaDao implements IEspecificDao<Categoria>{
    
    private final IGenericDao<Categoria> lista;
    
    /**
     *
     * @param lista
     */
    public CategoriaDao(IGenericDao<Categoria> lista){
        this.lista = lista;
    }
    
    /**
     *
     * @return
     */
    public List<Categoria> getLista(){
        return lista.getLista(Categoria.class);
    }

    @Override
    public Categoria buscarPorNombre(String nombre) {
        Categoria retorno = null;
        for(Categoria elemento: this.lista.getLista(Categoria.class)){
            retorno = (elemento.getNombre().equals(nombre))?elemento:null;            
        }
        return retorno;
    }

    @Override
    public void guardar(Categoria objeto) {
        this.lista.guardar(objeto);
    }

    @Override
    public Categoria buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Categoria objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
