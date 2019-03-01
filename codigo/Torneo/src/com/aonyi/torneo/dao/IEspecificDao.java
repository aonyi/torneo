package com.aonyi.torneo.dao;
import java.util.List;

/**
 * Interface que establece el comportamiento de los DAO específicos de clases.
 * Estos son los que dependen de la clase que va a persistir. Por ej. para la 
 * clase "Aspirante" se crea una clase "AspiranteDao". 
 * Esta última clase no depende de la implementación subyacente (Collection o Hibernate)
 * ya que recibe dicha configuración por parámetro.
 * @author faguirre
 * @param <T>
 */
public interface IEspecificDao<T> {
    
    public void guardar(T objeto);
    public List<T> getLista();
    public T buscarPorNombre(String nombre);
    public T buscarPorId(long id);
    public void borrar(T objeto);
    
}
