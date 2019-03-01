package com.aonyi.torneo.dao;
import java.util.List;

/**
 * Interface que establece el comportamiento de las clases DAO genéricas.
 * Estas son aquellas que dependen de la implementación de base.
 * En este práctico, hay dos implementaciones: en memoria (Collections)
 * y persistentes (Hibernate) con conexión a un MySql
 * @author faguirre
 * @param <T>
 */
public interface IGenericDao<T> {

    public void guardar(T objeto);
    public void borrar(T objeto);
    public List<T> getLista(Class<T> clase);
    public T buscarPorNombre(Class<T> clase, String nombre);
    public T buscarPorId(Class<T> clase, long id);
    
}
